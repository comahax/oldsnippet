/**
* auto-generated code
* Wed Nov 25 11:14:06 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnitemlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogVO;
import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogListVO;
import com.sunrise.boss.business.cms.examine.exmnitemlog.control.ExmnitemlogControlBean;
import com.sunrise.boss.business.cms.examine.exmnitemlog.control.ExmnitemlogControl;

import java.io.Serializable;

/**
 * <p>Title: ExmnitemlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemlogDelegate {

    private static ExmnitemlogControl control;

    public ExmnitemlogDelegate() throws Exception {
        control = (ExmnitemlogControl) ControlFactory.build(ExmnitemlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnitemlogVO doCreate(ExmnitemlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnitemlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnitemlogVO doUpdate(ExmnitemlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnitemlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnitemlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnitemlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
