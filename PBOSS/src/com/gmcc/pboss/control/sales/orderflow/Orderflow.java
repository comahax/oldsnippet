/**
 * auto-generated code
 * Wed Oct 14 10:59:52 CST 2009
 */
package com.gmcc.pboss.control.sales.orderflow;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderflow.OrderflowDBParam;
import com.gmcc.pboss.business.sales.orderflow.OrderflowVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderflow </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Orderflow extends AbstractControl {
    public OrderflowVO doCreate(OrderflowVO vo) throws Exception;

    public void doRemoveByVO(OrderflowVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderflowVO doUpdate(OrderflowVO vo) throws Exception;

    public OrderflowVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderflowDBParam params) throws Exception;

}
