/**
 * auto-generated code
 * Thu Sep 17 15:58:40 CST 2009
 */
package com.gmcc.pboss.control.promotion.daemonreg;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.daemonreg.DaemonregDBParam;
import com.gmcc.pboss.business.promotion.daemonreg.DaemonregVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Daemonreg </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Daemonreg extends AbstractControl {
    public DaemonregVO doCreate(DaemonregVO vo) throws Exception;

    public void doRemoveByVO(DaemonregVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DaemonregVO doUpdate(DaemonregVO vo) throws Exception;

    public DaemonregVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DaemonregDBParam params) throws Exception;

}
