/**
 * auto-generated code
 * Tue Oct 13 14:32:53 CST 2009
 */
package com.gmcc.pboss.control.sales.orderunitweek;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.orderunitweek.OrderunitweekDBParam;
import com.gmcc.pboss.business.sales.orderunitweek.OrderunitweekVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderunit </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Orderunitweek extends AbstractControl {
    public OrderunitweekVO doCreate(OrderunitweekVO vo) throws Exception;

    public void doRemoveByVO(OrderunitweekVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderunitweekVO doUpdate(OrderunitweekVO vo) throws Exception;

    public OrderunitweekVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderunitweekDBParam params) throws Exception;

}
