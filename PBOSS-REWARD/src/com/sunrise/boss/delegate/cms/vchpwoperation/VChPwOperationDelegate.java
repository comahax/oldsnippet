/**
* auto-generated code
* Wed Aug 29 19:13:31 CST 2012
*/
package com.sunrise.boss.delegate.cms.vchpwoperation;

import com.sunrise.boss.business.cms.vchpwoperation.control.VChPwOperationControl;
import com.sunrise.boss.business.cms.vchpwoperation.control.VChPwOperationControlBean;
import com.sunrise.boss.business.cms.vchpwoperation.persistent.VChPwOperationListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: VChPwOperationDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPwOperationDelegate {

    private static VChPwOperationControl control; 
    
    public VChPwOperationDelegate() throws Exception {
        control = (VChPwOperationControl) ControlFactory.build(VChPwOperationControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DataPackage doQuery(VChPwOperationListVO params, User user)
        throws Exception { 
        return control.doQuery(params, user);
    }

}
