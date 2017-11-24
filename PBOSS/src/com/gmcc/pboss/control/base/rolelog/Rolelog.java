/**
 * auto-generated code
 * Mon Sep 07 10:46:06 CST 2009
 */
package com.gmcc.pboss.control.base.rolelog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rolelog.RolelogDBParam;
import com.gmcc.pboss.business.base.rolelog.RolelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rolelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Rolelog extends AbstractControl {
    public RolelogVO doCreate(RolelogVO vo) throws Exception;

    public void doRemoveByVO(RolelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RolelogVO doUpdate(RolelogVO vo) throws Exception;

    public RolelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RolelogDBParam params) throws Exception;

}
