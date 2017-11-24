package com.sunrise.boss.business.fee.billing.uapanalyse.control;

import com.sunrise.boss.business.fee.billing.uapanalyse.persistent.UapAnalyseDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface UapAnalyse extends AbstractControl{

	public DataPackage doQuery(UapAnalyseDBParam param) throws Exception;
}
