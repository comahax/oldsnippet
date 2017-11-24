package com.gmcc.pboss.control.sales.emptysimdisres;

import com.gmcc.pboss.business.sales.orderresdet.VOrderresdetDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface Emptysimdisres extends AbstractControl {

	public DataPackage doQueryEmptysimdisres(VOrderresdetDBParam params) throws Exception;
	
}
