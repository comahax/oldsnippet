package com.gmcc.pboss.control.sales.bankdeduct;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bankdeduct </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Bankdeduct extends AbstractControl {
    public BankdeductVO doCreate(BankdeductVO vo) throws Exception;

    public void doRemoveByVO(BankdeductVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BankdeductVO doUpdate(BankdeductVO vo) throws Exception;

    public BankdeductVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BankdeductDBParam params) throws Exception;

}
