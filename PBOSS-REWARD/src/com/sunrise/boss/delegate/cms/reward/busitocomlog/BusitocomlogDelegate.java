/**
* auto-generated code
* Fri Aug 28 11:21:30 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.busitocomlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogVO;
import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogListVO;
import com.sunrise.boss.business.cms.reward.busitocomlog.control.BusitocomlogControlBean;
import com.sunrise.boss.business.cms.reward.busitocomlog.control.BusitocomlogControl;

import java.io.Serializable;

/**
 * <p>Title: BusitocomlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BusitocomlogDelegate {

    private static BusitocomlogControl control;

    public BusitocomlogDelegate() throws Exception {
        control = (BusitocomlogControl) ControlFactory.build(BusitocomlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BusitocomlogVO doCreate(BusitocomlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BusitocomlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BusitocomlogVO doUpdate(BusitocomlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BusitocomlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BusitocomlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BusitocomlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
