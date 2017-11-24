package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.queryordercount.SMSQueryOrderCount;
import com.gmcc.pboss.control.service.sms.queryordercount.SMSQueryOrderCountBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * ���������޲�ѯ�������ӿ��߼�
 * @author yangdaren
 *
 */
public class CmdId77017Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77017Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = queryOrderCount(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	
	/**
	 * 77017�����ָ�ʽ:
	 * �û�����~����~���ظ�ʽ~;
	 * @param contextStr
	 * @return
	 */
	private String queryOrderCount(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 3){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		if(StringUtils.isEmpty(user.getCityid())) {
			throw new SMSException("�𾴵Ŀͻ��������ֻ������������Ϣδ֪���޷�Ϊ���ṩ�����������������ϵ��������򲦴�������ߡ�",
					SMSResult.RET_TYPE_FAIL_1);
		}
		try {
			SMSQueryOrderCount bo = (SMSQueryOrderCount) BOFactory.build(
					SMSQueryOrderCountBO.class, user);
			return bo.doQueryOrderCount(datatrans[0]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}
}
