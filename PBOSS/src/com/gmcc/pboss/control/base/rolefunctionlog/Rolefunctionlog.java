/**
 * auto-generated code
 * Mon Sep 07 10:49:06 CST 2009
 */
package com.gmcc.pboss.control.base.rolefunctionlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogDBParam;
import com.gmcc.pboss.business.base.rolefunctionlog.RolefunctionlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rolefunctionlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Rolefunctionlog extends AbstractControl {
    public RolefunctionlogVO doCreate(RolefunctionlogVO vo) throws Exception;

    public void doRemoveByVO(RolefunctionlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RolefunctionlogVO doUpdate(RolefunctionlogVO vo) throws Exception;

    public RolefunctionlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RolefunctionlogDBParam params) throws Exception;

}
