package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.querybusicountforemployee.SMSQueryBusiCountForEmployee;
import com.gmcc.pboss.control.service.sms.querybusicountforemployee.SMSQueryBusiCountForEmployeeBO;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * ����Աҵ������ѯ�������ӿ��߼�
 * @author Yedaoe
 *
 */
public class CmdId77014Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77014Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = queryBusiCountForEmployee(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	/**
	 * 77014�����ָ�ʽ:
	 * �û�����~����~���ظ�ʽ~��������
	 * @param contextStr
	 * @return
	 */
	private String queryBusiCountForEmployee(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		try {
			SMSQueryBusiCountForEmployee bo = (SMSQueryBusiCountForEmployee) BOFactory.build(
					SMSQueryBusiCountForEmployeeBO.class, user);
			return bo.doQueryBusiCountForEmployee(datatrans[0],datatrans[1],datatrans[3]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}

}
