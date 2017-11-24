/**
* auto-generated code
* Wed Feb 06 14:54:24 CST 2013
*/
package com.sunrise.boss.delegate.fee.chadtrulerel;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelVO;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelListVO;
import com.sunrise.boss.business.fee.chadtrulerel.control.ChAdtRulerelControlBean;
import com.sunrise.boss.business.fee.chadtrulerel.control.ChAdtRulerelControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtRulerelDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public class ChAdtRulerelDelegate {

    private static ChAdtRulerelControl control;

    public ChAdtRulerelDelegate() throws Exception {
        control = (ChAdtRulerelControl) ControlFactory.build(ChAdtRulerelControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtRulerelVO doCreate(ChAdtRulerelVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtRulerelVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtRulerelVO doUpdate(ChAdtRulerelVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtRulerelVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtRulerelVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtRulerelListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
