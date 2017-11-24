package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.bondconfirm.BondConfirm;
import com.gmcc.pboss.control.service.sms.bondconfirm.BondConfirmBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.DisformFinishenrolResult;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * 
 * ��������֤���Ͻ����뵥ȷ�ϡ������ӿ��߼�
 * ����������������ͨ���ظ�����ȷ�Ͻ����Ϣ
 * @author dengxingxin
 *
 */
public class CmdId77019Action extends BaseSocketAction {
	
	private static Logger logger = Logger.getLogger(CmdId77019Action.class);
	
	@Override
	@MethodLevelPointcut
	public void execute() {
		String result = bondConfirm(getRequest().getDataTrans());
		getResponse().setDataTrans(result);

	}
	/**
	 * 77019�����ָ�ʽ:
	 * ���ͱ��ģ��û�����~����~���ظ�ʽ~��������
	 * �������ݣ�SJ+���뵥��+#+ȷ�Ͻ����ʾ����SJ1234#Y
	 * @param contextStr
	 * @return
	 */
	private String bondConfirm(String contextStr){
		try {
			String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
			if(datatrans.length < 4){
				return SMSProtocol.WRONG_FORMAT;
			}
			DBAccessUser user = super.getDbAccessUser();
			if(StringUtils.isEmpty(user.getCityid())) {
				throw new SMSException("�𾴵Ŀͻ��������ֻ������������Ϣδ֪���޷�Ϊ���ṩ�����������������ϵ��������򲦴�������ߡ�",
						SMSResult.RET_TYPE_FAIL_1);
			}
			
			BondConfirm bo = (BondConfirm) BOFactory.build(
					BondConfirmBO.class, user);
			return bo.doConfirm(contextStr);
		}catch(SMSException e){
			return SMSUtils.getErrorResult(e, logger);
		}catch(Exception e){
			return SMSUtils.getErrorResult(new SMSException("ʧ��",DisformFinishenrolResult.RET_TYPE_FAIL_111), logger);
		}
	}

}
