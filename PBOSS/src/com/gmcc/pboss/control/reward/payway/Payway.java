package com.gmcc.pboss.control.reward.payway;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface Payway extends AbstractControl {
	public PaywayVO doCreate(PaywayVO vo) throws Exception;

	public void doRemoveByVO(PaywayVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public PaywayVO doUpdate(PaywayVO vo) throws Exception;

	public PaywayVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(PaywayDBParam params) throws Exception;

	public DataPackage doQueryBySql(PaywayDBParam params, String qrySql)
			throws Exception;
	
	public DataPackage doQueryVWayBySql(PaywayDBParam params, String qrySql)
			throws Exception;
}
