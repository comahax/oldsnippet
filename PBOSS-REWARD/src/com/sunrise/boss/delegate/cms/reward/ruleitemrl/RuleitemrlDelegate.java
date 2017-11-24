/**
* auto-generated code
* Thu Sep 11 19:35:20 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.ruleitemrl;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitemrl.control.RuleitemrlControl;
import com.sunrise.boss.business.cms.reward.ruleitemrl.control.RuleitemrlControlBean;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlVO;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleitemrlDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemrlDelegate {

    private static RuleitemrlControl control;

    public RuleitemrlDelegate() throws Exception {
        control = (RuleitemrlControl) ControlFactory.build(RuleitemrlControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RuleitemrlVO doCreate(RuleitemrlVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RuleitemrlVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RuleitemrlVO doUpdate(RuleitemrlVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RuleitemrlVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RuleitemrlVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RuleitemrlListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQueryRuleItemRl(String ruleid,String ruleitemid,String rltype,User user)
		throws Exception{
    	return control.doQueryRuleItemRl(ruleid,ruleitemid,rltype, user);
    }
    public DataPackage doQueryRuleItemRlTypeChain(String ruleid,String ruleitemid,short rltype,User user)
		throws Exception{
    	return control.doQueryRuleItemRlTypeChain(ruleid,ruleitemid,rltype, user);
    }
    public DataPackage doQueryRuleItemRlIsleaderChain(String ruleid,String ruleitemid,short rltype,short isleader,User user)
		throws Exception{
    	return control.doQueryRuleItemRlIsleaderChain(ruleid,ruleitemid,rltype,isleader, user);
    }
    public DataPackage doQueryRuleItemRlMutex(String ruleid,String ruleitemid,short rltype,User user)
		throws Exception{
    	return control.doQueryRuleItemRlMutex(ruleid,ruleitemid,rltype, user);
    }
}
