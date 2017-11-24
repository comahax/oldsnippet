/**
* auto-generated code
* Fri Jul 17 11:20:44 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.ruleexp;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpVO;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpListVO;
import com.sunrise.boss.business.cms.reward.ruleexp.control.RuleexpControlBean;
import com.sunrise.boss.business.cms.reward.ruleexp.control.RuleexpControl;

import java.io.Serializable;

/**
 * <p>Title: RuleexpDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RuleexpDelegate {

    private static RuleexpControl control;

    public RuleexpDelegate() throws Exception {
        control = (RuleexpControl) ControlFactory.build(RuleexpControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RuleexpVO doCreate(RuleexpVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RuleexpVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RuleexpVO doUpdate(RuleexpVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RuleexpVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RuleexpVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RuleexpListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
