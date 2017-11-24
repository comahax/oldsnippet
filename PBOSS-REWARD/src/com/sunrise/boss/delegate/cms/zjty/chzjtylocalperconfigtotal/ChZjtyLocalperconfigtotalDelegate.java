/**
* auto-generated code
* Sat Mar 09 12:10:11 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtylocalperconfigtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.control.ChZjtyLocalperconfigtotalControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.control.ChZjtyLocalperconfigtotalControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalperconfigtotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalperconfigtotalDelegate {

    private static ChZjtyLocalperconfigtotalControl control;

    public ChZjtyLocalperconfigtotalDelegate() throws Exception {
        control = (ChZjtyLocalperconfigtotalControl) ControlFactory.build(ChZjtyLocalperconfigtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyLocalperconfigtotalVO doCreate(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyLocalperconfigtotalVO doUpdate(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyLocalperconfigtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyLocalperconfigtotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyLocalperconfigtotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQueryTotal(ChZjtyLocalperconfigtotalListVO params, User user)
        throws Exception {
        return control.doQueryTotal(params, user);
    }
}
