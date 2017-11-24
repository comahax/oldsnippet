/**
 * auto-generated code
 * Tue Oct 18 19:25:01 CST 2011
 */
package com.gmcc.pboss.control.reward.cardrewdettotal;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDBParam;
import com.gmcc.pboss.business.reward.cardrewdettotal.CardrewdettotalDBParam;
import com.gmcc.pboss.business.reward.cardrewdettotal.CardrewdettotalVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cardrewdettotal </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Cardrewdettotal extends AbstractControl {
    public CardrewdettotalVO doCreate(CardrewdettotalVO vo) throws Exception;

    public void doRemoveByVO(CardrewdettotalVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CardrewdettotalVO doUpdate(CardrewdettotalVO vo) throws Exception;

    public CardrewdettotalVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CardrewdettotalDBParam params) throws Exception;
    public DataPackage doQu(Map<String,String> conditionMap,CardrewdettotalDBParam params) throws Exception;

}
