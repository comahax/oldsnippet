/**
 * auto-generated code
 * Wed Nov 18 17:19:05 CST 2009
 */
package com.gmcc.pboss.control.sales.orderreq;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderreq.OrderreqDBParam;
import com.gmcc.pboss.business.sales.orderreq.OrderreqVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderreq </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Orderreq extends AbstractControl {
    public OrderreqVO doCreate(OrderreqVO vo) throws Exception;

    public void doRemoveByVO(OrderreqVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderreqVO doUpdate(OrderreqVO vo) throws Exception;

    public OrderreqVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderreqDBParam params) throws Exception;

}
