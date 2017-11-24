/**
* auto-generated code
* Fri May 16 09:53:52 CST 2008
*/
package com.sunrise.boss.business.cms.waysyn.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waysyn.persistent.WaysynVO;

import java.io.Serializable;

/**
 * <p>Title: WaysynControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface WaysynControl extends AbstractControl {
    public WaysynVO doCreate(WaysynVO vo, User user)
        throws Exception;

    public void doRemove(WaysynVO vo, User user)
        throws Exception;

    public WaysynVO doUpdate(WaysynVO vo, User user)
        throws Exception;

    public WaysynVO doFindByPk(Serializable pk, User user)
        throws Exception;

}
