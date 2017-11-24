/**
* auto-generated code
* Wed Sep 04 16:18:46 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdreportitem;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemVO;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemListVO;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.control.ChPdReportitemControlBean;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.control.ChPdReportitemControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdReportitemDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdReportitemDelegate {

    private static ChPdReportitemControl control;

    public ChPdReportitemDelegate() throws Exception {
        control = (ChPdReportitemControl) ControlFactory.build(ChPdReportitemControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdReportitemVO doCreate(ChPdReportitemVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdReportitemVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdReportitemVO doUpdate(ChPdReportitemVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdReportitemVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdReportitemVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdReportitemListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
