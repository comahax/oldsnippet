/**
 * auto-generated code
 * Fri Oct 16 13:35:33 CST 2009
 */
package com.gmcc.pboss.control.sales.ordertask;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.ordertask.OrdertaskDBParam;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ordertask </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Ordertask extends AbstractControl {
    public OrdertaskVO doCreate(OrdertaskVO vo) throws Exception;

    public void doRemoveByVO(OrdertaskVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrdertaskVO doUpdate(OrdertaskVO vo) throws Exception;

    public OrdertaskVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrdertaskDBParam params) throws Exception;

}
