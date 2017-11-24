/**
 * auto-generated code
 * Sat Dec 18 20:30:45 CST 2010
 */
package com.gmcc.pboss.control.sales.orderresdetwayorderdetail;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderDBParam;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailDBParam;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresdetWayOrderDetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface OrderresdetWayOrderDetail extends AbstractControl {
    public OrderresdetWayOrderDetailVO doCreate(OrderresdetWayOrderDetailVO vo) throws Exception;

    public void doRemoveByVO(OrderresdetWayOrderDetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderresdetWayOrderDetailVO doUpdate(OrderresdetWayOrderDetailVO vo) throws Exception;

    public OrderresdetWayOrderDetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderresdetWayOrderDetailDBParam params) throws Exception;

    public DataPackage doQueryOrderresdetWayOrderDetail(Map<String,String> conditionMap, OrderresdetWayOrderDetailDBParam param) throws Exception ;
}
