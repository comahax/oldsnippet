package com.gmcc.pboss.control.service.sms.bondconfirm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 
 * ��������֤���Ͻ����뵥ȷ�ϡ������ӿ��߼�
 * ����������������ͨ���ظ�����ȷ�Ͻ����Ϣ
 * @author dengxingxin
 *
 */
public interface BondConfirm extends AbstractControl {

	/**
	 * 
	 * @param tranData ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doConfirm(String tranData)
			throws Exception;
}
