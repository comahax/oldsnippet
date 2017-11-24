/**
* auto-generated code
* Wed Sep 10 14:41:39 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitemlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogVO;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleitemlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RuleitemlogControl extends AbstractControl {
    public RuleitemlogVO doCreate(RuleitemlogVO vo, User user)
        throws Exception;

    public void doRemove(RuleitemlogVO vo, User user)
        throws Exception;

    public RuleitemlogVO doUpdate(RuleitemlogVO vo, User user)
        throws Exception;

    public RuleitemlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RuleitemlogListVO params, User user)
        throws Exception;

}
