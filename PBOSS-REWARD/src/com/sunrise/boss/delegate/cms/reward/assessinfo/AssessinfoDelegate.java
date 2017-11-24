/**
* auto-generated code
* Thu Dec 01 14:14:15 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.assessinfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoListVO;
import com.sunrise.boss.business.cms.reward.assessinfo.control.AssessinfoControlBean;
import com.sunrise.boss.business.cms.reward.assessinfo.control.AssessinfoControl;

import java.io.Serializable;

/**
 * <p>Title: AssessinfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class AssessinfoDelegate {

    private static AssessinfoControl control;

    public AssessinfoDelegate() throws Exception {
        control = (AssessinfoControl) ControlFactory.build(AssessinfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public AssessinfoVO doCreate(AssessinfoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(AssessinfoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public AssessinfoVO doUpdate(AssessinfoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public AssessinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (AssessinfoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(AssessinfoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
