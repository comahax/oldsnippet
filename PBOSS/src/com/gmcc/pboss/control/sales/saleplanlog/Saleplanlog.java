/**
 * auto-generated code
 * Tue Nov 08 14:10:56 CST 2011
 */
package com.gmcc.pboss.control.sales.saleplanlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogDBParam;
import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Saleplanlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Saleplanlog extends AbstractControl {
    public SaleplanlogVO doCreate(SaleplanlogVO vo) throws Exception;

    public void doRemoveByVO(SaleplanlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SaleplanlogVO doUpdate(SaleplanlogVO vo) throws Exception;

    public SaleplanlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SaleplanlogDBParam params) throws Exception;

}
