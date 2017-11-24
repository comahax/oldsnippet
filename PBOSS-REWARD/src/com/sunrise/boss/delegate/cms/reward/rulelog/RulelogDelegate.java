/**
* auto-generated code
* Sun Feb 03 10:16:15 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.rulelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulelog.control.RulelogControl;
import com.sunrise.boss.business.cms.reward.rulelog.control.RulelogControlBean;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogListVO;

import java.io.Serializable;

/**
 * <p>Title: RulelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulelogDelegate {

    private static RulelogControl control;

    public RulelogDelegate() throws Exception {
        control = (RulelogControl) ControlFactory.build(RulelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RulelogVO doCreate(RulelogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RulelogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RulelogVO doUpdate(RulelogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RulelogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RulelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RulelogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
