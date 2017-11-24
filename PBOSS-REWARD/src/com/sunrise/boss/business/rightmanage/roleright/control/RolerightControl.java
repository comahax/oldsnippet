/**
* auto-generated code
* Thu Oct 19 17:09:08 CST 2006
*/
package com.sunrise.boss.business.rightmanage.roleright.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightListVO;
import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightVO;

import java.io.Serializable;

/**
 * <p>Title: RolerightControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RolerightControl extends AbstractControl {
    public RolerightVO doCreate(RolerightVO vo, User user)
        throws Exception;

    public void doRemove(RolerightVO vo, User user)
        throws Exception;

    public RolerightVO doUpdate(RolerightVO vo, User user)
        throws Exception;

    public RolerightVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RolerightListVO params, User user)
        throws Exception;
    public void doBatchin(RolerightVO vo,User user)throws Exception;

}
