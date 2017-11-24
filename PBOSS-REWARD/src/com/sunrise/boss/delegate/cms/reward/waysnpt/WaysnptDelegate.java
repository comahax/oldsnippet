/**
* auto-generated code
* Tue Jul 14 16:42:23 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.waysnpt;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptVO;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptListVO;
import com.sunrise.boss.business.cms.reward.waysnpt.control.WaysnptControlBean;
import com.sunrise.boss.business.cms.reward.waysnpt.control.WaysnptControl;

import java.io.Serializable;

/**
 * <p>Title: WaysnptDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaysnptDelegate {

    private static WaysnptControl control;

    public WaysnptDelegate() throws Exception {
        control = (WaysnptControl) ControlFactory.build(WaysnptControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public WaysnptVO doCreate(WaysnptVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(WaysnptVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public WaysnptVO doUpdate(WaysnptVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public WaysnptVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WaysnptVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(WaysnptListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
