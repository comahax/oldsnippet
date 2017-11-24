/**
 * auto-generated code
 * Wed Oct 14 13:53:36 CST 2009
 */
package com.gmcc.pboss.control.sales.orderproce;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderproce </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Orderproce extends AbstractControl {
    public OrderproceVO doCreate(OrderproceVO vo) throws Exception;

    public void doRemoveByVO(OrderproceVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderproceVO doUpdate(OrderproceVO vo) throws Exception;

    public OrderproceVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderproceDBParam params) throws Exception;    

}
