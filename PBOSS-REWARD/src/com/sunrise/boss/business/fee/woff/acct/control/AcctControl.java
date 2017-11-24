package com.sunrise.boss.business.fee.woff.acct.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.woff.acct.persistent.AcctListVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AcctControl</p>
 * <p>Description: 帐单科目管理control</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public interface AcctControl extends AbstractControl{
	public AcctVO doCreateWithManageLog(AcctVO vo, Long acctsetid, User user) throws BusinessException;
	public AcctVO doUpdateWithManageLog(AcctVO newvo, Integer oldAcctlev, User user) throws BusinessException;
	public void doRemoveByPkWithManageLog(Serializable pk, User user) throws BusinessException;
	public AcctVO doFindByPk(Serializable pk, User user) throws Exception;
	
	/** add by mys */
	public Integer doGetAccttypeByAcctid(Serializable pk, User user) throws Exception;
	public DataPackage doQuery(AcctListVO params, User user)
    throws Exception;
}
