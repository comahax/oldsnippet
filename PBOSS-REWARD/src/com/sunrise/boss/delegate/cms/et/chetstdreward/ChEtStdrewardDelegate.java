/**
* auto-generated code
* Tue Jul 17 16:46:57 CST 2012
*/
package com.sunrise.boss.delegate.cms.et.chetstdreward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardVO;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardListVO;
import com.sunrise.boss.business.cms.et.chetstdreward.control.ChEtStdrewardControlBean;
import com.sunrise.boss.business.cms.et.chetstdreward.control.ChEtStdrewardControl;

import java.io.Serializable;

/**
 * <p>Title: ChEtStdrewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChEtStdrewardDelegate {

    private static ChEtStdrewardControl control;

    public ChEtStdrewardDelegate() throws Exception {
        control = (ChEtStdrewardControl) ControlFactory.build(ChEtStdrewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChEtStdrewardVO doCreate(ChEtStdrewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChEtStdrewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChEtStdrewardVO doUpdate(ChEtStdrewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChEtStdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChEtStdrewardVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChEtStdrewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
