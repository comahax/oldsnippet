package com.gmcc.pboss.control.service.sms.cancelbook;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * �������ܾ̾�ǩ�ա�����Ӫҵ���ӿ�֮BO
 * @author Jemy
 *
 */
public interface SMSCancelBook extends AbstractControl {

	/**
	 * 
	 * @param mobile  �ֻ�����
	 * @param streamNumber ȷ����ˮ��
	 * @return
	 * @throws Exception
	 */
	public String doCancelBook(String mobile,String streamNumber) throws Exception;
	
}
