package com.gmcc.pboss.control.service.sms.disformfinishenrol;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.MdbgBase;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.resource.nosect.NosectDBParam;
import com.gmcc.pboss.business.resource.nosect.NosectVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.resource.nosect.Nosect;
import com.gmcc.pboss.control.resource.nosect.NosectBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.control.service.sms.orderquery.SMSOrderQueryBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.DisformFinishenrolResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.hibernate3.SessionFactoryContextHolder;

public class SMSDisformFinishenrolBO extends AbstractControlBean implements SMSDisformFinishenrol{
	private static Logger logger = Logger.getLogger(SMSDisformFinishenrolBO.class);
	
	
	public String doResult(String mobile, String orderID) throws Exception {
		// TODO Auto-generated method stub
		try{
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
//			2	获取配送商信息(渠道ID)
			String wayid = this.doGetWayId(mobile);
//			3.修改配送单
			DisformVO disformVO = this.doUpdatDisForm(orderID, wayid);
//			4.登记短信确认记录
			this.doSmsConfirm(orderID, disformVO.getRecetel());
//			 5、	通知合作商签收
			this.doAskSign(disformVO.getRecetel(), disformVO.getRecename(), orderID);
			
			DisformFinishenrolResult result = new DisformFinishenrolResult();
			List<String> list = new ArrayList<String>();
			list.add(orderID);
			result.setRet(DisformFinishenrolResult.RET_TYPE_SUCC_0);
			result.setMessage("成功");
			result.setDatas(list);
			return result.toString();
		}catch(SMSException e){
			LoggerUtils.error(e, logger);
			throw e;
		}catch(Exception e){
			LoggerUtils.error(e, logger);
			throw e;
		}
	}

	
	/*
	 *1 . 获取号码归属地市
	 * 如果无数据则返回，返回码取“1”，说明取“获取号码归属地市失败”；
	 * 如果存在多条数据则取第一条。保存归属地市字段
	 * （即BOSSAREA，地市字母缩写，如“GZ”），后续确定地市库使用。
	 */
	public String doGetBossArea(String mobile) throws Exception{
		Nosect nosect = (Nosect)BOFactory.build(NosectBO.class, user);
		NosectDBParam nosectDBParam = new NosectDBParam();
		nosectDBParam.setDataOnly(true);
		nosectDBParam.set_snm_beginno(mobile);
		nosectDBParam.set_snl_endno(mobile);
		DataPackage nosectDp = nosect.doQuery(nosectDBParam);
		if(nosectDp.getDatas().size() == 0){
			throw new SMSException("获取号码归属地市失败",DisformFinishenrolResult.RET_TYPE_FAIL_1);
		}
		NosectVO nosectVO = (NosectVO)nosectDp.getDatas().get(0);
		return nosectVO.getBossarea();
	}
	
	/*
	 * 2	获取配送商信息(渠道ID)
	 * 查询渠道人员基本信息表(CH_PW_EMPLOYEE)，匹配公务机号码（OFFICETEL）等于号码、
	 * 用工状态等于0（即EMPSTATUS=0）、是否为店主字段为配送（即ISNET=3），如果无数据则返回，返回码取“1”，说明取“号码未登记”；
	 * 如果存在多条数据则取第一条，记录渠道编码。
	 */
	public String doGetWayId(String mobile) throws Exception{
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.setDataOnly(true);
		employeeDBParam.set_se_officetel(mobile);
		employeeDBParam.set_ne_empstatus("0");
		employeeDBParam.set_ne_isnet("3");//是否为店主字段为配送（即ISNET=3）added by yde
		DataPackage dp = employee.doQuery(employeeDBParam);
		if(dp.getDatas().size() == 0){
			throw new SMSException("号码未登记",DisformFinishenrolResult.RET_TYPE_FAIL_1);
		}
		EmployeeVO vo = (EmployeeVO)dp.getDatas().get(0);
		return vo.getWayid();
	}
	
	/*
	 * 3.修改配送单
	 * 返回配送单
	 */
	public DisformVO doUpdatDisForm(String orderID,String wayid) throws Exception{
//		根据订单编号、配送商编码（即渠道编码）查询配送单表（FX_SW_DISFORM)），
//		如果无数据则返回，返回码取“2”，说明取“配送单信息不存在”；否则继续；
//		如果配送单数据大于一条记录则返回，返回码取“3”，说明取“配送单信息错误”；否则继续；
		Disform disformBO = (DisformBO) BOFactory.build(DisformBO.class,user);
		DisformDBParam disformParam = new DisformDBParam();
		disformParam.setDataOnly(true);
		disformParam.set_se_discomcode(wayid);
		disformParam.set_se_orderid(orderID);
		DataPackage dp = disformBO.doQuery(disformParam);
		if( null == dp || null == dp.getDatas() ||dp.getDatas().size() < 1)
			throw new SMSException("配送单信息不存在",DisformFinishenrolResult.RET_TYPE_FAIL_2);
		if(dp.getDatas().size()>1)
			throw new SMSException("配送单信息错误",DisformFinishenrolResult.RET_TYPE_FAIL_3);
		
//		判断配送单状态是否为“配送完成”，如果是则返回，返回码取“5”，
//		说明取“配送单已完成登记，请勿重复登记。”；否则继续；
		DisformVO disformVO = (DisformVO)dp.getDatas().get(0);
		if("DISOVER".equals(disformVO.getDisstate()))
			throw new SMSException("配送单已完成登记，请勿重复登记",DisformFinishenrolResult.RET_TYPE_FAIL_5);
//		判断配送单状态是否为“待配送”或“配送中”，如果不是则返回，
//		返回码取“4”，说明取“配送状态错误”；否则继续；
//		将配送单状态修改为“配送完成”。
		if("WAITDIS".equals(disformVO.getDisstate()) || "DISING".equals(disformVO.getDisstate())){
			disformVO.setDisstate("DISOVER");
			disformBO.doUpdate(disformVO);
			OrderBO orderbo = (OrderBO)BOFactory.build(OrderBO.class,user);
			OrderVO ordervo = orderbo.doFindByPk(orderID);
			if(ordervo != null){
				ordervo.setDisovertime(new Date());
				orderbo.doUpdate(ordervo);
			}
		}else{
			throw new SMSException("配送状态错误",DisformFinishenrolResult.RET_TYPE_FAIL_4);
		}
		return disformVO;
	}

	/*
	 * 4、	登记短信确认记录
	 */
	public void doSmsConfirm(String orderID,String recPhone) throws Exception {
//		新增数据到分销短信确认表（FX_SW_SMSCONFIRM），编号取库表序列，类型取合作商签收
//		，确认流水号取订单末尾4位，手机号码取配送单中的收货人电话，关联订单号取订单编号，
//		状态取待回复，通知时间取当前时间，回复时间和回复描述留空。
		String subOrderID = orderID.substring(orderID.length()-4);
		Smsconfirm smsconfirmBO = (SmsconfirmBO) BOFactory.build(SmsconfirmBO.class,user);
		SmsconfirmVO vo = new SmsconfirmVO();
		vo.setOrderid(orderID);
		vo.setStream(subOrderID);
		vo.setType("PARSIGN");
		vo.setMobileno(recPhone);
		vo.setState("WAITREP");
		vo.setSendtime(new Date());
		smsconfirmBO.doCreate(vo);
	}
	
	
	/*
	 * 5、	通知合作商签收
	 * 新增数据到短信待发送表(CH_SMS_WAITREQ)，字段取值如下：短信类型取3；
		发送号码：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，
		参数标识为“42”，发送号码取参数值。接收号码：取配送单中的收货人电话；
		短信内容：调用商品订购短信公用方法（合作商签收确认）获取。客户名称取配送单中的收获人姓名
		如果无数据或姓名为空，则默认取“客户”；日期取当前时间；
		确认流水号取订单末尾四位；
		说明：如果发送号码、接收号码或短信内容任一个为空，可不发送短信通知。
	 */
	public void doAskSign(String recPhone,String recUser,String orderID) throws Exception{
		if(null == recPhone || recPhone.trim().length() == 0)
			return;
		String subOrderID = orderID.substring(orderID.length()-4);
		Sysparam SysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
		String sendPhone = SysparamBO.doFindByID("42", "pboss_fx");
		if( null == sendPhone || sendPhone.trim().length() == 0)
			return;
		String smsContent = "";
		if(null == recUser || recUser.trim().length() == 0)
			recUser = "客户";
		
//		尊敬的{CUSTNAME}，{YEAR}年{MONTH}月{DAY}日配送的物资（订单号：{ ORDERID }）
//		是否收到，回复"Q{STREAM}"确认签收，回复"N{STREAM}"拒绝签收。广东移动。
		Calendar calendar = Calendar.getInstance();		
		Map<String,String> map = new HashMap<String,String>();
		map.put("CUSTNAME", recUser);
		map.put("YEAR", ""+calendar.get(Calendar.YEAR));
		map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
		map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
		map.put("ORDERID", orderID);
		map.put("STREAM", subOrderID);
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		smsContent = smstmplBO.doGenSMS("FX_ORDER_PARSIGNCON", map);
		if( null == smsContent || "".equals(smsContent.trim()))
			return ;
		Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
		waitreqBO.doInsert2(new Short("3"), smsContent, sendPhone,recPhone);

	}
	
}


