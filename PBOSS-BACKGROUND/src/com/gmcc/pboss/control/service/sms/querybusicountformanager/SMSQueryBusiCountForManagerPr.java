package com.gmcc.pboss.control.service.sms.querybusicountformanager;

import com.gmcc.pboss.service.sms.result.QueryBusiCountForEmployeeResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ����������ҵ������ѯ�������ӿ��߼�
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForManagerPr extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForManager(String mobile,String cityid,String smscontent)
			throws Exception;
	
	public QueryBusiCountForEmployeeResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String smscontent,String templateid,Short success)
			throws Exception;

}