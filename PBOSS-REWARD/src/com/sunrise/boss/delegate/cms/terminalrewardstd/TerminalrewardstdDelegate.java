/**
* auto-generated code
* Sat Jan 05 17:17:55 CST 2013
*/
package com.sunrise.boss.delegate.cms.terminalrewardstd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdVO;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdListVO;
import com.sunrise.boss.business.cms.terminalrewardstd.control.TerminalrewardstdControlBean;
import com.sunrise.boss.business.cms.terminalrewardstd.control.TerminalrewardstdControl;

import java.io.Serializable;

/**
 * <p>Title: TerminalrewardstdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public class TerminalrewardstdDelegate {

    private static TerminalrewardstdControl control;

    public TerminalrewardstdDelegate() throws Exception {
        control = (TerminalrewardstdControl) ControlFactory.build(TerminalrewardstdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public TerminalrewardstdVO doCreate(TerminalrewardstdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(TerminalrewardstdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public TerminalrewardstdVO doUpdate(TerminalrewardstdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public TerminalrewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (TerminalrewardstdVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(TerminalrewardstdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
