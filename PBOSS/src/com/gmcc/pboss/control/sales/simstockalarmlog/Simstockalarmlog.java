/**
 * auto-generated code
 * Sat Mar 31 19:25:50 CST 2012
 */
package com.gmcc.pboss.control.sales.simstockalarmlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogDBParam;
import com.gmcc.pboss.business.sales.simstockalarmlog.SimstockalarmlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Simstockalarmlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface Simstockalarmlog extends AbstractControl {
    public SimstockalarmlogVO doCreate(SimstockalarmlogVO vo) throws Exception;

    public void doRemoveByVO(SimstockalarmlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SimstockalarmlogVO doUpdate(SimstockalarmlogVO vo) throws Exception;

    public SimstockalarmlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SimstockalarmlogDBParam params) throws Exception;

}
