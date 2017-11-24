/**
 * auto-generated code
 * Wed Aug 10 16:07:59 CST 2011
 */
package com.gmcc.pboss.control.sales.orderorderproce;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderorderproce.OrderOrderproceDBParam;
import com.gmcc.pboss.business.sales.orderorderproce.OrderOrderproceVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderOrderproce </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface OrderOrderproce extends AbstractControl {
    public OrderOrderproceVO doCreate(OrderOrderproceVO vo) throws Exception;

    public void doRemoveByVO(OrderOrderproceVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderOrderproceVO doUpdate(OrderOrderproceVO vo) throws Exception;

    public OrderOrderproceVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderOrderproceDBParam params) throws Exception;
    
    public DataPackage doQueryProce(Map<String,String> conditionMap,OrderOrderproceDBParam params) throws Exception;
    
    public DataPackage doQueryProceDetail(Map<String,String> conditionMap,OrderOrderproceDBParam params) throws Exception;

}
