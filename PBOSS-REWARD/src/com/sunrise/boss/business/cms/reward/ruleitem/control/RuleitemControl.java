/**
* auto-generated code
* Wed Sep 10 11:29:44 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitem.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleitemControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RuleitemControl extends AbstractControl {
    public RuleitemVO doCreate(RuleitemVO vo, User user)
        throws Exception;

    public void doRemove(RuleitemVO vo, User user)
        throws Exception;

    public RuleitemVO doUpdate(RuleitemVO vo, User user)
        throws Exception;

    public RuleitemVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RuleitemListVO params, User user)
        throws Exception;

}
