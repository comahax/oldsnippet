package com.gmcc.pboss.control.reward.paydetaillog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paydetaillog.PaydetaillogDBParam;
import com.gmcc.pboss.business.reward.paydetaillog.PaydetaillogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface Paydetaillog extends AbstractControl {

	public PaydetaillogVO doCreate(PaydetaillogVO vo) throws Exception;

	public void doRemoveByVO(PaydetaillogVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public PaydetaillogVO doUpdate(PaydetaillogVO vo) throws Exception;

	public PaydetaillogVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(PaydetaillogDBParam params) throws Exception;
}
