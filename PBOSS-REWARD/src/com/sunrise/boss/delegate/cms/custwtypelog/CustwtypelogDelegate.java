/**
* auto-generated code
* Tue Oct 17 17:34:18 CST 2006
*/
package com.sunrise.boss.delegate.cms.custwtypelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custwtypelog.control.CustwtypelogControl;
import com.sunrise.boss.business.cms.custwtypelog.control.CustwtypelogControlBean;
import com.sunrise.boss.business.cms.custwtypelog.persistent.CustwtypelogVO;
import com.sunrise.boss.business.cms.custwtypelog.persistent.CustwtypelogListVO;

import java.io.Serializable;

/**
 * <p>Title: CustwtypelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class CustwtypelogDelegate {

    private static CustwtypelogControl control;

    public CustwtypelogDelegate() throws Exception {
        control = (CustwtypelogControl) ControlFactory.build(CustwtypelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CustwtypelogVO doCreate(CustwtypelogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CustwtypelogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CustwtypelogVO doUpdate(CustwtypelogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CustwtypelogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CustwtypelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CustwtypelogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
