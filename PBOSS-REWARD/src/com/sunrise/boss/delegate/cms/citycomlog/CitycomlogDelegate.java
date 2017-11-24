/**
* auto-generated code
* Tue Oct 17 17:37:23 CST 2006
*/
package com.sunrise.boss.delegate.cms.citycomlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.citycomlog.control.CitycomlogControl;
import com.sunrise.boss.business.cms.citycomlog.control.CitycomlogControlBean;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogVO;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CitycomlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class CitycomlogDelegate {

    private static CitycomlogControl control;

    public CitycomlogDelegate() throws Exception {
        control = (CitycomlogControl) ControlFactory.build(CitycomlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CitycomlogVO doCreate(CitycomlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CitycomlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CitycomlogVO doUpdate(CitycomlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CitycomlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CitycomlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CitycomlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
