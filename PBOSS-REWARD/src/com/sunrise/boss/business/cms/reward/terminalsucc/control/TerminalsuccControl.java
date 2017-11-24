/**
* auto-generated code
* Fri Apr 09 12:40:50 CST 2010
*/
package com.sunrise.boss.business.cms.reward.terminalsucc.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccVO;
import com.sunrise.boss.business.cms.reward.terminalsucc.persistent.TerminalsuccListVO;

import java.io.Serializable;

/**
 * <p>Title: TerminalsuccControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface TerminalsuccControl extends AbstractControl {
    public TerminalsuccVO doCreate(TerminalsuccVO vo, User user)
        throws Exception;

    public void doRemove(TerminalsuccVO vo, User user)
        throws Exception;

    public TerminalsuccVO doUpdate(TerminalsuccVO vo, User user)
        throws Exception;

    public TerminalsuccVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(TerminalsuccListVO params, User user)
        throws Exception;

}
