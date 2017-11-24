package com.gmcc.pboss.control.service.sms.secconfirm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.result.SecondConfirmResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSComOrderSecondConfirmBO extends AbstractControlBean implements
		SMSComOrderSecondConfirm {
	
	private static Logger logger = Logger.getLogger(SMSComOrderSecondConfirmBO.class);
	private static String TITLE_COLUMNSIZE = "订单号"
			+ SMSProtocol.WORD_SLIT_SYMBOL + "客户姓名"
			+ SMSProtocol.WORD_END_SYMBOL + "20" + SMSProtocol.WORD_SLIT_SYMBOL
			+ "30";
	
	public String doResult(String mobile, String streamNumber) throws Exception {
		
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			String customerName = this.getCustomerName(mobile);
			SmsconfirmVO scVO = this.updateMSConfirmInfo(mobile, streamNumber, customerName);
			this.checkOvertime(scVO.getSendtime(), customerName);
			this.orderConfirm(scVO.getOrderid(), customerName);
			this.nextProcess(scVO.getOrderid());
			return this.doReturnSuccVal(scVO.getOrderid(),customerName).toString();
			
		}catch(SMSException e) {
			// SMSException 不需要回滚事务
			logger.info(e.getMessage());
			return ((SMSException)e).getErrCode() + SMSProtocol.WORD_SLIT_SYMBOL + ((SMSException)e).getMessage() + SMSProtocol.WORD_END_SYMBOL;
		}
		catch(Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}
	}
	
	
	private String getCustomerName(String mobile) throws Exception {
		Employee eBO = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam eParam = new EmployeeDBParam();
		eParam.set_se_officetel(mobile);
		eParam.set_ne_empstatus("0");
		eParam.set_ne_isnet("1");
		eParam.setDataOnly(true);
		DataPackage edp = eBO.doQuery(eParam);
		List<EmployeeVO> elist = edp.getDatas();
		String cutomerName = "客户";
		if(elist.size() > 0) {
			EmployeeVO empVO = elist.get(0);
			if(!StringUtils.isEmpty(empVO.getEmployeename())) {
				cutomerName = empVO.getEmployeename();
			}
		}
		return cutomerName;
	}
	/**
	 * 更新短信确认信息
	 * @param mobile
	 * @param streamNumber
	 * @param customerName 客户姓名
	 * @return 通知时间
	 * @throws Exception
	 */
	private SmsconfirmVO updateMSConfirmInfo(String mobile, String streamNumber, String customerName) throws Exception {
		
		Smsconfirm scBO = (Smsconfirm)BOFactory.build(SmsconfirmBO.class,user, BOFactory.PROPAGATION_REQUIRES_NEW);
		SmsconfirmDBParam scParam = new SmsconfirmDBParam();
		scParam.set_se_type("ORDERCON");
		scParam.set_se_mobileno(mobile);
		scParam.set_se_stream(streamNumber);
		scParam.set_se_state("WAITREP");
		scParam.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd")+" 00:00:00");
		scParam.set_orderby("sendtime"); // 按通知时间升序排列
		scParam.setDataOnly(true);
		scParam.set_pagesize("0");
		DataPackage dp = scBO.doQuery(scParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			String message = "确认记录不存在" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_1);
		}else {
			SmsconfirmVO scVO = (SmsconfirmVO)list.get(0); // 取通知时间最早的一条
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("确认订购");
			return scBO.doUpdate(scVO);
		}
	
	}
	/**
	 * 超时检查
	 * @param sendtime 通知时间
	 * @throws Exception
	 */
	private void checkOvertime(Date sendtime, String customerName) throws Exception {
		Sysparam spBO = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String overtimeValue = spBO.doFindByID(41L, "pboss_fx");
		if(overtimeValue == null || "".equals(overtimeValue) 
				|| Integer.parseInt(overtimeValue) <= 0) {
			overtimeValue = "20";
		}
		double interval = PublicUtils.compareMinute(sendtime, new Date());
		if(interval > Double.parseDouble(overtimeValue)) {
			String message = "确认超时" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_2);
		}
	}
	/**
	 * 订购确认
	 * @param orderid
	 * @throws Exception
	 */
	private void orderConfirm(String orderid, String customerName) throws Exception {
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		if(orderVO == null) {
			String message = "订单信息不存在" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_3);
		}
		
		if(!"WAITCON".equals(orderVO.getOrderstate())) {
			String message = "订单状态错误" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL + orderVO.getOrderid()
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_4);
		}
		
		Orderproce opBO = (Orderproce)BOFactory.build(OrderproceBO.class, user);
		OrderproceDBParam opParam = new OrderproceDBParam();
		opParam.set_ne_flowid(orderVO.getFlowid().toString());
		opParam.set_se_instate("WAITCON");
		opParam.setDataOnly(true);
		opParam.set_pagesize("0");
		DataPackage dp = opBO.doQuery(opParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			String message = "订单流程错误" + SMSProtocol.WORD_END_SYMBOL
			+ TITLE_COLUMNSIZE + SMSProtocol.WORD_END_SYMBOL + orderVO.getOrderid()
			+ SMSProtocol.WORD_SLIT_SYMBOL + customerName;
			throw new SMSException(message,SecondConfirmResult.RET_TYPE_FAIL_4);
		}
		
		OrderproceVO opVO = (OrderproceVO)list.get(0);
		orderVO.setOrderstate(opVO.getOutstate());
		orderVO.setConfirmflag(1);//将是否确认修改为1（是）
		orderVO.setStatechgtime(new Date());//将状态变更时间修改为当前时间 by yde
		orderBO.doUpdate(orderVO);
		
	}
	/**
	 * 调用订单下一步处理
	 * @param orderid
	 * @throws Exception
	 */
	private void nextProcess(String orderid) throws Exception {
		
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		orderBO.doNextProcess(orderid);
	}
	
	private SecondConfirmResult doReturnSuccVal(String orderid, String customName) throws Exception {
		SecondConfirmResult result = new SecondConfirmResult();
		List<String> list = new ArrayList<String>();
		StringBuffer datas = new StringBuffer();
		datas.append(orderid);
		if(customName != null)
			datas.append(SMSProtocol.WORD_SLIT_SYMBOL).append(customName);
		list.add(datas.toString());
		result.setRet(SecondConfirmResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		result.setDatas(list);
		return result;
	}

}
