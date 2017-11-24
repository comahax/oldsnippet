/**
* auto-generated code
* Wed Apr 11 10:59:58 CST 2007
*/
package com.sunrise.boss.delegate.cms.microarea;

import java.io.Serializable;

import com.sunrise.boss.business.cms.microarea.control.MicroareaControl;
import com.sunrise.boss.business.cms.microarea.control.MicroareaControlBean;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaListVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: MicroareaDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class MicroareaDelegate {

    private static MicroareaControl control;

    public MicroareaDelegate() throws Exception {
        control = (MicroareaControl) ControlFactory.build(MicroareaControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public MicroareaVO doCreate(MicroareaVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(MicroareaVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public MicroareaVO doUpdate(MicroareaVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public MicroareaVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (MicroareaVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(MicroareaListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQueryByOprcode(MicroareaListVO params, User user) throws Exception {
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
