package com.sunrise.boss.delegate.fee.woff.acct;

import java.io.Serializable;

import com.sunrise.boss.business.fee.woff.acct.control.AcctControl;
import com.sunrise.boss.business.fee.woff.acct.control.AcctControlBean;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctListVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AcctDelegate</p>
 * <p>Description: 帐单科目管理代理类? </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class AcctDelegate {
	private AcctControl control;
	
    public AcctDelegate() throws Exception {
        control = (AcctControl) ControlFactory.build(AcctControlBean.class);
        if (control == null ) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    
    public AcctVO doCreateWithManageLog(AcctVO vo, Long acctsetid, User user) throws BusinessException {
		return control.doCreateWithManageLog( vo, acctsetid, user );
	}
	
	public AcctVO doUpdateWithManageLog(AcctVO newvo, Integer oldAcctlev, User user) throws BusinessException{
		return control.doUpdateWithManageLog(newvo, oldAcctlev, user);
	}
	
	public void doRemoveByPkWithManageLog(Serializable pk, User user) throws BusinessException{
		control.doRemoveByPkWithManageLog( pk, user );
	}
	
	 public AcctVO doFindByPk(Serializable pk, User user) throws Exception{
		 return control.doFindByPk( pk, user );
	 }
	 /** add by mys**/
	 public Integer doGetAccttypeByAcctid(Serializable pk, User user) throws Exception{
		 return control.doGetAccttypeByAcctid( pk, user );
	 } 
	 public DataPackage doQuery(AcctListVO params, User user)
	    throws Exception{
		 return control.doQuery(params, user);
	 }
}
