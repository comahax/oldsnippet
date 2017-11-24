/**
* auto-generated code
* Thu Jul 26 17:37:14 CST 2007
*/
package com.sunrise.boss.delegate.cms.fdauditdef;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.fdauditdef.control.FdauditdefControl;
import com.sunrise.boss.business.cms.fdauditdef.control.FdauditdefControlBean;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;

import java.io.Serializable;

/**
 * <p>Title: FdauditdefDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FdauditdefDelegate {

    private static FdauditdefControl control;

    public FdauditdefDelegate() throws Exception {
        control = (FdauditdefControl) ControlFactory.build(FdauditdefControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public FdauditdefVO doCreate(FdauditdefVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(FdauditdefVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public FdauditdefVO doUpdate(FdauditdefVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public FdauditdefVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (FdauditdefVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(FdauditdefListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage queryTypes(User user) throws Exception{
    	return control.queryTypes(user);
    }
}
