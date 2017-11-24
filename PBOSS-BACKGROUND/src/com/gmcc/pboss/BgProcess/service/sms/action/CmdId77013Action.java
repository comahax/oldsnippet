package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.registerSmsbusi.SMSRegisterSmsbusi;
import com.gmcc.pboss.control.service.sms.registerSmsbusi.SMSRegisterSmsbusiBO;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * ������ҵ��Ǽǡ������ӿ��߼�
 * @author Yedaoe
 *
 */
public class CmdId77013Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77013Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		logger.warn("������:77013;"+getRequest().getDataTrans().toString());
		String result = registerSmsbusi(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	/**
	 * 77013�����ָ�ʽ:
	 * �û�����~����~���ظ�ʽ~���ж�������
	 * @param contextStr
	 * @return
	 */
	private String registerSmsbusi(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		try {
			SMSRegisterSmsbusi bo = (SMSRegisterSmsbusi) BOFactory.build(
					SMSRegisterSmsbusiBO.class, user);
			return bo.doRegisterSmsbusi(datatrans[0],datatrans[1],datatrans[3]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}

}
