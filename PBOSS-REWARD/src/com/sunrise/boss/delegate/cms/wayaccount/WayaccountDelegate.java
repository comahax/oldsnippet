/**
* auto-generated code
* Sat Aug 26 10:44:13 CST 2006
*/
package com.sunrise.boss.delegate.cms.wayaccount;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControl;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControlBean;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;

import java.io.Serializable;

/**
 * <p>Title: WayaccountDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayaccountDelegate {

    private static WayaccountControl control;

    public WayaccountDelegate() throws Exception {
        control = (WayaccountControl) ControlFactory.build(WayaccountControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WayaccountVO doCreate(WayaccountVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WayaccountVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WayaccountVO doUpdate(WayaccountVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WayaccountVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WayaccountVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WayaccountListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage queryByOprcodeAndType(WayaccountListVO params, User user)
	throws Exception {
    	return control.queryByOprcodeAndType(params,user);
    }
}
