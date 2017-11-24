/**
 * auto-generated code
 * Tue Dec 14 14:53:32 CST 2010
 */
package com.gmcc.pboss.control.sales.orderstate;

import java.io.Serializable;
import com.gmcc.pboss.business.sales.orderstate.OrderstateDBParam;
import com.gmcc.pboss.business.sales.orderstate.OrderstateVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderstate </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public interface Orderstate extends AbstractControl {
    public OrderstateVO doCreate(OrderstateVO vo) throws Exception;

    public void doRemoveByVO(OrderstateVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderstateVO doUpdate(OrderstateVO vo) throws Exception;

    public OrderstateVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderstateDBParam params) throws Exception;

    public DataPackage doQueryState(OrderstateDBParam params) throws Exception;
}
