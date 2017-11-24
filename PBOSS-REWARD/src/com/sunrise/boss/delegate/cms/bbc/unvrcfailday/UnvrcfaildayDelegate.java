/**
* auto-generated code
* Wed Dec 07 14:34:03 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.unvrcfailday;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayVO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayListVO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.control.UnvrcfaildayControlBean;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.control.UnvrcfaildayControl;

import java.io.Serializable;

/**
 * <p>Title: UnvrcfaildayDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class UnvrcfaildayDelegate {

    private static UnvrcfaildayControl control;

    public UnvrcfaildayDelegate() throws Exception {
        control = (UnvrcfaildayControl) ControlFactory.build(UnvrcfaildayControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public UnvrcfaildayVO doCreate(UnvrcfaildayVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(UnvrcfaildayVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public UnvrcfaildayVO doUpdate(UnvrcfaildayVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public UnvrcfaildayVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (UnvrcfaildayVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(UnvrcfaildayListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
   
    public DataPackage doQueryWithEmpinfo(UnvrcfaildayListVO params, User user)
    	throws Exception  {
    	return control.doQueryWithEmpinfo(params, user);
    }

}
