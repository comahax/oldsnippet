/**
 * auto-generated code
 * Mon Sep 07 10:58:56 CST 2009
 */
package com.gmcc.pboss.control.base.sysparamlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.sysparamlog.SysparamlogDBParam;
import com.gmcc.pboss.business.base.sysparamlog.SysparamlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Sysparamlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Sysparamlog extends AbstractControl {
    public SysparamlogVO doCreate(SysparamlogVO vo) throws Exception;

    public void doRemoveByVO(SysparamlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SysparamlogVO doUpdate(SysparamlogVO vo) throws Exception;

    public SysparamlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SysparamlogDBParam params) throws Exception;

}
