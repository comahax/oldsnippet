package com.gmcc.pboss.control.service.sms.querybusicountfornet;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ������ҵ������ѯ�������ӿ��߼�
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForNet extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForNet(String mobile,String cityid,String smscontent)
			throws Exception;

}