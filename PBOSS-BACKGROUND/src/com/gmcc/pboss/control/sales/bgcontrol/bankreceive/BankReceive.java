package com.gmcc.pboss.control.sales.bgcontrol.bankreceive;



import java.util.List;

import com.gmcc.pboss.common.bankunite.model.receivebatch.request.RecBatchRequest;
import com.gmcc.pboss.common.bankunite.model.receivebatch.response.RecBatchResponse;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface BankReceive extends AbstractControl {

	

	public List<RecBatchRequest> doProcess(List list,String username,String password,String sendmax) throws Exception;
	
	
	public RecBatchResponse sendInfo(RecBatchRequest recBatchRequest) throws Exception ;
	
	public void dealResponse(RecBatchResponse recBatchResponse)	throws Exception;
	
	
	public void rollBackBankDeduct(List list) throws Exception;
	
}
