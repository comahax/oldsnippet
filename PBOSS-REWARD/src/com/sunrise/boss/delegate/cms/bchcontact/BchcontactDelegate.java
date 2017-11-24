/**
* auto-generated code
* Fri Aug 25 11:28:40 CST 2006
*/
package com.sunrise.boss.delegate.cms.bchcontact;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControl;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControlBean;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactListVO;

import java.io.Serializable;

/**
 * <p>Title: BchcontactDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class BchcontactDelegate {

    private static BchcontactControl control;

    public BchcontactDelegate() throws Exception {
        control = (BchcontactControl) ControlFactory.build(BchcontactControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BchcontactVO doCreate(BchcontactVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BchcontactVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BchcontactVO doUpdate(BchcontactVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BchcontactVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BchcontactVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BchcontactListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage queryByOprcodeAndType(BchcontactListVO params,User user) throws Exception{
    	return control.queryByOprcodeAndType(params, user);
    }
}
