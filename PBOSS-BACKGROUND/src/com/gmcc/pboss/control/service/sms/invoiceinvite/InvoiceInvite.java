package com.gmcc.pboss.control.service.sms.invoiceinvite;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 
 * 新增【发票请领】短厅接口
 * 功能描述：提供渠道向汕头移动发起请领卡类物资的发票功能。
 * @author dengxingxin
 *
 */
public interface InvoiceInvite extends AbstractControl {

	/**
	 * 
	 * @param mobileno 手机号
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doInvite(String mobileno)
			throws Exception;
}
