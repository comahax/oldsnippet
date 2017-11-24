/**
 * auto-generated code
 * Tue Jan 17 09:54:18 CST 2012
 */
package com.gmcc.pboss.control.sales.bankrecordlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankrecordlog.BankrecordlogDBParam;
import com.gmcc.pboss.business.sales.bankrecordlog.BankrecordlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bankrecordlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Bankrecordlog extends AbstractControl {
    public BankrecordlogVO doCreate(BankrecordlogVO vo) throws Exception;

    public void doRemoveByVO(BankrecordlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BankrecordlogVO doUpdate(BankrecordlogVO vo) throws Exception;

    public BankrecordlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BankrecordlogDBParam params) throws Exception;

}
