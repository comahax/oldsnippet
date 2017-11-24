/**
* auto-generated code
* Fri Oct 15 15:45:05 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.disintegrallog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogVO;
import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogListVO;
import com.sunrise.boss.business.cms.reward.disintegrallog.control.DisintegrallogControlBean;
import com.sunrise.boss.business.cms.reward.disintegrallog.control.DisintegrallogControl;

import java.io.Serializable;

/**
 * <p>Title: DisintegrallogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class DisintegrallogDelegate {

    private static DisintegrallogControl control;

    public DisintegrallogDelegate() throws Exception {
        control = (DisintegrallogControl) ControlFactory.build(DisintegrallogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DisintegrallogVO doCreate(DisintegrallogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(DisintegrallogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public DisintegrallogVO doUpdate(DisintegrallogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public DisintegrallogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (DisintegrallogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(DisintegrallogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
