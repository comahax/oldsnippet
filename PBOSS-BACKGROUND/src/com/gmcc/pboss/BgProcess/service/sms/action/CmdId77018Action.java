package com.gmcc.pboss.BgProcess.service.sms.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.service.sms.localcomorder.SMSLocalComOrderCommit;
import com.gmcc.pboss.control.service.sms.localcomorder.SMSLocalComOrderCommitBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;


/**
 * 【本地化商品订购】短信营业厅接口逻辑
 * @author yde
 * @since 2011-8-15
 */
public class CmdId77018Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77018Action.class);
	
	@MethodLevelPointcut
	public void execute() {
		String result = comOrder(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	
	/**
	 * 77018命令字格式:用户号码~工号~返回格式~资源代码和数量~;
	 * @param contextStr
	 * 报文示例：
				13800138000~1861~1~a20b80c100d60~
				13800138000~1861~1~a#30，b#50，c#20~
				13800138000~1861~1~55DG#20,55DZ#60，100CZ#30~
	 * @return
	 */
	private String comOrder(String contextStr){
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		if(StringUtils.isEmpty(user.getCityid())) {
			throw new SMSException("尊敬的客户，您的手机号码归属地信息未知，无法为您提供服务。如需帮助，请联系渠道经理或拨打服务热线。",
					SMSResult.RET_TYPE_FAIL_1);
		}
		
		//datatrans[3]格式 ：a20b80c100d60 
		//					a#30，b#50，c#20
		//					55DG#20,55DZ#60，100CZ#30
		//List<String> dataList = Arrays.asList(StringUtils.split(datatrans[3], SMSProtocol.DATA_SLIT_SYMBOL));
 		try{
			SMSLocalComOrderCommit localcomOrderCommit = (SMSLocalComOrderCommit)BOFactory.build(SMSLocalComOrderCommitBO.class, user);
			return localcomOrderCommit.doResult(datatrans[0],datatrans[3]).toString();
		}catch (SMSException e) {
			this.sendSms(e.getParammap());
			return SMSUtils.getErrorResult(e, logger);
		}catch (Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}
	
	//写短信待发送表
	private void sendSms(Map<String,Object> parammap){
		try{
			if(null!=parammap){
				if(parammap.get("orderstatecheckflag")==null){
					String sid = (String)parammap.get("sid");
					Map<String,String> keyvaluemap = (Map<String,String>)(parammap.get("keyvaluemap"));
					String defaultsms = (String)parammap.get("defaultsms");
					String receiveno = (String)parammap.get("receiveno");
					DBAccessUser user = super.getDbAccessUser();
					Sysparam SysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
					String sendno = SysparamBO.doFindByID("42", "pboss_fx");
					if(StringUtils.isBlank(sendno))
						sendno = "10086116";
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String smsContent = smstmplBO.doGenSMS(sid, keyvaluemap);
					if( null == smsContent || "".equals(smsContent.trim()))
						smsContent = defaultsms;
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsert2(new Short("3"), smsContent, sendno,receiveno);
				}else{//针对商品订购状态检查的报错进行特殊处理，因为它没有短信模板
					DBAccessUser user = super.getDbAccessUser();
					Sysparam SysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
					String sendno = SysparamBO.doFindByID("42", "pboss_fx");
					String smsContent = (String)parammap.get("defaultsms");
					String receiveno = (String)parammap.get("receiveno");
					if(StringUtils.isBlank(sendno))
						sendno = "10086116";
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsert2(new Short("3"), smsContent, sendno,receiveno);
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			LoggerUtils.error(e, logger);
		}
	}
}
