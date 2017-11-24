/**
* auto-generated code
* Fri Feb 13 16:59:53 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtyoprtcost;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostVO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostListVO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.control.ChZjtyOprtcostControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.control.ChZjtyOprtcostControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyOprtcostDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOprtcostDelegate {

    private static ChZjtyOprtcostControl control;

    public ChZjtyOprtcostDelegate() throws Exception {
        control = (ChZjtyOprtcostControl) ControlFactory.build(ChZjtyOprtcostControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ChZjtyOprtcostVO doCreate(ChZjtyOprtcostVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ChZjtyOprtcostVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ChZjtyOprtcostVO doUpdate(ChZjtyOprtcostVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ChZjtyOprtcostVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyOprtcostVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ChZjtyOprtcostListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
