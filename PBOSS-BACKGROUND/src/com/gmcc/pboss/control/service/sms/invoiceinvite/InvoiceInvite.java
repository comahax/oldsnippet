package com.gmcc.pboss.control.service.sms.invoiceinvite;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 
 * ��������Ʊ���졿�����ӿ�
 * �����������ṩ��������ͷ�ƶ��������쿨�����ʵķ�Ʊ���ܡ�
 * @author dengxingxin
 *
 */
public interface InvoiceInvite extends AbstractControl {

	/**
	 * 
	 * @param mobileno �ֻ���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doInvite(String mobileno)
			throws Exception;
}
