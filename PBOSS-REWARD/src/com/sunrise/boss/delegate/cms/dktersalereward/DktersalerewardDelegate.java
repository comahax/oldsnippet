/**
* auto-generated code
* Fri May 03 16:45:00 CST 2013
*/
package com.sunrise.boss.delegate.cms.dktersalereward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardVO;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardListVO;
import com.sunrise.boss.business.cms.dktersalereward.control.DktersalerewardControlBean;
import com.sunrise.boss.business.cms.dktersalereward.control.DktersalerewardControl;

import java.io.Serializable;

/**
 * <p>Title: DktersalerewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DktersalerewardDelegate {

    private static DktersalerewardControl control;

    public DktersalerewardDelegate() throws Exception {
        control = (DktersalerewardControl) ControlFactory.build(DktersalerewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DktersalerewardVO doCreate(DktersalerewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(DktersalerewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public DktersalerewardVO doUpdate(DktersalerewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public DktersalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (DktersalerewardVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(DktersalerewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQueryRewardTotal(DktersalerewardListVO params, User user)
        throws Exception {
        return control.doQueryRewardTotal(params, user);
    }
}
