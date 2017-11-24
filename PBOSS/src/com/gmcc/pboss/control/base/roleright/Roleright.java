/**
 * auto-generated code
 * Thu Jul 09 16:16:16 CST 2009
 */
package com.gmcc.pboss.control.base.roleright;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.base.roleright.RolerightDBParam;
import com.gmcc.pboss.business.base.roleright.RolerightVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Roleright </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public interface Roleright extends AbstractControl {
    public RolerightVO doCreate(RolerightVO vo) throws Exception;

    public void doRemoveByVO(RolerightVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RolerightVO doUpdate(RolerightVO vo) throws Exception;

    public RolerightVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RolerightDBParam params,User user) throws Exception;
    
    public void doBatchSave(List rightList, List roleList) throws Exception;
}
