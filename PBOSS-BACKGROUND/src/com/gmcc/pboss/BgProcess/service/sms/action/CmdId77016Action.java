package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.querybusicountformanager.SMSQueryBusiCountForManager;
import com.gmcc.pboss.control.service.sms.querybusicountformanager.SMSQueryBusiCountForManagerBO;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * ��������������ҵ������ѯ�������ӿ��߼�
 * @author Jerimy
 *
 */
public class CmdId77016Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77016Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = queryBusiCountForManager(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	/**
	 * 77016�����ָ�ʽ:
	 * �û�����~����~���ظ�ʽ~��������
	 * @param contextStr
	 * @return
	 */
	private String queryBusiCountForManager(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		try {
			SMSQueryBusiCountForManager bo = (SMSQueryBusiCountForManager) BOFactory.build(
					SMSQueryBusiCountForManagerBO.class, user);
			return bo.doQueryBusiCountForManager(datatrans[0],datatrans[1],datatrans[3]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}

}
