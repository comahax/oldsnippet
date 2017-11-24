/**
* auto-generated code
* Sat Aug 26 11:33:48 CST 2006
*/
package com.sunrise.boss.delegate.cms.wayagentbch;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayagentbch.control.WayagentbchControl;
import com.sunrise.boss.business.cms.wayagentbch.control.WayagentbchControlBean;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchVO;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchListVO;

import java.io.Serializable;

/**
 * <p>Title: WayagentbchDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayagentbchDelegate {

    private static WayagentbchControl control;

    public WayagentbchDelegate() throws Exception {
        control = (WayagentbchControl) ControlFactory.build(WayagentbchControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WayagentbchVO doCreate(WayagentbchVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WayagentbchVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WayagentbchVO doUpdate(WayagentbchVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WayagentbchVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WayagentbchVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WayagentbchListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
