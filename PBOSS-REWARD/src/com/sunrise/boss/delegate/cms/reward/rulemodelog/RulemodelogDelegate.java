/**
* auto-generated code
* Tue Jul 14 09:27:14 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.rulemodelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulemodelog.persistent.RulemodelogVO;
import com.sunrise.boss.business.cms.reward.rulemodelog.control.RulemodelogControlBean;
import com.sunrise.boss.business.cms.reward.rulemodelog.control.RulemodelogControl;

import java.io.Serializable;

/**
 * <p>Title: RulemodelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RulemodelogDelegate {

    private static RulemodelogControl control;

    public RulemodelogDelegate() throws Exception {
        control = (RulemodelogControl) ControlFactory.build(RulemodelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RulemodelogVO doCreate(RulemodelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RulemodelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RulemodelogVO doUpdate(RulemodelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RulemodelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RulemodelogVO) control.doFindByPk(pk, user);
    }

}
