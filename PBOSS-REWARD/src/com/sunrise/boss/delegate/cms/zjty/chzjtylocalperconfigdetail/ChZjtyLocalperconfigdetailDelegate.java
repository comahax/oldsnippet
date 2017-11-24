/**
* auto-generated code
* Sat Mar 09 12:08:48 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtylocalperconfigdetail;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.control.ChZjtyLocalperconfigdetailControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.control.ChZjtyLocalperconfigdetailControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalperconfigdetailDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalperconfigdetailDelegate {

    private static ChZjtyLocalperconfigdetailControl control;

    public ChZjtyLocalperconfigdetailDelegate() throws Exception {
        control = (ChZjtyLocalperconfigdetailControl) ControlFactory.build(ChZjtyLocalperconfigdetailControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyLocalperconfigdetailVO doCreate(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyLocalperconfigdetailVO doUpdate(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyLocalperconfigdetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyLocalperconfigdetailVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyLocalperconfigdetailListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
