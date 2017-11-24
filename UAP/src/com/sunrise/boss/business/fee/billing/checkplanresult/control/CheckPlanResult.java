package com.sunrise.boss.business.fee.billing.checkplanresult.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultDBParam;
import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultVO;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface CheckPlanResult extends AbstractControl {
	public CheckPlanResultVO doCreate(CheckPlanResultVO vo)
			throws Exception;

	public void doRemove(CheckPlanResultVO vo)
	        throws Exception;

	public CheckPlanResultVO doUpdate(CheckPlanResultVO vo)
			throws Exception;

	public CheckPlanResultVO doFindByPk(Serializable pk)
			throws Exception;

	public DataPackage doQuery(CheckPlanResultDBParam params)
			throws Exception;

}
