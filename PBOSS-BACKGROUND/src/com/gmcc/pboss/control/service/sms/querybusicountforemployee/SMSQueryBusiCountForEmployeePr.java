package com.gmcc.pboss.control.service.sms.querybusicountforemployee;

import com.gmcc.pboss.service.sms.result.QueryBusiCountForEmployeeResult;
import com.gmcc.pboss.service.sms.result.ResetPasswordResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ����Աҵ������ѯ�������ӿ��߼�
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForEmployeePr extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForEmployee(String mobile,String cityid,String smscontent)
			throws Exception;
	
	public QueryBusiCountForEmployeeResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String smscontent,String templateid,Short success)
			throws Exception;

}