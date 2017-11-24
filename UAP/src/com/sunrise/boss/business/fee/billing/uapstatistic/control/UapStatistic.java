package com.sunrise.boss.business.fee.billing.uapstatistic.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.uapstatistic.persistent.UapStatisticDBParam;
import com.sunrise.boss.business.fee.billing.uapstatistic.persistent.UapStatisticVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface UapStatistic extends AbstractControl{

	public DataPackage doQuery(UapStatisticDBParam param) throws Exception;

}
