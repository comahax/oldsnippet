/**
* auto-generated code
* Thu May 19 20:47:27 CST 2011
*/
package com.sunrise.boss.delegate.cms.smstmpl;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplVO;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplListVO;
import com.sunrise.boss.business.cms.smstmpl.control.SmstmplControlBean;
import com.sunrise.boss.business.cms.smstmpl.control.SmstmplControl;

import java.io.Serializable;

/**
 * <p>Title: SmstmplDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SmstmplDelegate {

    private static SmstmplControl control;

    public SmstmplDelegate() throws Exception {
        control = (SmstmplControl) ControlFactory.build(SmstmplControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public SmstmplVO doCreate(SmstmplVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(SmstmplVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public SmstmplVO doUpdate(SmstmplVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public SmstmplVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (SmstmplVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(SmstmplListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
