/**
* auto-generated code
* Sat May 11 16:40:18 CST 2013
*/
package com.sunrise.boss.delegate.cms.chzdplatforminfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoVO;
import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoListVO;
import com.sunrise.boss.business.cms.chzdplatforminfo.control.ChZdPlatforminfoControlBean;
import com.sunrise.boss.business.cms.chzdplatforminfo.control.ChZdPlatforminfoControl;

import java.io.Serializable;

/**
 * <p>Title: ChZdPlatforminfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdPlatforminfoDelegate {

    private static ChZdPlatforminfoControl control;

    public ChZdPlatforminfoDelegate() throws Exception {
        control = (ChZdPlatforminfoControl) ControlFactory.build(ChZdPlatforminfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZdPlatforminfoVO doCreate(ChZdPlatforminfoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZdPlatforminfoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZdPlatforminfoVO doUpdate(ChZdPlatforminfoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZdPlatforminfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZdPlatforminfoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZdPlatforminfoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryForZdplatform(ChZdPlatforminfoListVO params, User user)
	    throws Exception {
	    return control.doQueryForZdplatform(params, user);
    }
    
    public DataPackage doQueryForProducttype(ChZdPlatforminfoListVO params, User user)
	    throws Exception {
	    return control.doQueryForProducttype(params, user);
    }

}
