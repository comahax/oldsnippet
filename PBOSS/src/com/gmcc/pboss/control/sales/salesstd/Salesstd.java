/**
 * auto-generated code
 * Tue Oct 25 16:42:25 CST 2011
 */
package com.gmcc.pboss.control.sales.salesstd;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.business.sales.salesstd.SalesstdVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Salesstd </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Salesstd extends AbstractControl {
    public SalesstdVO doCreate(SalesstdVO vo) throws Exception;

    public void doRemoveByVO(SalesstdVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SalesstdVO doUpdate(SalesstdVO vo) throws Exception;

    public SalesstdVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SalesstdDBParam params) throws Exception;

    public DataPackage doListQuery(SalesstdDBParam params) throws Exception;
    

}
