/**
* auto-generated code
* Tue Oct 17 17:31:29 CST 2006
*/
package com.sunrise.boss.delegate.cms.waytypelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waytypelog.control.WaytypelogControl;
import com.sunrise.boss.business.cms.waytypelog.control.WaytypelogControlBean;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogVO;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogListVO;

import java.io.Serializable;

/**
 * <p>Title: WaytypelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaytypelogDelegate {

    private static WaytypelogControl control;

    public WaytypelogDelegate() throws Exception {
        control = (WaytypelogControl) ControlFactory.build(WaytypelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaytypelogVO doCreate(WaytypelogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WaytypelogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WaytypelogVO doUpdate(WaytypelogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaytypelogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WaytypelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WaytypelogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
