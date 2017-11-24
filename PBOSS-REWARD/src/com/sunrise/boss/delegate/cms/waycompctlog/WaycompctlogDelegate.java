/**
* auto-generated code
* Wed Oct 18 14:54:55 CST 2006
*/
package com.sunrise.boss.delegate.cms.waycompctlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waycompctlog.control.WaycompctlogControl;
import com.sunrise.boss.business.cms.waycompctlog.control.WaycompctlogControlBean;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogVO;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogListVO;

import java.io.Serializable;

/**
 * <p>Title: WaycompctlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaycompctlogDelegate {

    private static WaycompctlogControl control;

    public WaycompctlogDelegate() throws Exception {
        control = (WaycompctlogControl) ControlFactory.build(WaycompctlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaycompctlogVO doCreate(WaycompctlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WaycompctlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WaycompctlogVO doUpdate(WaycompctlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaycompctlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WaycompctlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WaycompctlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
