/**
* auto-generated code
* Fri Jul 17 11:20:44 CST 2009
*/
package com.sunrise.boss.business.cms.reward.ruleexp.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpVO;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleexpControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface RuleexpControl extends AbstractControl {
    public RuleexpVO doCreate(RuleexpVO vo, User user)
        throws Exception;

    public void doRemove(RuleexpVO vo, User user)
        throws Exception;

    public RuleexpVO doUpdate(RuleexpVO vo, User user)
        throws Exception;

    public RuleexpVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RuleexpListVO params, User user)
        throws Exception;

}
