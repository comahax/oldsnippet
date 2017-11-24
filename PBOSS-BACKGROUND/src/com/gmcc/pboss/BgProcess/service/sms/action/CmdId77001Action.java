package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.activityratio.SMSActivityRatioQuery;
import com.gmcc.pboss.control.service.sms.activityratio.SMSActivityRatioQueryBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;


/**
 * 激活率查询】短信营业厅接口逻辑
 * @author Canigar
 * @since 2009-12-28
 */
public class CmdId77001Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77001Action.class);
	
	@MethodLevelPointcut
	public void execute() {
		String result = activityRatio(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
		System.out.println("*************************返回:*"+result);
	}
	
	/**
	 * 77001命令字格式:用户号码~工号~返回格式~;
	 * @param contextStr
	 * @return
	 */
	private String activityRatio(String contextStr){
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 3){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		if(StringUtils.isEmpty(user.getCityid())) {
			throw new SMSException(SMSResult.RET_MESSAGE_FAIL_1,
					SMSResult.RET_TYPE_FAIL_1);
		}
		try{
			SMSActivityRatioQuery activityRatioQuery = (SMSActivityRatioQuery)BOFactory.build(SMSActivityRatioQueryBO.class, user);
			return activityRatioQuery.doResult(datatrans[0]).toString();
		}catch (Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}
}
