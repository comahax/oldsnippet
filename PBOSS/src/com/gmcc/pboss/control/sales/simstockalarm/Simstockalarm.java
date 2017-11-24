/**
 * auto-generated code
 * Sat Mar 31 10:28:57 CST 2012
 */
package com.gmcc.pboss.control.sales.simstockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmDBParam;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Simstockalarm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface Simstockalarm extends AbstractControl {
    public SimstockalarmVO doCreate(SimstockalarmVO vo) throws Exception;

    public void doRemoveByVO(SimstockalarmVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SimstockalarmVO doUpdate(SimstockalarmVO vo) throws Exception;

    public SimstockalarmVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SimstockalarmDBParam params) throws Exception;
}
