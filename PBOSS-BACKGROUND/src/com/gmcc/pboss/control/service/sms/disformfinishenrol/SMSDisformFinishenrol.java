package com.gmcc.pboss.control.service.sms.disformfinishenrol;

import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;


public interface SMSDisformFinishenrol extends AbstractControl {

	public String doResult(String mobile, String orderid) throws Exception;
	public String doGetBossArea(String mobile) throws Exception;
	public String doGetWayId(String mobile) throws Exception;
	public DisformVO doUpdatDisForm(String orderID,String wayid) throws Exception;
	public void doSmsConfirm(String orderID,String recPhone) throws Exception;
	public void doAskSign(String recPhone,String recUser,String orderID) throws Exception;
}
