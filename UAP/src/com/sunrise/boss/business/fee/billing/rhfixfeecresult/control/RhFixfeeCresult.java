package com.sunrise.boss.business.fee.billing.rhfixfeecresult.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultDBParam;
import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface RhFixfeeCresult extends AbstractControl {
	public RhFixfeeCresultVO doCreate(RhFixfeeCresultVO vo)
			throws Exception;

	public void doRemove(RhFixfeeCresultVO vo)
	        throws Exception;

	public RhFixfeeCresultVO doUpdate(RhFixfeeCresultVO vo)
			throws Exception;

	public RhFixfeeCresultVO doFindByPk(Serializable pk)
			throws Exception;

	public DataPackage doQuery(RhFixfeeCresultDBParam params)
			throws Exception;

}
