/**
 * auto-generated code
 * Wed Oct 26 09:57:14 CST 2011
 */
package com.gmcc.pboss.control.sales.salesstdlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogDBParam;
import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Salesstdlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Salesstdlog extends AbstractControl {
    public SalesstdlogVO doCreate(SalesstdlogVO vo) throws Exception;

    public void doRemoveByVO(SalesstdlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SalesstdlogVO doUpdate(SalesstdlogVO vo) throws Exception;

    public SalesstdlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SalesstdlogDBParam params) throws Exception;

}
