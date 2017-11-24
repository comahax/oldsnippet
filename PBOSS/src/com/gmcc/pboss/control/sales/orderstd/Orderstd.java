/**
 * auto-generated code
 * Tue Oct 13 14:29:08 CST 2009
 */
package com.gmcc.pboss.control.sales.orderstd;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderstd.OrderstdDBParam;
import com.gmcc.pboss.business.sales.orderstd.OrderstdVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderstd </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Orderstd extends AbstractControl {
    public OrderstdVO doCreate(OrderstdVO vo) throws Exception;

    public void doRemoveByVO(OrderstdVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderstdVO doUpdate(OrderstdVO vo) throws Exception;

    public OrderstdVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderstdDBParam params) throws Exception;

}
