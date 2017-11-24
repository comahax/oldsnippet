/**
* auto-generated code
* Mon Sep 02 12:21:21 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdagent;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdagent.control.ChPdAgentControl;
import com.sunrise.boss.business.cms.provagent.chpdagent.control.ChPdAgentControlBean;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentListVO;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdAgentDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdAgentDelegate {

    private static ChPdAgentControl control;

    public ChPdAgentDelegate() throws Exception {
        control = (ChPdAgentControl) ControlFactory.build(ChPdAgentControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdAgentVO doCreate(ChPdAgentVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdAgentVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdAgentVO doUpdate(ChPdAgentVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdAgentVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdAgentVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdAgentListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
