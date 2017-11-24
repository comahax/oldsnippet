/**
* auto-generated code
* Thu Feb 12 09:39:32 CST 2009
*/
package com.sunrise.boss.delegate.cms.wayhzwg;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgVO;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgListVO;
import com.sunrise.boss.business.cms.wayhzwg.control.WayhzwgControlBean;
import com.sunrise.boss.business.cms.wayhzwg.control.WayhzwgControl;

import java.io.Serializable;

/**
 * <p>Title: WayhzwgDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WayhzwgDelegate {

    private static WayhzwgControl control;

    public WayhzwgDelegate() throws Exception {
        control = (WayhzwgControl) ControlFactory.build(WayhzwgControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WayhzwgVO doCreate(WayhzwgVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WayhzwgVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public WayhzwgVO doUpdate(WayhzwgVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WayhzwgVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WayhzwgVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WayhzwgListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
