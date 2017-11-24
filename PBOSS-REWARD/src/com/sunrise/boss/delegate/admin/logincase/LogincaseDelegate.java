/**
* auto-generated code
* Mon Apr 30 16:49:59 CST 2007
*/
package com.sunrise.boss.delegate.admin.logincase;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.logincase.control.LogincaseControl;
import com.sunrise.boss.business.admin.logincase.control.LogincaseControlBean;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseVO;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseListVO;

import java.io.Serializable;

/**
 * <p>Title: LogincaseDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class LogincaseDelegate {

    private static LogincaseControl control;

    public LogincaseDelegate() throws Exception {
        control = (LogincaseControl) ControlFactory.build(LogincaseControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public LogincaseVO doCreate(LogincaseVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(LogincaseVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public LogincaseVO doUpdate(LogincaseVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public LogincaseVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (LogincaseVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(LogincaseListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public static void main(String[] args) throws Exception {
    	LogincaseDelegate delegate = new LogincaseDelegate();
    	DataPackage dataPackage = delegate.doQuery(null, new User());
    	
    	System.out.println("LogincaseDelegate " + dataPackage.getDatas());
    	
	}
}
