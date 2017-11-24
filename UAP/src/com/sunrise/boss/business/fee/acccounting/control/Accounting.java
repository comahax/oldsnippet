/**
 * 
 */
package com.sunrise.boss.business.fee.acccounting.control;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.ui.User;


/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author mys
 * @version 1.0
 */
public interface Accounting extends AbstractControl {
 
	public List doAccounting(AccountingVO params, User user) throws Exception ;
	
	public List doTJAccounting(AccountingVO params, User user) throws Exception ;
	
	public AccountingVO doBatchStartUp(AccountingVO params, User user) throws Exception ;
	
	public AccountingVO doStartUp(AccountingVO params, User user) throws Exception ;
	
	public List doShowLog(AccountingVO params, User user) throws Exception ;

	public Map doAccBill(AccountingVO params, User user)throws Exception ;

	public List doAccBilling(AccountingVO params, User user) throws Exception;

	public Map doAccBillDet(AccountingVO params, User user)throws Exception ;
	
    public Date getStartdate(AccountingVO params,User user) throws Exception;
}
