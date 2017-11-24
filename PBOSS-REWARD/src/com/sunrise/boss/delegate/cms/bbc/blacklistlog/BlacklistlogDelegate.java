/**
* auto-generated code
* Wed Dec 07 09:31:25 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.blacklistlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogVO;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogListVO;
import com.sunrise.boss.business.cms.bbc.blacklistlog.control.BlacklistlogControlBean;
import com.sunrise.boss.business.cms.bbc.blacklistlog.control.BlacklistlogControl;

import java.io.Serializable;

/**
 * <p>Title: BlacklistlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class BlacklistlogDelegate {

    private static BlacklistlogControl control;

    public BlacklistlogDelegate() throws Exception {
        control = (BlacklistlogControl) ControlFactory.build(BlacklistlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BlacklistlogVO doCreate(BlacklistlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BlacklistlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BlacklistlogVO doUpdate(BlacklistlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BlacklistlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BlacklistlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BlacklistlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
