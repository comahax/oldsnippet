/**
 * auto-generated code
 * Mon Aug 23 12:07:17 CST 2010
 */
package com.gmcc.pboss.control.sales.bankshop;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bankshop </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Bankshop extends AbstractControl {
    public BankshopVO doCreate(BankshopVO vo) throws Exception;

    public void doRemoveByVO(BankshopVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BankshopVO doUpdate(BankshopVO vo) throws Exception;

    public BankshopVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BankshopDBParam params) throws Exception;

}
