package com.gmcc.pboss.control.service.sms.querybusicountformanager;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ����������ҵ������ѯ�������ӿ��߼�
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForManager extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForManager(String mobile,String cityid,String smscontent)
			throws Exception;

}