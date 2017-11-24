/**
* auto-generated code
* Tue Jul 14 09:24:12 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.rulemode;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeVO;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeListVO;
import com.sunrise.boss.business.cms.reward.rulemode.control.RulemodeControlBean;
import com.sunrise.boss.business.cms.reward.rulemode.control.RulemodeControl;

import java.io.Serializable;

/**
 * <p>Title: RulemodeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RulemodeDelegate {

    private static RulemodeControl control;

    public RulemodeDelegate() throws Exception {
        control = (RulemodeControl) ControlFactory.build(RulemodeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RulemodeVO doCreate(RulemodeVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RulemodeVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RulemodeVO doUpdate(RulemodeVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RulemodeVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RulemodeVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RulemodeListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
