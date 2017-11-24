/**
* auto-generated code
* Wed Sep 10 11:29:44 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.ruleitem;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitem.control.RuleitemControl;
import com.sunrise.boss.business.cms.reward.ruleitem.control.RuleitemControlBean;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleitemDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemDelegate {

    private static RuleitemControl control;

    public RuleitemDelegate() throws Exception {
        control = (RuleitemControl) ControlFactory.build(RuleitemControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RuleitemVO doCreate(RuleitemVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RuleitemVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RuleitemVO doUpdate(RuleitemVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RuleitemVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RuleitemVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RuleitemListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
