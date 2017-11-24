/**
 * auto-generated code
 * Thu Oct 13 15:54:23 CST 2011
 */
package com.gmcc.pboss.control.reward.cardrewdet;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDBParam;
import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cardrewdet </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Cardrewdet extends AbstractControl {
    public CardrewdetVO doCreate(CardrewdetVO vo) throws Exception;

    public void doRemoveByVO(CardrewdetVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CardrewdetVO doUpdate(CardrewdetVO vo) throws Exception;

    public CardrewdetVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CardrewdetDBParam params) throws Exception;
    
    public DataPackage doQu(Map<String,String> conditionMap,CardrewdetDBParam params) throws Exception;

}
