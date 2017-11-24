/**
 * auto-generated code
 * Fri May 07 16:29:05 CST 2010
 */
package com.gmcc.pboss.control.sales.ordertimes;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.ordertimes.OrdertimesDBParam;
import com.gmcc.pboss.business.sales.ordertimes.OrdertimesVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ordertimes </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public interface Ordertimes extends AbstractControl {
    public OrdertimesVO doCreate(OrdertimesVO vo) throws Exception;

    public void doRemoveByVO(OrdertimesVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrdertimesVO doUpdate(OrdertimesVO vo) throws Exception;

    public OrdertimesVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrdertimesDBParam params) throws Exception;

}
