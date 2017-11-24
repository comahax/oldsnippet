/**
* auto-generated code
* Sun Feb 03 10:15:39 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.rule;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule.control.RuleControl;
import com.sunrise.boss.business.cms.reward.rule.control.RuleControlBean;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleVO;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleDelegate {

    private static RuleControl control;

    public RuleDelegate() throws Exception {
        control = (RuleControl) ControlFactory.build(RuleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RuleVO doCreate(RuleVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RuleVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RuleVO doUpdate(RuleVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RuleVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RuleVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RuleListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
