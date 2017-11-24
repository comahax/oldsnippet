/**
 * auto-generated code
 * Sat Dec 18 09:48:51 CST 2010
 */
package com.gmcc.pboss.control.sales.orderresdetwayorder;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderDBParam;
import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresdetWayOrder </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface OrderresdetWayOrder extends AbstractControl {
    public OrderresdetWayOrderVO doCreate(OrderresdetWayOrderVO vo) throws Exception;

    public void doRemoveByVO(OrderresdetWayOrderVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderresdetWayOrderVO doUpdate(OrderresdetWayOrderVO vo) throws Exception;

    public OrderresdetWayOrderVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderresdetWayOrderDBParam params) throws Exception;

    public DataPackage doQueryOrderresdetWayOrder(Map<String,String> conditionMap, OrderresdetWayOrderDBParam param) throws Exception ;
    
}
