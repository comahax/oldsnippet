package com.gmcc.pboss.control.sales.bgcontrol.realtimereceive;

import java.util.List;

import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.request.RealTimeReceiveRequest;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.response.RealTimeReceiveResponse;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface RealTimeReceive extends AbstractControl {

	

	public void doProcess(List list) throws Exception;
	
	
	public RealTimeReceiveResponse sendInfo(RealTimeReceiveRequest realTimeReceiveRequest) throws Exception ;
	
	public void dealResponse(RealTimeReceiveResponse realTimeReceiveResponse)	throws Exception;
	
	
	public RealTimeReceiveRequest packData(BankdeductVO bankdeductVO,
			String username, String password, String sendmax) throws Exception ;
	
	/**
	 * ��������ʧ�ܺ󣬻ع����л��ۼ�¼��Ļ��ۼ�¼���˷�������ʵʱ���մ�������ʧ�ܣ�
	 */
	
	public void realTimeRollBackBankDeduct(BankdeductVO bankdeductvo) throws Exception;
}
