package com.gmcc.pboss.control.service.sms.modifypassword;

import com.gmcc.pboss.service.sms.result.ModifyPasswordResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * ������ƽ̨���������޸ġ������ӿ��߼�
 * 
 * @author Yedaoe
 * 
 */
public interface SMSModifyPasswordPr extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            �ֻ�����
	 * @return
	 * @throws Exception
	 */
	public String doModifyPassword(String mobile,String cityid,String smscontent)
			throws Exception;
	
	public ModifyPasswordResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String smscontent,String templateid)
			throws Exception;

}