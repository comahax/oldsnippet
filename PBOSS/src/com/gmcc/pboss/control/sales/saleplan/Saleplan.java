/**
 * auto-generated code
 * Tue Nov 08 11:17:27 CST 2011
 */
package com.gmcc.pboss.control.sales.saleplan;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.saleplan.SaleplanDBParam;
import com.gmcc.pboss.business.sales.saleplan.SaleplanVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Saleplan </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Saleplan extends AbstractControl {
    public SaleplanVO doCreate(SaleplanVO vo) throws Exception;

    public void doRemoveByVO(SaleplanVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SaleplanVO doUpdate(SaleplanVO vo) throws Exception;

    public SaleplanVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SaleplanDBParam params) throws Exception;
    
    public DataPackage doQueryByName(String sqlName, SaleplanDBParam params) throws Exception;

}
