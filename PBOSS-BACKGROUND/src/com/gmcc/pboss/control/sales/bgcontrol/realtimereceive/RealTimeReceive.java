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
	 * 当请求发送失败后，回滚银行划扣记录表的划扣记录（此方法处理实时代收处理请求失败）
	 */
	
	public void realTimeRollBackBankDeduct(BankdeductVO bankdeductvo) throws Exception;
}
