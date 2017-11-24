/**
* auto-generated code
* Fri Aug 25 11:24:52 CST 2006
*/
package com.sunrise.boss.delegate.cms.waytype;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waytype.control.WaytypeControl;
import com.sunrise.boss.business.cms.waytype.control.WaytypeControlBean;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeListVO;

import java.io.Serializable;

/**
 * <p>Title: WaytypeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class WaytypeDelegate {

    private static WaytypeControl control;

    public WaytypeDelegate() throws Exception {
        control = (WaytypeControl) ControlFactory.build(WaytypeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaytypeVO doCreate(WaytypeVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WaytypeVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WaytypeVO doUpdate(WaytypeVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaytypeVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WaytypeVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WaytypeListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
	public boolean isAG(String type, User user) throws Exception {
		return control.isAG(type, user);
	}
	public boolean isAGBranch(String subType, User user) throws Exception {
		return control.isAGBranch(subType, user);
	}
	public boolean isET(String type, User user) throws Exception {
		return control.isET(type, user);
	}
	public boolean isETBranch(String subType, User user) throws Exception {
		return control.isETBranch(subType, user);
	}
}
