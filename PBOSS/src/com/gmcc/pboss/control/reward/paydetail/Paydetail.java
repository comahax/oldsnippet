package com.gmcc.pboss.control.reward.paydetail;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paydetail.PaydetailDBParam;
import com.gmcc.pboss.business.reward.paydetail.PaydetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 
 * @author liangjiayuan
 *
 */
public interface Paydetail extends AbstractControl{

	public PaydetailVO doCreate(PaydetailVO vo) throws Exception;

	public void doRemoveByVO(PaydetailVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public PaydetailVO doUpdate(PaydetailVO vo) throws Exception;

	public PaydetailVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(PaydetailDBParam params) throws Exception;

	public DataPackage doQueryBySql(PaydetailDBParam params)
			throws Exception;

}
