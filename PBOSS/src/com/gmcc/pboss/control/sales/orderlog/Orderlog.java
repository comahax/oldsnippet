/**
 * auto-generated code
 * Tue Apr 24 15:01:18 CST 2012
 */
package com.gmcc.pboss.control.sales.orderlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Orderlog extends AbstractControl {
    public OrderlogVO doCreate(OrderlogVO vo) throws Exception;

    public void doRemoveByVO(OrderlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderlogVO doUpdate(OrderlogVO vo) throws Exception;

    public OrderlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderlogDBParam params) throws Exception;
    
    public DataPackage doExportList(OrderlogDBParam params) throws Exception;

}
