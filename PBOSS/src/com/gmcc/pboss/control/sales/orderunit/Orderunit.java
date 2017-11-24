/**
 * auto-generated code
 * Tue Oct 13 14:32:53 CST 2009
 */
package com.gmcc.pboss.control.sales.orderunit;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderunit.OrderunitDBParam;
import com.gmcc.pboss.business.sales.orderunit.OrderunitVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderunit </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Orderunit extends AbstractControl {
    public OrderunitVO doCreate(OrderunitVO vo) throws Exception;

    public void doRemoveByVO(OrderunitVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderunitVO doUpdate(OrderunitVO vo) throws Exception;

    public OrderunitVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderunitDBParam params) throws Exception;

}
