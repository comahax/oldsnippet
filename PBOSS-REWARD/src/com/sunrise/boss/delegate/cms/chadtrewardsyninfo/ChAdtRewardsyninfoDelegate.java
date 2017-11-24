/**
* auto-generated code
* Mon Apr 01 16:53:28 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtrewardsyninfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoVO;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoListVO;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.control.ChAdtRewardsyninfoControlBean;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.control.ChAdtRewardsyninfoControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtRewardsyninfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtRewardsyninfoDelegate {

    private static ChAdtRewardsyninfoControl control;

    public ChAdtRewardsyninfoDelegate() throws Exception {
        control = (ChAdtRewardsyninfoControl) ControlFactory.build(ChAdtRewardsyninfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtRewardsyninfoVO doCreate(ChAdtRewardsyninfoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtRewardsyninfoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtRewardsyninfoVO doUpdate(ChAdtRewardsyninfoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtRewardsyninfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtRewardsyninfoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtRewardsyninfoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
