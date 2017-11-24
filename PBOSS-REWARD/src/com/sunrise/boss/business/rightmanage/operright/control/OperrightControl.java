/**
* auto-generated code
* Fri Oct 20 01:01:43 CST 2006
*/
package com.sunrise.boss.business.rightmanage.operright.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightListVO;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightVO;

import java.io.Serializable;

/**
 * <p>Title: SaSrOperrightControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface OperrightControl extends AbstractControl {
    public OperrightVO doCreate(OperrightVO vo, User user)
        throws Exception;

    public void doRemove(OperrightVO vo, User user)
        throws Exception;

    public OperrightVO doUpdate(OperrightVO vo, User user)
        throws Exception;

    public OperrightVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(OperrightListVO params, User user)
        throws Exception;
    public void doBatchin(OperrightVO vo,User user)throws Exception;
}
