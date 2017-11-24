/**
 * auto-generated code
 * Tue Sep 01 21:01:30 CST 2009
 */
package com.gmcc.pboss.control.base.rolefunction;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.base.rolefunction.RolefunctionDBParam;
import com.gmcc.pboss.business.base.rolefunction.RolefunctionVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Rolefunction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Rolefunction extends AbstractControl {
    public RolefunctionVO doCreate(RolefunctionVO vo) throws Exception;

    public void doRemoveByVO(RolefunctionVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RolefunctionVO doUpdate(RolefunctionVO vo) throws Exception;

    public RolefunctionVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RolefunctionDBParam params,User user) throws Exception;

    public void doBatchSave(List funcList, List roleList) throws Exception;
}
