/**
* auto-generated code
* Fri Apr 09 12:40:50 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.terminalsucc;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccVO;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccListVO;
import com.sunrise.boss.business.cms.reward.terminalsucc.control.TerminalsuccControlBean;
import com.sunrise.boss.business.cms.reward.terminalsucc.control.TerminalsuccControl;

import java.io.Serializable;

/**
 * <p>Title: TerminalsuccDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TerminalsuccDelegate {

    private static TerminalsuccControl control;

    public TerminalsuccDelegate() throws Exception {
        control = (TerminalsuccControl) ControlFactory.build(TerminalsuccControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public TerminalsuccVO doCreate(TerminalsuccVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(TerminalsuccVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public TerminalsuccVO doUpdate(TerminalsuccVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public TerminalsuccVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (TerminalsuccVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(TerminalsuccListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
