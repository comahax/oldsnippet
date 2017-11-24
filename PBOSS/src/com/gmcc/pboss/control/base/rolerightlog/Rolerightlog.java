/**
 * auto-generated code
 * Mon Sep 07 10:50:13 CST 2009
 */
package com.gmcc.pboss.control.base.rolerightlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rolerightlog.RolerightlogDBParam;
import com.gmcc.pboss.business.base.rolerightlog.RolerightlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rolerightlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Rolerightlog extends AbstractControl {
    public RolerightlogVO doCreate(RolerightlogVO vo) throws Exception;

    public void doRemoveByVO(RolerightlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RolerightlogVO doUpdate(RolerightlogVO vo) throws Exception;

    public RolerightlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RolerightlogDBParam params) throws Exception;

}
