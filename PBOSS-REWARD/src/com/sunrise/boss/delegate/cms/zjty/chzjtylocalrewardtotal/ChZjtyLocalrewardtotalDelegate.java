/**
* auto-generated code
* Sat Mar 09 12:11:47 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtylocalrewardtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.control.ChZjtyLocalrewardtotalControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.control.ChZjtyLocalrewardtotalControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalrewardtotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalrewardtotalDelegate {

    private static ChZjtyLocalrewardtotalControl control;

    public ChZjtyLocalrewardtotalDelegate() throws Exception {
        control = (ChZjtyLocalrewardtotalControl) ControlFactory.build(ChZjtyLocalrewardtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyLocalrewardtotalVO doCreate(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyLocalrewardtotalVO doUpdate(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyLocalrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyLocalrewardtotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyLocalrewardtotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryTotal(ChZjtyLocalrewardtotalListVO params, User user)
        throws Exception {
        return control.doQueryTotal(params, user);
    }

}
