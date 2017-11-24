/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billlogdeta.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaDBParam;
import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public interface BillLogDeta extends AbstractControl {

	public DataPackage doQuery(BillLogDetaDBParam params, User user)
			throws Exception;
	
	public Double getBillLogDetaAmt(String whereCaluse, Long validbilllcyc,User user) throws Exception;
	
	public Double getRHUNWFACCTRecvAmt(User user,Long validbillcyc) throws Exception;
	
	public DataPackage doQueryBillLogDeta(BillLogDetaDBParam param,User user) throws Exception;
	
	public boolean doValidBillValidbillcyc(Long region,Long validbillcyc,User user) throws Exception;

}
