package com.gmcc.pboss.control.sales.bgcontrol.orderAutoFail;

import com.sunrise.jop.infrastructure.control.AbstractControl;
/**
 * �����Զ�����
 * @author zhangsiwei
 *
 */
public interface OrderAutoFail extends AbstractControl {

	public void failConfirmOutOrder(String confirmTime) throws Exception;
	
	public void failSendOutOrder(String sendTime) throws Exception;
}
