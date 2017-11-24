package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.confirmsigning.SMSCoConfirmSigning;
import com.gmcc.pboss.control.service.sms.confirmsigning.SMSCoConfirmSigningBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * 【合作商确认签收】短信营业厅接口
 * @author zhangsiwei
 *
 */
public class CmdId77006Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77006Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = coConfirmSigning(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	
	/**
	 * 77006命令字格式: 用户号码~工号~返回格式~确认流水号~;
	 * @param contextStr
	 * @return
	 */
	private String coConfirmSigning(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		if(StringUtils.isEmpty(user.getCityid())) {
			throw new SMSException(SMSResult.RET_MESSAGE_FAIL_1,
					SMSResult.RET_TYPE_FAIL_1);
		}
		try {
			SMSCoConfirmSigning bo = (SMSCoConfirmSigning) BOFactory.build(
					SMSCoConfirmSigningBO.class, user);
			return bo.doResult(datatrans[0], datatrans[3]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}

}
