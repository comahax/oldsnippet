/**
* auto-generated code
* Wed Oct 18 14:53:09 CST 2006
*/
package com.sunrise.boss.business.cms.agentbchlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.agentbchlog.persistent.AgentbchlogVO;
import com.sunrise.boss.business.cms.agentbchlog.persistent.AgentbchlogListVO;

import java.io.Serializable;

/**
 * <p>Title: AgentbchlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface AgentbchlogControl extends AbstractControl {
    public AgentbchlogVO doCreate(AgentbchlogVO vo, User user)
        throws Exception;

    public void doRemove(AgentbchlogVO vo, User user)
        throws Exception;

    public AgentbchlogVO doUpdate(AgentbchlogVO vo, User user)
        throws Exception;

    public AgentbchlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AgentbchlogListVO params, User user)
        throws Exception;

}
