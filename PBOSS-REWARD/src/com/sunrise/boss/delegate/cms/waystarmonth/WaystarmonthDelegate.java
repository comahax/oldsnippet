/**
* auto-generated code
* Wed Feb 24 14:10:39 CST 2010
*/
package com.sunrise.boss.delegate.cms.waystarmonth;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthVO;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthListVO;
import com.sunrise.boss.business.cms.waystarmonth.control.WaystarmonthControlBean;
import com.sunrise.boss.business.cms.waystarmonth.control.WaystarmonthControl;

import java.io.Serializable;

/**
 * <p>Title: WaystarmonthDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class WaystarmonthDelegate {

    private static WaystarmonthControl control;

    public WaystarmonthDelegate() throws Exception {
        control = (WaystarmonthControl) ControlFactory.build(WaystarmonthControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public WaystarmonthVO doCreate(WaystarmonthVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(WaystarmonthVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public WaystarmonthVO doUpdate(WaystarmonthVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public WaystarmonthVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WaystarmonthVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(WaystarmonthListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public String queryEftmonthtype(User user) throws Exception{
    	return control.queryEftmonthtype(user);
    }

}
