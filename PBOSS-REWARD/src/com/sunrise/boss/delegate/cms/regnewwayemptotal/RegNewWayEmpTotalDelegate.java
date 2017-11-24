/**
* auto-generated code
* Thu Feb 24 15:31:21 CST 2011
*/
package com.sunrise.boss.delegate.cms.regnewwayemptotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalVO;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalListVO;
import com.sunrise.boss.business.cms.regnewwayemptotal.control.RegNewWayEmpTotalControlBean;
import com.sunrise.boss.business.cms.regnewwayemptotal.control.RegNewWayEmpTotalControl;

import java.io.Serializable;

/**
 * <p>Title: RegNewWayEmpTotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegNewWayEmpTotalDelegate {

    private static RegNewWayEmpTotalControl control;

    public RegNewWayEmpTotalDelegate() throws Exception {
        control = (RegNewWayEmpTotalControl) ControlFactory.build(RegNewWayEmpTotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RegNewWayEmpTotalVO doCreate(RegNewWayEmpTotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RegNewWayEmpTotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RegNewWayEmpTotalVO doUpdate(RegNewWayEmpTotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RegNewWayEmpTotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RegNewWayEmpTotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RegNewWayEmpTotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
