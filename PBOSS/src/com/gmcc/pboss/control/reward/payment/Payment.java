package com.gmcc.pboss.control.reward.payment;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payment.PaymentDBParam;
import com.gmcc.pboss.business.reward.payment.PaymentVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Payment
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
 * @author a-biao
 * @version 1.0
 */
public interface Payment extends AbstractControl {
	public PaymentVO doCreate(PaymentVO vo) throws Exception;

	public void doRemoveByVO(PaymentVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public PaymentVO doUpdate(PaymentVO vo) throws Exception;

	public PaymentVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(PaymentDBParam params) throws Exception;

	public DataPackage doQueryBySql(PaymentDBParam params, boolean switchflag)
			throws Exception;

	public DataPackage doExportBySql(PaymentDBParam params, boolean switchflag)
			throws Exception;

	public void doSend(String[] selectArray, boolean switchflag,
			String employeeNum, String sbatch) throws Exception;

	public void doBatchsend(PaymentDBParam params, boolean switchflag,
			String employeeNum, String sbatch) throws Exception;

	public String doSendCountByNamedSql(PaymentDBParam params,
			boolean switchflag) throws Exception;

	public DataPackage doQueryDelByNamedSql(PaymentDBParam params,
			boolean switchflag) throws Exception;

	public DataPackage doQueryDelByNamedSqlFromLtyle(PaymentDBParam params,
			boolean switchflag) throws Exception;
	
	public DataPackage doQueryDelByNamedSqlFromStyle(PaymentDBParam params,
			boolean switchflag) throws Exception;
	
	public String doDelCountByNamedSql(PaymentDBParam params, boolean switchflag)
			throws Exception;

	public String doQuerySumByNamedSql(PaymentDBParam params, boolean switchflag)
			throws Exception;
}
