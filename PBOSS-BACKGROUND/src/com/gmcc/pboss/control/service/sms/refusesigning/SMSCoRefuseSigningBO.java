package com.gmcc.pboss.control.service.sms.refusesigning;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.CoConfirmSigningResult;
import com.gmcc.pboss.service.sms.result.CoRefuseSigningResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSCoRefuseSigningBO extends AbstractControlBean implements
		SMSCoRefuseSigning {

	private static Logger logger = Logger.getLogger(SMSCoRefuseSigningBO.class);
	
	public String doResult(String mobile, String streamNumber) throws Exception {
		// TODO Auto-generated method stub
		String orderid = "";
		try{
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()+LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass().getSimpleName());
			SmsconfirmVO scVO = this.updateSMSConfirmInfo(mobile, streamNumber);
			orderid = scVO.getOrderid();
			this.refuseSigningCheckIn(scVO.getOrderid());
			//调用短信发送方法
			this.sendMes(mobile,"订单["+orderid+"]拒绝签收成功");
			return this.doReturnSuccVal().toString();
		}catch(SMSException e) {
			// SMSException 不需要回滚事务
			logger.info(e.getMessage());
			//调用短信发送方法
			this.sendMes(mobile,e.getMessage());
			return ((SMSException)e).getErrCode() + SMSProtocol.WORD_SLIT_SYMBOL + ((SMSException)e).getMessage() + SMSProtocol.WORD_END_SYMBOL;
		}catch(Exception e) {
			LoggerUtils.error(e, logger);
			throw new SMSException("失败",CoConfirmSigningResult.RET_TYPE_FAIL_111);
		}
	}

	/**
	 * 更新短信确认信息
	 * @param mobile
	 * @param streamNumber
	 * @return 通知时间
	 * @throws Exception
	 */
	private SmsconfirmVO updateSMSConfirmInfo(String mobile, String streamNumber) throws Exception {
		
		Smsconfirm scBO = (Smsconfirm)BOFactory.build(SmsconfirmBO.class,user);
		SmsconfirmDBParam scParam = new SmsconfirmDBParam();
		scParam.set_se_type("PARSIGN");
		scParam.set_se_mobileno(mobile);
		scParam.set_se_stream(streamNumber);
		scParam.set_se_state("WAITREP");
		//scParam.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd")+" 00:00:00");
		scParam.set_orderby("sendtime"); // 按通知时间升序排列
		scParam.setDataOnly(true);
		scParam.set_pagesize("0");
		DataPackage dp = scBO.doQuery(scParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			throw new SMSException("确认记录["+streamNumber+"]不存在",CoRefuseSigningResult.RET_TYPE_FAIL_1);
		}else {
			SmsconfirmVO scVO = (SmsconfirmVO)list.get(0); // 取通知时间最早的一条
//			签收有效天数：查询系统参数配置表，匹配参数类型为“pboss_fx”、参数标识为“81”，如果无数据或参数值非1-30的整数，则默认取值为1；
			Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
			SysparamVO sysvo = new SysparamVO();
			sysvo.setSystemid(new Long("81"));
			sysvo.setParamtype("pboss_fx");
			SysparamVO newsysvo = sybo.doFindByPk(sysvo);
			String val = "";
			int days ;
			if (newsysvo == null) {
				days = 1;
			}else{
				try{
					val = newsysvo.getParamvalue();
					days = Integer.parseInt(val);
					if(days > 30 || days < 1){
						days = 1;
					}
				}catch(Exception e){
					days = 1;
				}
				
			}
			
//			判断当前日期-通知时间日期 是否大于签收有效天数，如果超出有效天数，返回码取“5”，说明取“订单[XXX]签收超时”。否则继续
			long da = (new Date(System.currentTimeMillis()).getTime()-scVO.getSendtime().getTime())/(1000 * 60 * 60 * 24);

			if(da > days){
				throw new SMSException("订单["+scVO.getOrderid()+"]签收超时",CoRefuseSigningResult.RET_TYPE_FAIL_4);
			}
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("拒绝签收");
			return scBO.doUpdate(scVO);
		}
	}
	
	/**
	 * 拒绝签收登记
	 * @param orderid
	 * @throws Exception
	 */
	private void refuseSigningCheckIn(String orderid) throws Exception{
		
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		if(orderVO == null) 
			throw new SMSException("订单["+orderid+"]信息不存在",CoRefuseSigningResult.RET_TYPE_FAIL_2);
		if(!"WAITSIGN".equals(orderVO.getSignstate()))
			throw new SMSException("订单["+orderid+"]签收状态错误",CoRefuseSigningResult.RET_TYPE_FAIL_3);
		orderVO.setSignstate("REFUSE");
		orderBO.doUpdate(orderVO);
	}
	
	private CoRefuseSigningResult doReturnSuccVal() throws Exception {
		CoRefuseSigningResult result = new CoRefuseSigningResult();
		result.setRet(CoRefuseSigningResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}
	
	//发送失败短信
	public void sendMes(String mobile,String contentcode) throws Exception {
		
//		新增数据到短信待发送表(CH_SMS_WAITREQ)，字段取值如下：
//		短信类型取3；
//		发送号码：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值。
		Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
		SysparamVO sysvo = new SysparamVO();
		sysvo.setSystemid(new Long("42"));
		sysvo.setParamtype("pboss_fx");
		SysparamVO newsysvo = sybo.doFindByPk(sysvo);
		String val = "";
		if (newsysvo!=null) {
			val = newsysvo.getParamvalue();
		}
		
//		接收号码：手机号码参数；
//		短信内容：取上面返回的说明。
		if(contentcode != null && !contentcode.equals("") && val != null && !val.equals("") && mobile != null && !mobile.equals("")){
			Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
			waitreqBO.doInsert3(new Short("3"), contentcode, val, mobile,new Date(System.currentTimeMillis()));			
		}
	
	}
	
}
