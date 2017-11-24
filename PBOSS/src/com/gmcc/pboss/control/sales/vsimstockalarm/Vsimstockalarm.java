/**
 * auto-generated code
 * Sat Mar 31 16:00:36 CST 2012
 */
package com.gmcc.pboss.control.sales.vsimstockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.vsimstockalarm.VsimstockalarmDBParam;
import com.gmcc.pboss.business.sales.vsimstockalarm.VsimstockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Vsimstockalarm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface Vsimstockalarm extends AbstractControl {
    public VsimstockalarmVO doCreate(VsimstockalarmVO vo) throws Exception;

    public void doRemoveByVO(VsimstockalarmVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public VsimstockalarmVO doUpdate(VsimstockalarmVO vo) throws Exception;

    public VsimstockalarmVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(VsimstockalarmDBParam params) throws Exception;

}
