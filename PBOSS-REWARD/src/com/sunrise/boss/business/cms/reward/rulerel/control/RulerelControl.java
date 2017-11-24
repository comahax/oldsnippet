/**
* auto-generated code
* Wed Sep 10 11:22:49 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulerel.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: RulerelControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RulerelControl extends AbstractControl {
    public RulerelVO doCreate(RulerelVO vo, User user)
        throws Exception;

    public void doRemove(RulerelVO vo, User user)
        throws Exception;

    /**
     * @deprecated 该方法已经废弃
     * @param vo
     * @param user
     * @return
     * @throws Exception
     */
    public RulerelVO doUpdate(RulerelVO vo, User user)
        throws Exception;

    public RulerelVO doUpdate2(RulerelVO vo, User user)
    throws Exception;
    
    public RulerelVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RulerelListVO params, User user)
        throws Exception;
    public DataPackage doQuery2(RulerelListVO params1, RuleitemListVO params2,User user)
    	throws Exception ;
    
    public DataPackage doQuery4(RulerelListVO params1,User user)
	throws Exception ;
    
    public DataPackage doQuery5(RulerelListVO params1,User user)
	throws Exception ;
    
    public List doCheckRulerelOrder(String ruleid, User user) throws Exception;
    
    public DataPackage doQueryByRuleid(RulerelListVO params1,User user)
	throws Exception ;
    
    public DataPackage doSave(List params1,String ruleid, User user)
    throws Exception;
}
