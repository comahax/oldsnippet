/**
* auto-generated code
* Thu Sep 11 19:35:20 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitemrl.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlVO;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleitemrlControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RuleitemrlControl extends AbstractControl {
    public RuleitemrlVO doCreate(RuleitemrlVO vo, User user)
        throws Exception;

    public void doRemove(RuleitemrlVO vo, User user)
        throws Exception;

    public RuleitemrlVO doUpdate(RuleitemrlVO vo, User user)
        throws Exception;

    public RuleitemrlVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RuleitemrlListVO params, User user)
        throws Exception;
    public DataPackage doQueryRuleItemRl(String ruleid,String ruleitemid,String rltype,User user)
		throws Exception;
    public DataPackage doQueryRuleItemRlTypeChain(String ruleid,String ruleitemid,short rltype,User user)
		throws Exception;
	public DataPackage doQueryRuleItemRlIsleaderChain(String ruleid,String ruleitemid,short rltype,short isleader,User user)
		throws Exception;
	public DataPackage doQueryRuleItemRlMutex(String ruleid,String ruleitemid,short rltype,User user)
		throws Exception;
}
