/**
* auto-generated code
* Sun Feb 03 10:15:39 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rule.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleVO;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RuleControl extends AbstractControl {
    public RuleVO doCreate(RuleVO vo, User user)
        throws Exception;

    public void doRemove(RuleVO vo, User user)
        throws Exception;

    public RuleVO doUpdate(RuleVO vo, User user)
        throws Exception;

    public RuleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RuleListVO params, User user)
        throws Exception;

}
