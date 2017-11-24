/**
* auto-generated code
* Wed Sep 10 11:22:49 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.rulerel;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.rulerel.control.RulerelControl;
import com.sunrise.boss.business.cms.reward.rulerel.control.RulerelControlBean;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: RulerelDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerelDelegate {

    private static RulerelControl control;

    public RulerelDelegate() throws Exception {
        control = (RulerelControl) ControlFactory.build(RulerelControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RulerelVO doCreate(RulerelVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RulerelVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    /**
     * @deprecated ·ÏÆú
     * @param vo
     * @param user
     * @return
     * @throws Exception
     */
    public RulerelVO doUpdate(RulerelVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RulerelVO doUpdate2(RulerelVO vo, User user )
	    throws Exception {
	    return control.doUpdate2(vo, user);
	}
    public RulerelVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RulerelVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RulerelListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQuery2(RulerelListVO params1, RuleitemListVO params2,User user)
    throws Exception {
    return control.doQuery2(params1,params2, user);
    }
    
    public List doCheckRulerelOrder(String ruleid, User user) throws Exception {
    	return control.doCheckRulerelOrder(ruleid , user);
    }
    
    public DataPackage doQuery4(RulerelListVO params1, User user)
    throws Exception {
    return control.doQuery4(params1, user);
    }
    
    public DataPackage doQuery5(RulerelListVO params1, User user)
    throws Exception {
    return control.doQuery5(params1, user);
    }
    
    public DataPackage doQueryByRuleid(RulerelListVO params1, User user)
    throws Exception {
    return control.doQueryByRuleid(params1, user);
    }
    
    public DataPackage doSave(List params1,String ruleid, User user)
    throws Exception {
    return control.doSave(params1,ruleid, user);
    }
    
}