/**
* auto-generated code
* Wed Dec 07 09:27:39 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.blacklist;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistVO;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistListVO;
import com.sunrise.boss.business.cms.bbc.blacklist.control.BlacklistControlBean;
import com.sunrise.boss.business.cms.bbc.blacklist.control.BlacklistControl;

import java.io.Serializable;

/**
 * <p>Title: BlacklistDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class BlacklistDelegate {

    private static BlacklistControl control;

    public BlacklistDelegate() throws Exception {
        control = (BlacklistControl) ControlFactory.build(BlacklistControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BlacklistVO doCreate(BlacklistVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BlacklistVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BlacklistVO doUpdate(BlacklistVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BlacklistVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BlacklistVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BlacklistListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
