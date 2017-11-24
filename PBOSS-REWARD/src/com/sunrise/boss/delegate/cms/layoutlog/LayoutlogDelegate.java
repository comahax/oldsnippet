/**
* auto-generated code
* Fri Dec 21 09:56:55 CST 2007
*/
package com.sunrise.boss.delegate.cms.layoutlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.layoutlog.control.LayoutlogControl;
import com.sunrise.boss.business.cms.layoutlog.control.LayoutlogControlBean;
import com.sunrise.boss.business.cms.layoutlog.persistent.LayoutlogVO;
import com.sunrise.boss.business.cms.layoutlog.persistent.LayoutlogListVO;

import java.io.Serializable;

/**
 * <p>Title: LayoutlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LayoutlogDelegate {

    private static LayoutlogControl control;

    public LayoutlogDelegate() throws Exception {
        control = (LayoutlogControl) ControlFactory.build(LayoutlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public LayoutlogVO doCreate(LayoutlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(LayoutlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public LayoutlogVO doUpdate(LayoutlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public LayoutlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (LayoutlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(LayoutlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
