/**
* auto-generated code
* Wed Apr 11 11:02:17 CST 2007
*/
package com.sunrise.boss.delegate.cms.servcent;

import java.io.Serializable;

import com.sunrise.boss.business.cms.servcent.control.ServcentControl;
import com.sunrise.boss.business.cms.servcent.control.ServcentControlBean;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentListVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ServcentDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class ServcentDelegate {

    private static ServcentControl control;

    public ServcentDelegate() throws Exception {
        control = (ServcentControl) ControlFactory.build(ServcentControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ServcentVO doCreate(ServcentVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ServcentVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public ServcentVO doUpdate(ServcentVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ServcentVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (ServcentVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ServcentListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQueryByOprcode(ServcentListVO params, User user) throws Exception {
		return control.doQueryByOprcode(params, user);
	}
    public boolean doIfOrgcodenull(String adacode, User user) throws Exception{
    	return control.doIfOrgcodenull(adacode, user);
    }
    public void doUpdateOrgcode(String adacode, String orgcode, User user)throws Exception{
    	control.doUpdateOrgcode(adacode, orgcode, user);
    }
    public String doGetOrgcode(String adacode, User user) throws Exception {
    	return control.doGetOrgcode(adacode, user);
    }
}
