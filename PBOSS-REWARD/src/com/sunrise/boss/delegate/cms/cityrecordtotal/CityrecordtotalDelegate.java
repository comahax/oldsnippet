/**
* auto-generated code
* Tue Mar 13 17:29:11 CST 2012
*/
package com.sunrise.boss.delegate.cms.cityrecordtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalVO;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalListVO;
import com.sunrise.boss.business.cms.cityrecordtotal.control.CityrecordtotalControlBean;
import com.sunrise.boss.business.cms.cityrecordtotal.control.CityrecordtotalControl;

import java.io.Serializable;

/**
 * <p>Title: CityrecordtotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class CityrecordtotalDelegate {

    private static CityrecordtotalControl control;

    public CityrecordtotalDelegate() throws Exception {
        control = (CityrecordtotalControl) ControlFactory.build(CityrecordtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public CityrecordtotalVO doCreate(CityrecordtotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(CityrecordtotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public CityrecordtotalVO doUpdate(CityrecordtotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public CityrecordtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CityrecordtotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(CityrecordtotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
