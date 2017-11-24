/**
 * auto-generated code
 * Tue Jan 17 09:52:22 CST 2012
 */
package com.gmcc.pboss.control.sales.bankrecord;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankrecord.BankrecordDBParam;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bankrecord </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Bankrecord extends AbstractControl {
    public BankrecordVO doCreate(BankrecordVO vo) throws Exception;

    public void doRemoveByVO(BankrecordVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BankrecordVO doUpdate(BankrecordVO vo) throws Exception;

    public BankrecordVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BankrecordDBParam params) throws Exception;
    
    public DataPackage doQueryBankRecordDetail(String deductid) throws Exception;
    
    public void doDeduct(String deductid) throws Exception;
    
    public DataPackage doDetail(BankrecordDBParam params) throws Exception;

}
