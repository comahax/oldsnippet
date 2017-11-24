/**
* auto-generated code
* Wed Sep 10 14:41:39 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.ruleitemlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitemlog.control.RuleitemlogControl;
import com.sunrise.boss.business.cms.reward.ruleitemlog.control.RuleitemlogControlBean;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogVO;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleitemlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemlogDelegate {

    private static RuleitemlogControl control;

    public RuleitemlogDelegate() throws Exception {
        control = (RuleitemlogControl) ControlFactory.build(RuleitemlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RuleitemlogVO doCreate(RuleitemlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RuleitemlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RuleitemlogVO doUpdate(RuleitemlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RuleitemlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RuleitemlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RuleitemlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
