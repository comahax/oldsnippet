package com.gmcc.pboss.control.service.sms.empconfirm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ��רԱ����ȷ�Ͻӿڡ������ӿ��߼�
 * 
 * @author Yedaoe
 * 
 */
public interface SMSEmpConfirm extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doEmpConfirm(String mobile,String yesorno)
			throws Exception;

}