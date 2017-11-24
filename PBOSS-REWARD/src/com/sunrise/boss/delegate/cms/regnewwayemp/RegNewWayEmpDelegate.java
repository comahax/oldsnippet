/**
* auto-generated code
* Mon Feb 21 20:51:42 CST 2011
*/
package com.sunrise.boss.delegate.cms.regnewwayemp;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpVO;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpListVO;
import com.sunrise.boss.business.cms.regnewwayemp.control.RegNewWayEmpControlBean;
import com.sunrise.boss.business.cms.regnewwayemp.control.RegNewWayEmpControl;

import java.io.Serializable;

/**
 * <p>Title: RegNewWayEmpDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegNewWayEmpDelegate {

    private static RegNewWayEmpControl control;

    public RegNewWayEmpDelegate() throws Exception {
        control = (RegNewWayEmpControl) ControlFactory.build(RegNewWayEmpControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RegNewWayEmpVO doCreate(RegNewWayEmpVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RegNewWayEmpVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RegNewWayEmpVO doUpdate(RegNewWayEmpVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RegNewWayEmpVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RegNewWayEmpVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RegNewWayEmpListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
