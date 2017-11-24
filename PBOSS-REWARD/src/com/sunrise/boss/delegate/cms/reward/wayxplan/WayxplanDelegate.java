/**
* auto-generated code
* Fri Jul 30 12:01:21 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.wayxplan;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanVO;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanListVO;
import com.sunrise.boss.business.cms.reward.wayxplan.control.WayxplanControlBean;
import com.sunrise.boss.business.cms.reward.wayxplan.control.WayxplanControl;

import java.io.Serializable;

/**
 * <p>Title: WayxplanDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class WayxplanDelegate {

    private static WayxplanControl control;

    public WayxplanDelegate() throws Exception {
        control = (WayxplanControl) ControlFactory.build(WayxplanControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public WayxplanVO doCreate(WayxplanVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(WayxplanVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public WayxplanVO doUpdate(WayxplanVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public WayxplanVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WayxplanVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(WayxplanListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
