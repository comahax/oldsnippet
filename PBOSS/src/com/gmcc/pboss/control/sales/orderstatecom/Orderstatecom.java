/**
 * auto-generated code
 * Wed Dec 15 18:40:46 CST 2010
 */
package com.gmcc.pboss.control.sales.orderstatecom;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderstatecom.OrderstatecomDBParam;
import com.gmcc.pboss.business.sales.orderstatecom.OrderstatecomVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderstatecom </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public interface Orderstatecom extends AbstractControl {
    public OrderstatecomVO doCreate(OrderstatecomVO vo) throws Exception;

    public void doRemoveByVO(OrderstatecomVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderstatecomVO doUpdate(OrderstatecomVO vo) throws Exception;

    public OrderstatecomVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderstatecomDBParam params) throws Exception;

    public DataPackage doQueryStatecom(OrderstatecomDBParam params) throws Exception;
}
