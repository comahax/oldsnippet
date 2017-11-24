package com.gmcc.pboss.service.control.order;

import com.gmcc.pboss.service.result.RetResult;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface OrderProcess extends AbstractControl{

	public RetResult doNextProcess(String wayid,String orderid);
}
