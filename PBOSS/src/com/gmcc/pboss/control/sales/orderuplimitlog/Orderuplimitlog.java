/**
 * auto-generated code
 * Wed Jun 23 08:51:05 CST 2010
 */
package com.gmcc.pboss.control.sales.orderuplimitlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogDBParam;
import com.gmcc.pboss.business.sales.orderuplimitlog.OrderuplimitlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderuplimitlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Orderuplimitlog extends AbstractControl {
    public OrderuplimitlogVO doCreate(OrderuplimitlogVO vo) throws Exception;

    public void doRemoveByVO(OrderuplimitlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderuplimitlogVO doUpdate(OrderuplimitlogVO vo) throws Exception;

    public OrderuplimitlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderuplimitlogDBParam params) throws Exception;

}
