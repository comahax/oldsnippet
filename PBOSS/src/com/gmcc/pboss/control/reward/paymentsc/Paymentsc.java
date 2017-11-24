package com.gmcc.pboss.control.reward.paymentsc;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payment.PaymentDBParam;
import com.gmcc.pboss.business.reward.paymentsc.PaymentscDBParam;
import com.gmcc.pboss.business.reward.paymentsc.PaymentscVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Paymentsc
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author caiwr
 * @version 1.0
 */
public interface Paymentsc extends AbstractControl {
	public PaymentscVO doCreate(PaymentscVO vo) throws Exception;

	public void doRemoveByVO(PaymentscVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public PaymentscVO doUpdate(PaymentscVO vo) throws Exception;

	public PaymentscVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(PaymentscDBParam params) throws Exception;

	public DataPackage doQueryBySql(PaymentscDBParam params, boolean switchflag)
			throws Exception;
	
	public DataPackage doQueryDelByNamedSql(PaymentscDBParam params, boolean switchflag)
			throws Exception;

	public String doDelCountByNamedSql(PaymentscDBParam params,
			boolean switchflag) throws Exception;

	public String doQuerySumByNamedSql(PaymentscDBParam params,
			boolean switchflag) throws Exception;
}
