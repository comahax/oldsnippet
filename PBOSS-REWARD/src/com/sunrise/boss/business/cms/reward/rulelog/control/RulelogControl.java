/**
* auto-generated code
* Sun Feb 03 10:16:15 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogListVO;

import java.io.Serializable;

/**
 * <p>Title: RulelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RulelogControl extends AbstractControl {
    public RulelogVO doCreate(RulelogVO vo, User user)
        throws Exception;

    public void doRemove(RulelogVO vo, User user)
        throws Exception;

    public RulelogVO doUpdate(RulelogVO vo, User user)
        throws Exception;

    public RulelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RulelogListVO params, User user)
        throws Exception;

}
