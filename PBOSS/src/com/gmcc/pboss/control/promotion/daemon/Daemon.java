/**
 * auto-generated code
 * Thu Sep 17 10:37:46 CST 2009
 */
package com.gmcc.pboss.control.promotion.daemon;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.daemon.DaemonDBParam;
import com.gmcc.pboss.business.promotion.daemon.DaemonVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Daemon </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Daemon extends AbstractControl {
    public DaemonVO doCreate(DaemonVO vo) throws Exception;

    public void doRemoveByVO(DaemonVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DaemonVO doUpdate(DaemonVO vo) throws Exception;

    public DaemonVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DaemonDBParam params) throws Exception;

}
