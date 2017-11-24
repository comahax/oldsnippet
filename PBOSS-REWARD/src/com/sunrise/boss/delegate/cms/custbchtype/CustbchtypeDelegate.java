/**
* auto-generated code
* Fri Aug 25 11:26:23 CST 2006
*/
package com.sunrise.boss.delegate.cms.custbchtype;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custbchtype.control.CustbchtypeControl;
import com.sunrise.boss.business.cms.custbchtype.control.CustbchtypeControlBean;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeVO;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeListVO;

import java.io.Serializable;

/**
 * <p>Title: CustbchtypeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CustbchtypeDelegate {

    private static CustbchtypeControl control;

    public CustbchtypeDelegate() throws Exception {
        control = (CustbchtypeControl) ControlFactory.build(CustbchtypeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CustbchtypeVO doCreate(CustbchtypeVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CustbchtypeVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CustbchtypeVO doUpdate(CustbchtypeVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CustbchtypeVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CustbchtypeVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CustbchtypeListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
