/**
* auto-generated code
* Sat Mar 09 12:02:30 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtylocalgdrewardtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.control.ChZjtyLocalgdrewardtotalControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.control.ChZjtyLocalgdrewardtotalControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalgdrewardtotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalgdrewardtotalDelegate {

    private static ChZjtyLocalgdrewardtotalControl control;

    public ChZjtyLocalgdrewardtotalDelegate() throws Exception {
        control = (ChZjtyLocalgdrewardtotalControl) ControlFactory.build(ChZjtyLocalgdrewardtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyLocalgdrewardtotalVO doCreate(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyLocalgdrewardtotalVO doUpdate(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyLocalgdrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyLocalgdrewardtotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyLocalgdrewardtotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQueryTotal(ChZjtyLocalgdrewardtotalListVO params, User user)
        throws Exception {
        return control.doQueryTotal(params, user);
    }
}
