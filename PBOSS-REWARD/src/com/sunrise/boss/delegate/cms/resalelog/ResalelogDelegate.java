/**
* auto-generated code
* Fri Jan 04 16:05:28 CST 2008
*/
package com.sunrise.boss.delegate.cms.resalelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resalelog.control.ResalelogControl;
import com.sunrise.boss.business.cms.resalelog.control.ResalelogControlBean;
import com.sunrise.boss.business.cms.resalelog.persistent.ResalelogVO;
import com.sunrise.boss.business.cms.resalelog.persistent.ResalelogListVO;

import java.io.Serializable;

/**
 * <p>Title: ResalelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResalelogDelegate {

    private static ResalelogControl control;

    public ResalelogDelegate() throws Exception { 
        control = (ResalelogControl) ControlFactory.build(ResalelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ResalelogVO doCreate(ResalelogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ResalelogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public ResalelogVO doUpdate(ResalelogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ResalelogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (ResalelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ResalelogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
