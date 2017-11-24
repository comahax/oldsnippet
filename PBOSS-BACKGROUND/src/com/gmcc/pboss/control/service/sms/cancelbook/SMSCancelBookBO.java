package com.gmcc.pboss.control.service.sms.cancelbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.CancelBookResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSCancelBookBO extends AbstractControlBean implements
		SMSCancelBook {
	private static Logger logger = Logger.getLogger(SMSCancelBookBO.class);
	private static String TITLE_COLUMNSIZE = "订单号"
			+ SMSProtocol.WORD_SLIT_SYMBOL + "客户姓名"
			+ SMSProtocol.WORD_END_SYMBOL + "20" + SMSProtocol.WORD_SLIT_SYMBOL
			+ "30";

	public String doCancelBook(String mobile, String streamNumber)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			// 1.获取归属地市,已经在拦截器里面拿到

			// 2.获取用户名称
			String employeename = doGetUserName(mobile);
			// 3.更新短信确认信息
			SmsconfirmVO scVO = updateMessage(mobile, streamNumber,
					employeename);
			// 4超时检查
			doTimeout(scVO.getSendtime(), employeename);
			// 5订购确认
			doConfim(scVO.getOrderid(), employeename);
			// 6、 返回短信营业厅:返回码取“0”，说明取“成功”。
			return doReturnSuccVal(scVO.getOrderid(), employeename).toString();

		} catch (SMSException e) {
			// SMSException 不需要回滚事务
			logger.info(e.getMessage());
			return ((SMSException) e).getErrCode()+ SMSProtocol.WORD_SLIT_SYMBOL+ ((SMSException) e).getMessage()+ SMSProtocol.WORD_END_SYMBOL;
		} catch (Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}

	}

	/*
	 * 1、 获取号码归属地市 根据号码查询号段表(IM_PR_NOSECT)获取地市标识，查询SQL大致如下： select BOSSAREA from
	 * IM_PR_NOSECT where '13800138000' between beginno and endno;
	 * 如果无数据则返回，返回码取“1”，说明取“获取号码归属地市失败”，订单号留空，客户名称默认取“客户”；如果存在多条数据则取第一条。保存归属地市字段（即BOSSAREA，地市字母缩写，如“GZ”），后续确定地市库使用。
	 */
	public String doGetBossArea(String mobile) throws Exception {
		return ServiceSmsBOHelper.getMobileArea(mobile, user);
	}

	/**
	 * 2、 获取客户名称
	 * 查询渠道人员基本信息表(CH_PW_EMPLOYEE)，匹配公务机号码（OFFICETEL）等于手机号码、用工状态为在岗（即EMPSTATUS=0）、是否为店主字段为是（即ISNET=1），
	 * 客户名称取姓名字段，如果无数据或姓名为空，则默认取“客户”。
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public String doGetUserName(String mobile) throws Exception {
		String name = "";
		Employee employee = (Employee) BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam params = new EmployeeDBParam();
		params.set_ne_empstatus("0");
		params.set_se_officetel(mobile);
		params.set_ne_isnet("1");
		DataPackage dp = employee.doQuery(params);
		List list = dp.getDatas();
		if (list.size() > 0) {
			EmployeeVO customer = (EmployeeVO) list.get(0);
			if (!StringUtils.isEmpty(customer.getEmployeename())) {
				name = customer.getEmployeename();
			}
		} else {
			name = "客户";
		}
		return name;
	}

	/**
	 * 3、 更新短信确认信息
	 * 根据类型（订购二次确认）、手机号码、流水号、状态（待回复）、通知时间（大于等于当天零时零分零秒）查询分销短信确认表（FX_SW_SMSCONFIRM），如果无数据则返回，返回码取“1”，说明取“记录不存在”，填写订单号（留空）和客户名称；否则继续。
	 * 如果结果数据有多条，则取通知时间最早的一条，更新分销短信确认表，回复时间取当前时间，状态修改为已回复，回复描述填写“放弃订购”。
	 * 
	 * @throws Exception
	 */
	public SmsconfirmVO updateMessage(String mobile, String streamNumber,
			String employeename) throws Exception {
		Smsconfirm smsconfirm = (Smsconfirm) BOFactory.build(
				SmsconfirmBO.class, user);
		SmsconfirmDBParam param = new SmsconfirmDBParam();
		param.set_se_mobileno(mobile);
		param.set_se_stream(streamNumber);
		// //状态待回复 是多少?
		param.set_se_state("WAITREP");
		// //类型(订购二次确认)?
		param.set_se_type("ORDERCON");
		param.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(),
				"yyyy-MM-dd")
				+ " 00:00:00");
		// sendtime 通知时间
		param.set_orderby("sendtime");
		param.setDataOnly(true);
		param.set_pagesize("0");
		DataPackage dp = smsconfirm.doQuery(param);
		List list = dp.getDatas();
		if (list == null || list.size() == 0) {
			String message = "记录不存在" + SMSProtocol.WORD_END_SYMBOL
					+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL+SMSProtocol.WORD_SLIT_SYMBOL+ employeename;
			throw new SMSException(message, CancelBookResult.RET_TYPE_FAIL_1);
		} else {
			SmsconfirmVO scVO = (SmsconfirmVO) list.get(0); // 取通知时间最早的一条
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("放弃订购");
			return smsconfirm.doUpdate(scVO);
		}

	}

	/**
	 * 4、 超时检查
	 * 获取超时分钟数：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“41”，如果无数据或参数值非大于零的整数，则超时分钟数默认取值为20。
	 * 判断 当前时间-通知时间 是否大于超时分钟数，如果超时则返回，返回码取“2”，说明取“确认超时”，填写订单号（留空）和客户名称；否则继续。
	 * 
	 * @throws Exception 
	 */
	public void doTimeout(Date sendtime, String employeename) throws Exception {
		boolean isTimeOut;
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String paramvalue = sysparam.doFindByID("41", "pboss_fx");
		long now = System.currentTimeMillis();
		long past = sendtime.getTime();
		if (paramvalue != null) {
			isTimeOut = now - past
					- (Double.parseDouble(paramvalue) * 1000 * 60) > 0;
		} else {
			isTimeOut = now - past - (Double.parseDouble("20") * 1000 * 60) > 0;
		}
		if (isTimeOut) {
			throw new SMSException("确认超时" + SMSProtocol.WORD_END_SYMBOL
					+TITLE_COLUMNSIZE+ SMSProtocol.WORD_END_SYMBOL+  SMSProtocol.WORD_SLIT_SYMBOL+ employeename,
					CancelBookResult.RET_TYPE_FAIL_2);
		}
	}

	/**
	 * 5、 订购确认 根据订单编号查询订单表，如果无数据则返回，返回码取“3”，说明取“订单信息不存在” ，填写订单号（留空）和客户名称；否则继续；
	 * 检查订单状态是否为“待确认”，如果不是则返回，返回码取“4”，说明取“订单状态错误”，填写订单号和客户名称；否则继续；
	 * 修改“订单状态”为作废、“状态变更时间”为当前时间、“备注”为放弃订购、“是否确认”为0（否）。
	 * 
	 * @throws Exception
	 */
	public void doConfim(String orderid, String employeename) throws Exception {
		Order order = (Order) BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderid(orderid);
		orderVO = order.doFindByPk(orderid);
		if (orderVO == null) {
			throw new SMSException("订单信息不存在" + SMSProtocol.WORD_END_SYMBOL
					 + TITLE_COLUMNSIZE+ SMSProtocol.WORD_END_SYMBOL+SMSProtocol.WORD_SLIT_SYMBOL+employeename,
					CancelBookResult.RET_TYPE_FAIL_3);
		}
		// $FX_ORDERFSTATE 订单状态
		if (!"WAITCON".equals(orderVO.getOrderstate())) {
			throw new SMSException("订单状态错误" + SMSProtocol.WORD_END_SYMBOL
					 +TITLE_COLUMNSIZE+ SMSProtocol.WORD_END_SYMBOL+SMSProtocol.WORD_SLIT_SYMBOL+ employeename,
					CancelBookResult.RET_TYPE_FAIL_4);
		}
		// 订单作废
		orderVO.setOrderstate("CANCEL");
		orderVO.setStatechgtime(new Date());
		orderVO.setMemo("放弃订购");
		orderVO.setConfirmflag(new Integer("0"));
		order.doUpdate(orderVO);
	}

	private CancelBookResult doReturnSuccVal(String orderid, String customName)
			throws Exception {
		CancelBookResult result = new CancelBookResult();
		List<String> list = new ArrayList<String>();
		StringBuffer datas = new StringBuffer();
		datas.append(orderid);
		if (customName != null)
			datas.append(SMSProtocol.WORD_SLIT_SYMBOL).append(customName);
		list.add(datas.toString());
		result.setRet(CancelBookResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		result.setDatas(list);
		return result;
	}
}
