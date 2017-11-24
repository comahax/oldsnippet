/**
* auto-generated code
* Tue Nov 24 10:54:37 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnperiod;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodListVO;
import com.sunrise.boss.business.cms.examine.exmnperiod.control.ExmnperiodControlBean;
import com.sunrise.boss.business.cms.examine.exmnperiod.control.ExmnperiodControl;

import java.io.Serializable;

/**
 * <p>Title: ExmnperiodDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnperiodDelegate {

    private static ExmnperiodControl control;

    public ExmnperiodDelegate() throws Exception {
        control = (ExmnperiodControl) ControlFactory.build(ExmnperiodControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnperiodVO doCreate(ExmnperiodVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnperiodVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnperiodVO doUpdate(ExmnperiodVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnperiodVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnperiodVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnperiodListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public boolean doCheckBeingPeriod(ExmnperiodVO vo, User user)
    throws Exception{
    	return control.doCheckBeingPeriod(vo, user);
    }

}
