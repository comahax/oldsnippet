package com.gmcc.pboss.control.service.sms.confirmsigning;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.CoConfirmSigningResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSCoConfirmSigningBO extends AbstractControlBean implements
		SMSCoConfirmSigning {
	private static Logger logger = Logger.getLogger(SMSCoConfirmSigningBO.class);

	public String doResult(String mobile, String streamNumber) throws Exception {
		// TODO Auto-generated method stub
		String orderid = "";
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			SmsconfirmVO scVO = this.updateSMSConfirmInfo(mobile, streamNumber);
			orderid = scVO.getOrderid();
			this.signingConfirm(scVO.getOrderid(), mobile);
			this.noteLogsSms(scVO.getOrderid());
			this.confirmOrder(scVO.getOrderid());
			//调用短信发送方法
			this.sendMes(mobile,"订单["+orderid+"]签收成功");
			
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
//		scParam.set_dnl_sendtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd")+" 00:00:00");
		scParam.set_orderby("sendtime"); // 按通知时间升序排列
		scParam.setDataOnly(true);
		scParam.set_pagesize("0");
		DataPackage dp = scBO.doQuery(scParam);
		List list = dp.getDatas();
		if(list == null || list.size() <= 0) {
			throw new SMSException("确认记录["+streamNumber+"]不存在",CoConfirmSigningResult.RET_TYPE_FAIL_1);
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
				throw new SMSException("订单["+scVO.getOrderid()+"]签收超时",CoConfirmSigningResult.RET_TYPE_FAIL_5);
			}
			
			scVO.setReptime(new Date());
			scVO.setState("REPLIED");
			scVO.setRepdesc("确认签收");
			return scBO.doUpdate(scVO);
		}
	}
	
	/**
	 * 签收确认
	 * @param orderid
	 * @throws Exception
	 */
	private void signingConfirm(String orderid, String mobile) throws Exception {
		
		Order orderBO = (Order)BOFactory.build(OrderBO.class, user);
		OrderVO orderVO = orderBO.doFindByPk(orderid);
		if(orderVO == null) 
			throw new SMSException("订单["+orderid+"]信息不存在",CoConfirmSigningResult.RET_TYPE_FAIL_2);
		if("SIGNED".equals(orderVO.getSignstate())) 
			throw new SMSException("订单["+orderid+"]已签收，无需重复确认",CoConfirmSigningResult.RET_TYPE_FAIL_3);
		if(!"WAITSIGN".equals(orderVO.getSignstate()))
			throw new SMSException("订单["+orderid+"]签收状态错误",CoConfirmSigningResult.RET_TYPE_FAIL_4);
		orderVO.setSignstate("SIGNED");
		orderVO.setSigntime(new Date());
		orderVO.setSigntype("SMS");
		orderVO.setSmssignno(mobile);
		
		orderBO.doUpdate(orderVO);
		
		// 参数类型为"pboss_fx"，参数标识为"84"，如果参数值为1时判断是否可发起订购
		this.doUpdateWayassistant(orderVO);
	}
	
	/**
	 * 完成配送通知配送商
	 * @param orderid
	 * @throws Exception
	 */
	private void noteLogsSms(String orderid) throws Exception {
		
		// 查询系统参数配置表（IB_GL_SYSPARAM）匹配参数类型为“pboss_fx”，参数标识为“76”
		Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
		SysparamVO sysvo = new SysparamVO();
		sysvo.setSystemid(new Long("76"));
		sysvo.setParamtype("pboss_fx");
		SysparamVO newsysvo = sybo.doFindByPk(sysvo);		
		// 系统参数配置了并且数值为1的时候，完成配送通知配送商
		if (newsysvo !=null && "1".equals(newsysvo.getParamvalue())) {
				
			// 取物流信息
			Disform disbo = (Disform)BOFactory.build(DisformBO.class,user);
			DisformDBParam disparam = new DisformDBParam();
			disparam.set_se_orderid(orderid);
			DataPackage dp = disbo.doQuery(disparam);
			List list = dp.getDatas();
			if(list == null || list.size() <= 0) {
			} else {
				DisformVO disvo = (DisformVO)list.get(0); //取第一条数据
				disbo.doComfirmSignMsg(disvo); // 调用前台配送商确认共通方法
			}
		}		
	}
	
	/**
	 * 签收后自动入账
	 * @param orderid
	 * @throws Exception
	 */
	private void confirmOrder (String orderid) throws Exception {
		// 查询系统参数配置表（IB_GL_SYSPARAM）匹配参数类型为“pboss_fx”，参数标识为“76”
		Sysparam sybo = (Sysparam) BOFactory.build(SysparamBO.class,user);
		SysparamVO sysvo = new SysparamVO();
		sysvo.setSystemid(new Long("77"));
		sysvo.setParamtype("pboss_fx");
		SysparamVO newsysvo = sybo.doFindByPk(sysvo);
		
		// 参数值为1时则更新订单表的订单状态为“已签收”，然后调用【订单下一步处理公用方法】
		if (newsysvo!=null && "1".equals(newsysvo.getParamvalue())) {
			Order bo = (Order)BOFactory.build(OrderBO.class, user);
			OrderVO vo = bo.doFindByPk(orderid);
			// 调用签收后自动入账共通方法
			Disform disbo = (Disform)BOFactory.build(DisformBO.class,user);
			disbo.doUpdateOrderState(vo);
		}		
	}
	
	private CoConfirmSigningResult doReturnSuccVal() throws Exception {
		CoConfirmSigningResult result = new CoConfirmSigningResult();
		result.setRet(CoConfirmSigningResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}
	
	//发送失败短信
	public void sendMes(String mobile,String content) throws Exception {
		
		
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
		if(content != null && !content.equals("") && val != null && !val.equals("") && mobile != null && !mobile.equals("")){
		Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
		
		waitreqBO.doInsert3(new Short("3"), content, val, mobile,new Date(System.currentTimeMillis()));
		}
		
	}

	/**
	 * 查询系统参数配置表(IB_GL_SYSPARAM)，匹配参数类型为"pboss_fx"，参数标识为"84"，
	 * 如果参数值为1时则根据订单编号取得订单表(fx_sw_order)中的渠道，
	 * 根据渠道编码查询商品订购辅助信息表 (FX_RU_WAYASSISTANT)，
	 * 判断是否可发起订购值是否为"1"，不为"1"则修改成1
	 */
    public void doUpdateWayassistant(OrderVO ordervo) throws Exception {
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String sysvalue = sysparamBO.doFindByID(new Long("84"), "pboss_fx");
		if (sysvalue != null && "1".equals(sysvalue)) {
			WayassistantBO assistantbo = (WayassistantBO) BOFactory.build(WayassistantBO.class, user);
			WayassistantVO assistantvo = assistantbo.doFindByPk(ordervo.getWayid());
			if (assistantvo.getCanorder() != 1) {
				assistantvo.setCanorder(new Short("1"));
				assistantbo.doUpdate(assistantvo);
			}
		}
	}
}
