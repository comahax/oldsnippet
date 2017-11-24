/**
* auto-generated code
* Fri Oct 15 15:43:08 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.disintegral;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralVO;
import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralListVO;
import com.sunrise.boss.business.cms.reward.disintegral.control.DisintegralControlBean;
import com.sunrise.boss.business.cms.reward.disintegral.control.DisintegralControl;

import java.io.Serializable;

/**
 * <p>Title: DisintegralDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DisintegralDelegate {

    private static DisintegralControl control;

    public DisintegralDelegate() throws Exception {
        control = (DisintegralControl) ControlFactory.build(DisintegralControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DisintegralVO doCreate(DisintegralVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(DisintegralVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public DisintegralVO doUpdate(DisintegralVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public DisintegralVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (DisintegralVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(DisintegralListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
