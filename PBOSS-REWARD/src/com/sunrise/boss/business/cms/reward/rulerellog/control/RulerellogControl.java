/**
* auto-generated code
* Wed Sep 10 14:39:49 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulerellog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogListVO;

import java.io.Serializable;

/**
 * <p>Title: RulerellogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RulerellogControl extends AbstractControl {
    public RulerellogVO doCreate(RulerellogVO vo, User user)
        throws Exception;

    public void doRemove(RulerellogVO vo, User user)
        throws Exception;

    public RulerellogVO doUpdate(RulerellogVO vo, User user)
        throws Exception;

    public RulerellogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RulerellogListVO params, User user)
        throws Exception;

}
