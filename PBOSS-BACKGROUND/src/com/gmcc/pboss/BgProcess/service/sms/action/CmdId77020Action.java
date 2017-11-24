package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.invoiceinvite.InvoiceInvite;
import com.gmcc.pboss.control.service.sms.invoiceinvite.InvoiceInviteBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.DisformFinishenrolResult;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * 
 * ��������Ʊ���졿�����ӿ�
 * �����������ṩ��������ͷ�ƶ��������쿨�����ʵķ�Ʊ���ܡ�
 * @author dengxingxin
 *
 */
public class CmdId77020Action extends BaseSocketAction {
	
	private static Logger logger = Logger.getLogger(CmdId77020Action.class);
	
	@Override
	@MethodLevelPointcut
	public void execute() {
		String result = invite(getRequest().getDataTrans());
		getResponse().setDataTrans(result);

	}
	/**
	 * 77020�����ָ�ʽ:
	 * ���ͱ��ģ��û�����~����~���ظ�ʽ
	 * @param contextStr
	 * @return
	 */
	private String invite(String contextStr){
		try {
			String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
			if(datatrans.length < 3){
				return SMSProtocol.WRONG_FORMAT;
			}
			DBAccessUser user = super.getDbAccessUser();
			if(StringUtils.isEmpty(user.getCityid())) {
				throw new SMSException("�𾴵Ŀͻ��������ֻ������������Ϣδ֪���޷�Ϊ���ṩ�����������������ϵ��������򲦴�������ߡ�",
						SMSResult.RET_TYPE_FAIL_1);
			}
			
			InvoiceInvite bo = (InvoiceInvite) BOFactory.build(
					InvoiceInviteBO.class, user);
			return bo.doInvite(datatrans[0]);
		}catch(SMSException e){
			return SMSUtils.getErrorResult(e, logger);
		}catch(Exception e){
			return SMSUtils.getErrorResult(new SMSException("ʧ��",DisformFinishenrolResult.RET_TYPE_FAIL_111), logger);
		}
	}

}
