/**
* auto-generated code
* Sat Feb 02 15:13:27 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.busyxplan;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busyxplan.control.BusyxplanControl;
import com.sunrise.boss.business.cms.reward.busyxplan.control.BusyxplanControlBean;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanVO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanListVO;

import java.io.Serializable;

/**
 * <p>Title: BusyxplanDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanDelegate {

    private static BusyxplanControl control;

    public BusyxplanDelegate() throws Exception {
        control = (BusyxplanControl) ControlFactory.build(BusyxplanControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BusyxplanVO doCreate(BusyxplanVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BusyxplanVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BusyxplanVO doUpdate(BusyxplanVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BusyxplanVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BusyxplanVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BusyxplanListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage queryBusyxplan(BusyxplanListVO params, User user )
    	throws Exception {
    	return control.queryBusyxplan(params, user);
    }
    
}
