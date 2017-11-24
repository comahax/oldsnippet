/**
 * auto-generated code
 * Tue Oct 18 10:45:19 CST 2011
 */
package com.gmcc.pboss.control.reward.cardrewdetlog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogDBParam;
import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cardrewdetlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Cardrewdetlog extends AbstractControl {
    public CardrewdetlogVO doCreate(CardrewdetlogVO vo) throws Exception;

    public void doRemoveByVO(CardrewdetlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CardrewdetlogVO doUpdate(CardrewdetlogVO vo) throws Exception;

    public CardrewdetlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CardrewdetlogDBParam params) throws Exception;

}
