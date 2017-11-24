/**
* auto-generated code
* Tue Sep 12 17:06:59 CST 2006
*/
package com.sunrise.boss.delegate.cms.wayhierarchy;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyVO;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyListVO;
import com.sunrise.boss.business.cms.wayhierarchy.control.WayhierarchyControlBean;
import com.sunrise.boss.business.cms.wayhierarchy.control.WayhierarchyControl;

import java.io.Serializable;

/**
 * <p>Title: WayhierarchyDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayhierarchyDelegate {

    private static WayhierarchyControl control;

    public WayhierarchyDelegate() throws Exception {
        control = (WayhierarchyControl) ControlFactory.build(WayhierarchyControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WayhierarchyVO doCreate(WayhierarchyVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WayhierarchyVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public WayhierarchyVO doUpdate(WayhierarchyVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WayhierarchyVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WayhierarchyVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WayhierarchyListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
	public boolean check(User user)  throws Exception {
		 return control.check( user);
	}
	public void build(User user)  throws Exception {
		 control.build( user);		
	}
	
	public boolean check(String wayid, User user) throws  Exception{
		return control.check(wayid, user);
	}
	
	public void build(String wayid, User user) throws  Exception {
		control.build(wayid, user);
	}
}
