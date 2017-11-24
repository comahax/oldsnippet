/**
* auto-generated code
* Thu Oct 09 16:10:24 CST 2008
*/
package com.sunrise.boss.delegate.cms.mpsaudit;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.mpsaudit.control.MpsauditControl;
import com.sunrise.boss.business.cms.mpsaudit.control.MpsauditControlBean;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditVO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditListVO;

import java.io.Serializable;

/**
 * <p>Title: MpsauditDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class MpsauditDelegate {

    private static MpsauditControl control;

    public MpsauditDelegate() throws Exception {
        control = (MpsauditControl) ControlFactory.build(MpsauditControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public MpsauditVO doCreate(MpsauditVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(MpsauditVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public MpsauditVO doUpdate(MpsauditVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public MpsauditVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (MpsauditVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(MpsauditListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
