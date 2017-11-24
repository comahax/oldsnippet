/**
* auto-generated code
* Wed Sep 04 16:27:47 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdreportfile;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileVO;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileListVO;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.control.ChPdReportfileControlBean;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.control.ChPdReportfileControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdReportfileDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdReportfileDelegate {

    private static ChPdReportfileControl control;

    public ChPdReportfileDelegate() throws Exception {
        control = (ChPdReportfileControl) ControlFactory.build(ChPdReportfileControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdReportfileVO doCreate(ChPdReportfileVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdReportfileVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdReportfileVO doUpdate(ChPdReportfileVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdReportfileVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdReportfileVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdReportfileListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
