package com.gmcc.pboss.control.service.sms.querybusicountforemployee;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ����Աҵ������ѯ�������ӿ��߼�
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForEmployee extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForEmployee(String mobile,String cityid,String smscontent)
			throws Exception;

}