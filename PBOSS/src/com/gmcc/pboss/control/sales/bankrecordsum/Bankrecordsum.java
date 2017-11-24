/**
 * auto-generated code
 * Tue Jan 17 09:43:50 CST 2012
 */
package com.gmcc.pboss.control.sales.bankrecordsum;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumDBParam;
import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bankrecordsum </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Bankrecordsum extends AbstractControl {
    public BankrecordsumVO doCreate(BankrecordsumVO vo) throws Exception;

    public void doRemoveByVO(BankrecordsumVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BankrecordsumVO doUpdate(BankrecordsumVO vo) throws Exception;

    public BankrecordsumVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BankrecordsumDBParam params) throws Exception;

}
