package com.gmcc.pboss.control.service.sms.querybusicountfornet;

import com.gmcc.pboss.service.sms.result.QueryBusiCountForNetResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 【网点业务量查询】短厅接口逻辑
 * @author Yedaoe
 *
 */
public interface SMSQueryBusiCountForNetPr extends AbstractControl {

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @return
	 * @throws Exception
	 */
	public String doQueryBusiCountForNet(String mobile,String cityid,String smscontent)
			throws Exception;
	
	public QueryBusiCountForNetResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String smscontent,String templateid,Short success)
			throws Exception;
}