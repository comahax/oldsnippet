/**
* auto-generated code
* Tue Feb 05 10:15:16 CST 2008
*/
package com.sunrise.boss.delegate.cms.bcityloadlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bcityloadlog.control.BcityloadlogControl;
import com.sunrise.boss.business.cms.bcityloadlog.control.BcityloadlogControlBean;
import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogVO;
import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BcityloadlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BcityloadlogDelegate {

    private static BcityloadlogControl control;

    public BcityloadlogDelegate() throws Exception {
        control = (BcityloadlogControl) ControlFactory.build(BcityloadlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BcityloadlogVO doCreate(BcityloadlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BcityloadlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BcityloadlogVO doUpdate(BcityloadlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BcityloadlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BcityloadlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BcityloadlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
