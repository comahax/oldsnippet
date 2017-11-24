/**
* auto-generated code
* Sat Nov 16 10:49:38 CST 2013
*/
package com.sunrise.boss.delegate.cms.reward.chadtwayspecialreward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardVO;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardListVO;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.control.ChAdtWayspecialrewardControlBean;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.control.ChAdtWayspecialrewardControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtWayspecialrewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChAdtWayspecialrewardDelegate {

    private static ChAdtWayspecialrewardControl control;

    public ChAdtWayspecialrewardDelegate() throws Exception {
        control = (ChAdtWayspecialrewardControl) ControlFactory.build(ChAdtWayspecialrewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtWayspecialrewardVO doCreate(ChAdtWayspecialrewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtWayspecialrewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtWayspecialrewardVO doUpdate(ChAdtWayspecialrewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtWayspecialrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtWayspecialrewardVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtWayspecialrewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
