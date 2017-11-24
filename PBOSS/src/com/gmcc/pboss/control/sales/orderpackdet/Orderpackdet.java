/**
 * auto-generated code
 * Tue Oct 13 14:59:20 CST 2009
 */
package com.gmcc.pboss.control.sales.orderpackdet;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetDBParam;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderpackdet </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Orderpackdet extends AbstractControl {
    public OrderpackdetVO doCreate(OrderpackdetVO vo) throws Exception;

    public void doRemoveByVO(OrderpackdetVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderpackdetVO doUpdate(OrderpackdetVO vo) throws Exception;

    public OrderpackdetVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderpackdetDBParam params) throws Exception;

}
