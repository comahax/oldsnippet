/**
* auto-generated code
* Mon Sep 02 12:21:21 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdagent.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentListVO;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdAgentControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface ChPdAgentControl extends AbstractControl {
    public ChPdAgentVO doCreate(ChPdAgentVO vo, User user)
        throws Exception;

    public void doRemove(ChPdAgentVO vo, User user)
        throws Exception;

    public ChPdAgentVO doUpdate(ChPdAgentVO vo, User user)
        throws Exception;

    public ChPdAgentVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdAgentListVO params, User user)
        throws Exception;

}
