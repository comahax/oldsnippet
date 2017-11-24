/**
* auto-generated code
* Wed Feb 24 11:50:56 CST 2010
*/
package com.sunrise.boss.delegate.cms.waystarcsale;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleVO;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleListVO;
import com.sunrise.boss.business.cms.waystarcsale.control.WaystarcsaleControlBean;
import com.sunrise.boss.business.cms.waystarcsale.control.WaystarcsaleControl;

import java.io.Serializable;

/**
 * <p>Title: WaystarcsaleDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class WaystarcsaleDelegate {

    private static WaystarcsaleControl control;

    public WaystarcsaleDelegate() throws Exception {
        control = (WaystarcsaleControl) ControlFactory.build(WaystarcsaleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public WaystarcsaleVO doCreate(WaystarcsaleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(WaystarcsaleVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public WaystarcsaleVO doUpdate(WaystarcsaleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public WaystarcsaleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WaystarcsaleVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(WaystarcsaleListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
