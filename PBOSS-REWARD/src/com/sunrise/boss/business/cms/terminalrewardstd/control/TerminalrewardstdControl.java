/**
* auto-generated code
* Sat Jan 05 17:17:55 CST 2013
*/
package com.sunrise.boss.business.cms.terminalrewardstd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdVO;
import com.sunrise.boss.business.cms.terminalrewardstd.persistent.TerminalrewardstdListVO;

import java.io.Serializable;

/**
 * <p>Title: TerminalrewardstdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public interface TerminalrewardstdControl extends AbstractControl {
    public TerminalrewardstdVO doCreate(TerminalrewardstdVO vo, User user)
        throws Exception;

    public void doRemove(TerminalrewardstdVO vo, User user)
        throws Exception;

    public TerminalrewardstdVO doUpdate(TerminalrewardstdVO vo, User user)
        throws Exception;

    public TerminalrewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(TerminalrewardstdListVO params, User user)
        throws Exception;

}
