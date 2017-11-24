/**
* auto-generated code
* Mon Jan 04 11:40:46 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.busitosmp;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpVO;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpListVO;
import com.sunrise.boss.business.cms.reward.busitosmp.control.BusitosmpControlBean;
import com.sunrise.boss.business.cms.reward.busitosmp.control.BusitosmpControl;

import java.io.Serializable;

/**
 * <p>Title: BusitosmpDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class BusitosmpDelegate {

    private static BusitosmpControl control;

    public BusitosmpDelegate() throws Exception {
        control = (BusitosmpControl) ControlFactory.build(BusitosmpControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BusitosmpVO doCreate(BusitosmpVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BusitosmpVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BusitosmpVO doUpdate(BusitosmpVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BusitosmpVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BusitosmpVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BusitosmpListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
