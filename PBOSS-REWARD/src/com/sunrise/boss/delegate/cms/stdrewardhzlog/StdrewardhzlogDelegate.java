/**
* auto-generated code
* Sun Feb 01 11:20:05 CST 2009
*/
package com.sunrise.boss.delegate.cms.stdrewardhzlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogVO;
import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogListVO;
import com.sunrise.boss.business.cms.stdrewardhzlog.control.StdrewardhzlogControlBean;
import com.sunrise.boss.business.cms.stdrewardhzlog.control.StdrewardhzlogControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardhzlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class StdrewardhzlogDelegate {

    private static StdrewardhzlogControl control;

    public StdrewardhzlogDelegate() throws Exception {
        control = (StdrewardhzlogControl) ControlFactory.build(StdrewardhzlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public StdrewardhzlogVO doCreate(StdrewardhzlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(StdrewardhzlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public StdrewardhzlogVO doUpdate(StdrewardhzlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public StdrewardhzlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardhzlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(StdrewardhzlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
