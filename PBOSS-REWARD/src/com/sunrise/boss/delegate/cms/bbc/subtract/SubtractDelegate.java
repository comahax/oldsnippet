/**
* auto-generated code
* Fri Apr 20 16:55:21 CST 2012
*/
package com.sunrise.boss.delegate.cms.bbc.subtract;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractVO;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractListVO;
import com.sunrise.boss.business.cms.bbc.subtract.control.SubtractControlBean;
import com.sunrise.boss.business.cms.bbc.subtract.control.SubtractControl;

import java.io.Serializable;

/**
 * <p>Title: SubtractDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SubtractDelegate {

    private static SubtractControl control;

    public SubtractDelegate() throws Exception {
        control = (SubtractControl) ControlFactory.build(SubtractControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public SubtractVO doCreate(SubtractVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(SubtractVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public SubtractVO doUpdate(SubtractVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public SubtractVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (SubtractVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(SubtractListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
