package com.gmcc.pboss.control.service.sms.registerSmsbusi;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ������ҵ��Ǽǡ������ӿ��߼�
 * @author Yedaoe
 *
 */
public interface SMSRegisterSmsbusi extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doRegisterSmsbusi(String mobile,String cityid,String smscontent)
			throws Exception;

}