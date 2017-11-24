/**
* auto-generated code
* Mon Apr 08 15:52:02 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtyterewardstd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdVO;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdListVO;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.control.ChZjtyTerewardstdControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.control.ChZjtyTerewardstdControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyTerewardstdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChZjtyTerewardstdDelegate {

    private static ChZjtyTerewardstdControl control;

    public ChZjtyTerewardstdDelegate() throws Exception {
        control = (ChZjtyTerewardstdControl) ControlFactory.build(ChZjtyTerewardstdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyTerewardstdVO doCreate(ChZjtyTerewardstdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyTerewardstdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyTerewardstdVO doUpdate(ChZjtyTerewardstdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyTerewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyTerewardstdVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyTerewardstdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
