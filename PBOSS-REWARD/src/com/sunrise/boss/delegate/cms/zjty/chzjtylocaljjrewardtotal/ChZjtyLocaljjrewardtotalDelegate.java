/**
* auto-generated code
* Sat Mar 09 12:07:52 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtylocaljjrewardtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.control.ChZjtyLocaljjrewardtotalControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.control.ChZjtyLocaljjrewardtotalControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocaljjrewardtotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocaljjrewardtotalDelegate {

    private static ChZjtyLocaljjrewardtotalControl control;

    public ChZjtyLocaljjrewardtotalDelegate() throws Exception {
        control = (ChZjtyLocaljjrewardtotalControl) ControlFactory.build(ChZjtyLocaljjrewardtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyLocaljjrewardtotalVO doCreate(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyLocaljjrewardtotalVO doUpdate(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyLocaljjrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyLocaljjrewardtotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyLocaljjrewardtotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQueryTotal(ChZjtyLocaljjrewardtotalListVO params, User user)
        throws Exception {
        return control.doQueryTotal(params, user);
    }
}
