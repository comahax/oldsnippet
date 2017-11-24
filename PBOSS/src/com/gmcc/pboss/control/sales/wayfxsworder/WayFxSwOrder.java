/**
 * auto-generated code
 * Tue Dec 14 15:42:11 CST 2010
 */
package com.gmcc.pboss.control.sales.wayfxsworder;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderDBParam;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WayFxSwOrder </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface WayFxSwOrder extends AbstractControl {
    public WayFxSwOrderVO doCreate(WayFxSwOrderVO vo) throws Exception;

    public void doRemoveByVO(WayFxSwOrderVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayFxSwOrderVO doUpdate(WayFxSwOrderVO vo) throws Exception;

    public WayFxSwOrderVO doFindByPk(Serializable pk) throws Exception;

//    public DataPackage doQuery(WayFxSwOrderDBParam params) throws Exception;
    public DataPackage doQueryWayFxOrder(Map<String,String> conditionMap, WayFxSwOrderDBParam param) throws Exception ;

}
