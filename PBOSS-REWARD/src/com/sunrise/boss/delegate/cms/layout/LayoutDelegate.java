/**
* auto-generated code
* Tue Dec 18 19:10:45 CST 2007
*/
package com.sunrise.boss.delegate.cms.layout;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.layout.control.LayoutControl;
import com.sunrise.boss.business.cms.layout.control.LayoutControlBean;
import com.sunrise.boss.business.cms.layout.persistent.LayoutVO;
import com.sunrise.boss.business.cms.layout.persistent.LayoutListVO;

import java.io.Serializable;

/**
 * <p>Title: LayoutDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class LayoutDelegate {

    private static LayoutControl control;

    public LayoutDelegate() throws Exception {
        control = (LayoutControl) ControlFactory.build(LayoutControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public LayoutVO doCreate(LayoutVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(LayoutVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public LayoutVO doUpdate(LayoutVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public LayoutVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (LayoutVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(LayoutListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
