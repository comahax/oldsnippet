/**
* auto-generated code
* Thu Aug 24 11:07:55 CST 2006
*/
package com.sunrise.boss.delegate.cms.areacenter;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.areacenter.control.AreacenterControl;
import com.sunrise.boss.business.cms.areacenter.control.AreacenterControlBean;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterVO;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterListVO;

import java.io.Serializable;

/**
 * <p>Title: AreacenterDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class AreacenterDelegate {

    private static AreacenterControl control;

    public AreacenterDelegate() throws Exception {
        control = (AreacenterControl) ControlFactory.build(AreacenterControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public AreacenterVO doCreate(AreacenterVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(AreacenterVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public AreacenterVO doUpdate(AreacenterVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public AreacenterVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (AreacenterVO) control.doFindByPk(pk, user);
    }
    
    public DataPackage doQuery(AreacenterListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage getCenters(User user ) throws Exception {
    return control.getCenters( user);
    }
}
