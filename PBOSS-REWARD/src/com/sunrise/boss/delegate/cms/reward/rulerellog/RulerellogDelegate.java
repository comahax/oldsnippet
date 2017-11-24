/**
* auto-generated code
* Wed Sep 10 14:39:49 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.rulerellog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulerellog.control.RulerellogControl;
import com.sunrise.boss.business.cms.reward.rulerellog.control.RulerellogControlBean;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogListVO;

import java.io.Serializable;

/**
 * <p>Title: RulerellogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerellogDelegate {

    private static RulerellogControl control;

    public RulerellogDelegate() throws Exception {
        control = (RulerellogControl) ControlFactory.build(RulerellogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RulerellogVO doCreate(RulerellogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RulerellogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RulerellogVO doUpdate(RulerellogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RulerellogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RulerellogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RulerellogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
