package com.gmcc.pboss.control.service.sms.secconfirm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * [��Ʒ��������ȷ��] ����Ӫҵ���ӿ�֮BO
 * @author zsw
 *
 */
public interface SMSComOrderSecondConfirm extends AbstractControl {
	/**
	 * 
	 * @param mobile   �ֻ�����
	 * @param streamNumber  ȷ����ˮ��
	 * @return
	 * @throws Exception ���˷�����������ʱ�쳣�������׳�������spring�޷�����,�����޷��ع�
	 */
	public String doResult(String mobile,String streamNumber) throws Exception;

}
