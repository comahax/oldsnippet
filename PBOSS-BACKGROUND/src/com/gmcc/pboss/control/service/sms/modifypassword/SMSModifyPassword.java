package com.gmcc.pboss.control.service.sms.modifypassword;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ������ƽ̨���������޸ġ������ӿ��߼�
 * 
 * @author Yedaoe
 * 
 */
public interface SMSModifyPassword extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doModifyPassword(String mobile,String cityid,String smscontent)
			throws Exception;

}