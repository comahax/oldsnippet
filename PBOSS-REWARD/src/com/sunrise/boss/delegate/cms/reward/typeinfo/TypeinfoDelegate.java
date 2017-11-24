/**
* auto-generated code
* Tue Apr 10 15:46:57 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.typeinfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoVO;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoListVO;
import com.sunrise.boss.business.cms.reward.typeinfo.control.TypeinfoControlBean;
import com.sunrise.boss.business.cms.reward.typeinfo.control.TypeinfoControl;

import java.io.Serializable;

/**
 * <p>Title: TypeinfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class TypeinfoDelegate {

    private static TypeinfoControl control;

    public TypeinfoDelegate() throws Exception {
        control = (TypeinfoControl) ControlFactory.build(TypeinfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public TypeinfoVO doCreate(TypeinfoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(TypeinfoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public TypeinfoVO doUpdate(TypeinfoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public TypeinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (TypeinfoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(TypeinfoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
