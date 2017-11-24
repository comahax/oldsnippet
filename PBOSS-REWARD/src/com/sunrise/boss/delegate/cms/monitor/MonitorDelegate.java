/**
* auto-generated code
* Tue Aug 21 08:42:57 CST 2012
*/
package com.sunrise.boss.delegate.cms.monitor;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorVO;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorListVO;
import com.sunrise.boss.business.cms.monitor.control.MonitorControlBean;
import com.sunrise.boss.business.cms.monitor.control.MonitorControl;

import java.io.Serializable;

/**
 * <p>Title: MonitorDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class MonitorDelegate {

    private static MonitorControl control;

    public MonitorDelegate() throws Exception {
        control = (MonitorControl) ControlFactory.build(MonitorControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public MonitorVO doCreate(MonitorVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(MonitorVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public MonitorVO doUpdate(MonitorVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public MonitorVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (MonitorVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(MonitorListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public String doCreateaccount(MonitorListVO params, User user)
    throws Exception{
    	return control.doCreateaccount(params, user);
    }

}
