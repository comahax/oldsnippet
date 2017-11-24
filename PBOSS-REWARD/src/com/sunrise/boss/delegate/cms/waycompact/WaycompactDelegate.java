/**
* auto-generated code
* Fri Aug 25 11:29:29 CST 2006
*/
package com.sunrise.boss.delegate.cms.waycompact;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waycompact.control.WaycompactControl;
import com.sunrise.boss.business.cms.waycompact.control.WaycompactControlBean;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactListVO;

import java.io.Serializable;

/**
 * <p>Title: WaycompactDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class WaycompactDelegate {

    private static WaycompactControl control;

    public WaycompactDelegate() throws Exception {
        control = (WaycompactControl) ControlFactory.build(WaycompactControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaycompactVO doCreate(WaycompactVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WaycompactVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WaycompactVO doUpdate(WaycompactVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaycompactVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WaycompactVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WaycompactListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage queryByOprcodeAndType(WaycompactListVO params, User user)
	throws Exception {
    	return control.queryByOprcodeAndType(params,user);
    }
}
