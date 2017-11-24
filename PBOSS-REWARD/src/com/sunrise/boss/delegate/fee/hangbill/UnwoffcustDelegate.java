/**
* auto-generated code
* Wed Aug 16 11:38:36 CST 2006
*/
package com.sunrise.boss.delegate.fee.hangbill;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.business.fee.hangbill.persistent.*;
import com.sunrise.boss.business.fee.hangbill.control.*;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

import java.io.Serializable;

/**
 * <p>Title: UnwoffcustDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class UnwoffcustDelegate {

    private UnwoffcustControl control;
    public UnwoffcustDelegate() throws Exception {
    	control = (UnwoffcustControl) ControlFactory.build(UnwoffcustControlBean.class);
    	if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public UnwoffcustVO doCreate(UnwoffcustVO vo, User user)
        throws Exception {
    	return control.doCreate(vo, user);
    }
    public void doRemove(UnwoffcustVO vo, User user)
        throws Exception {
    	control.doRemove(vo, user);
    }
    public UnwoffcustVO doUpdate(UnwoffcustVO vo, User user)
        throws Exception {
    	return control.doUpdate(vo, user);
    }
    public UnwoffcustVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	return (UnwoffcustVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(UnwoffcustListVO params, User user)
        throws Exception {
    	return control.doQuery(params, user);
    }

}
