/**
 * auto-generated code
 * Tue Oct 13 14:30:52 CST 2009
 */
package com.gmcc.pboss.control.sales.orderuplimit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderuplimit </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Orderuplimit extends AbstractControl {
    public OrderuplimitVO doCreate(OrderuplimitVO vo) throws Exception;

    public void doRemoveByVO(OrderuplimitVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderuplimitVO doUpdate(OrderuplimitVO vo) throws Exception;

    public OrderuplimitVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderuplimitDBParam params) throws Exception;
    
    public List doQueryEmptysimtype(OrderuplimitDBParam params) throws Exception;
		
	}

 
