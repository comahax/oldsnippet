package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.empconfirm.SMSEmpConfirm;
import com.gmcc.pboss.control.service.sms.empconfirm.SMSEmpConfirmBO;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * ��רԱ����ȷ�Ͻӿڡ������ӿ��߼�
 * @author Yedaoe
 *
 */
public class CmdId88001Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId88001Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = empConfirm(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	/**
	 * 88001�����ָ�ʽ:
	 * �û��ֻ�����~Y/N~;
	 * @param contextStr
	 * @return
	 */
	private String empConfirm(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 2){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		try {
			SMSEmpConfirm bo = (SMSEmpConfirm) BOFactory.build(
					SMSEmpConfirmBO.class, user);
			return bo.doEmpConfirm(datatrans[0],datatrans[1]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}

}
