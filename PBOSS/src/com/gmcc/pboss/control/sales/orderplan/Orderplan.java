/**
 * auto-generated code
 * Tue Oct 13 16:28:22 CST 2009
 */
package com.gmcc.pboss.control.sales.orderplan;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderplan.OrderplanDBParam;
import com.gmcc.pboss.business.sales.orderplan.OrderplanVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderplan </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Orderplan extends AbstractControl {
    public OrderplanVO doCreate(OrderplanVO vo) throws Exception;

    public void doRemoveByVO(OrderplanVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderplanVO doUpdate(OrderplanVO vo) throws Exception;

    public OrderplanVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderplanDBParam params) throws Exception;

}
