/**
* auto-generated code
* Tue Jul 14 16:42:23 CST 2009
*/
package com.sunrise.boss.business.cms.reward.waysnpt.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptVO;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptListVO;

import java.io.Serializable;

/**
 * <p>Title: WaysnptControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface WaysnptControl extends AbstractControl {
    public WaysnptVO doCreate(WaysnptVO vo, User user)
        throws Exception;

    public void doRemove(WaysnptVO vo, User user)
        throws Exception;

    public WaysnptVO doUpdate(WaysnptVO vo, User user)
        throws Exception;

    public WaysnptVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaysnptListVO params, User user)
        throws Exception;

}
