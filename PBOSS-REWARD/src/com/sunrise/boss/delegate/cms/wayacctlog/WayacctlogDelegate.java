/**
* auto-generated code
* Wed Oct 18 14:55:37 CST 2006
*/
package com.sunrise.boss.delegate.cms.wayacctlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayacctlog.control.WayacctlogControl;
import com.sunrise.boss.business.cms.wayacctlog.control.WayacctlogControlBean;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogVO;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogListVO;

import java.io.Serializable;

/**
 * <p>Title: WayacctlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayacctlogDelegate {

    private static WayacctlogControl control;

    public WayacctlogDelegate() throws Exception {
        control = (WayacctlogControl) ControlFactory.build(WayacctlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WayacctlogVO doCreate(WayacctlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WayacctlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WayacctlogVO doUpdate(WayacctlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WayacctlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WayacctlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WayacctlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
