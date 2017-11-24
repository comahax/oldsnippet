/**
* auto-generated code
* Fri Aug 25 11:25:35 CST 2006
*/
package com.sunrise.boss.delegate.cms.custwaytype;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custwaytype.control.CustwaytypeControl;
import com.sunrise.boss.business.cms.custwaytype.control.CustwaytypeControlBean;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeVO;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeListVO;

import java.io.Serializable;

/**
 * <p>Title: CustwaytypeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CustwaytypeDelegate {

    private static CustwaytypeControl control;

    public CustwaytypeDelegate() throws Exception {
        control = (CustwaytypeControl) ControlFactory.build(CustwaytypeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CustwaytypeVO doCreate(CustwaytypeVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CustwaytypeVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CustwaytypeVO doUpdate(CustwaytypeVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CustwaytypeVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CustwaytypeVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CustwaytypeListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
