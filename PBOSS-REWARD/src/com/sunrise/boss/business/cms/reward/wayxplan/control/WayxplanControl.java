/**
* auto-generated code
* Fri Jul 30 12:01:21 CST 2010
*/
package com.sunrise.boss.business.cms.reward.wayxplan.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanVO;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanListVO;

import java.io.Serializable;

/**
 * <p>Title: WayxplanControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public interface WayxplanControl extends AbstractControl {
    public WayxplanVO doCreate(WayxplanVO vo, User user)
        throws Exception;

    public void doRemove(WayxplanVO vo, User user)
        throws Exception;

    public WayxplanVO doUpdate(WayxplanVO vo, User user)
        throws Exception;

    public WayxplanVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WayxplanListVO params, User user)
        throws Exception;

}
