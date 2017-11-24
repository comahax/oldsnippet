package com.gmcc.pboss.control.sales.order;

import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface OrderProcess extends AbstractControl{
	public void process(int intervalMin) throws Exception;
	
	public void doAutoProcess(OrdertaskVO ordertaskVO) throws Exception;
	
}
