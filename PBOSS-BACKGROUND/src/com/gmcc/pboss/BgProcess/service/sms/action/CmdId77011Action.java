package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.resetpassword.SMSResetPassword;
import com.gmcc.pboss.control.service.sms.resetpassword.SMSResetPasswordBO;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * ������ƽ̨�����������á������ӿ��߼�
 * @author Yedaoe
 *
 */
public class CmdId77011Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77011Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = resetPassword(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	/**
	 * 77011�����ָ�ʽ:
	 * �û��ֻ�����~����~���ظ�ʽ~;
	 * @param contextStr
	 * @return
	 */
	private String resetPassword(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 3){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		try {
			SMSResetPassword bo = (SMSResetPassword) BOFactory.build(
					SMSResetPasswordBO.class, user);
			return bo.doResetPassword(datatrans[0],datatrans[1]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}

}
