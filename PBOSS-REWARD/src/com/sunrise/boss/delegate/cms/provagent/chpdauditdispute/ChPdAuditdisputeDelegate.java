/**
* auto-generated code
* Tue Sep 03 20:54:50 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdauditdispute;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeVO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeListVO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.control.ChPdAuditdisputeControlBean;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.control.ChPdAuditdisputeControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdAuditdisputeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPdAuditdisputeDelegate {

    private static ChPdAuditdisputeControl control;

    public ChPdAuditdisputeDelegate() throws Exception {
        control = (ChPdAuditdisputeControl) ControlFactory.build(ChPdAuditdisputeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdAuditdisputeVO doCreate(ChPdAuditdisputeVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdAuditdisputeVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdAuditdisputeVO doUpdate(ChPdAuditdisputeVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdAuditdisputeVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdAuditdisputeVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdAuditdisputeListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
