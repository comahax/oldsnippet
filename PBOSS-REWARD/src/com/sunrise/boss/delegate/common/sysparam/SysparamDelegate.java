/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/
package com.sunrise.boss.delegate.common.sysparam;

import java.io.Serializable;

import com.sunrise.boss.business.common.sysparam.control.SysparamControl;
import com.sunrise.boss.business.common.sysparam.control.SysparamControlBean;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: SysparamDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class SysparamDelegate {

    private SysparamControl control;

    public SysparamDelegate() throws Exception {
        control = (SysparamControl) ControlFactory.build(SysparamControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public SysparamVO doCreate(SysparamVO vo, User user)
        throws Exception {
		if (vo != null) {
        	return control.doCreate(vo, user);
		}
		return null;
    }
    public void doRemove(SysparamVO vo, User user)
        throws Exception {
		if (vo != null) {
        	control.doRemove(vo, user);
		}
    }
    public SysparamVO doUpdate(SysparamVO vo, User user)
        throws Exception {
		if (vo != null) {
        	return control.doUpdate(vo, user);
		}
		return null;
    }
    public SysparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
		if (pk != null) {
        	return (SysparamVO) control.doFindByPk(pk, user);
		}
		return null;
    }
    public DataPackage doQuery(SysparamListVO params, User user)
        throws Exception {
		if (params != null) {
        	return control.doQuery(params, user);
		}
		return null;
    }
    
    public String doFindByID(Long systemid, String paramtype, User user)
    	throws Exception {
    	return control.doFindByID(systemid, paramtype, user);
    }
    
}
