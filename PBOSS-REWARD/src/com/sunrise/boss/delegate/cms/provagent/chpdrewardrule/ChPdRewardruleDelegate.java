/**
* auto-generated code
* Wed Sep 04 16:35:49 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdrewardrule;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleListVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.control.ChPdRewardruleControlBean;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.control.ChPdRewardruleControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdRewardruleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardruleDelegate {

    private static ChPdRewardruleControl control;

    public ChPdRewardruleDelegate() throws Exception {
        control = (ChPdRewardruleControl) ControlFactory.build(ChPdRewardruleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdRewardruleVO doCreate(ChPdRewardruleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdRewardruleVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdRewardruleVO doUpdate(ChPdRewardruleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdRewardruleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdRewardruleVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdRewardruleListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
