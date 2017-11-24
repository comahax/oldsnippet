/**
* auto-generated code
* Thu Oct 09 13:08:46 CST 2008
*/
package com.sunrise.boss.delegate.cms.iodaudit;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.iodaudit.control.IodauditControl;
import com.sunrise.boss.business.cms.iodaudit.control.IodauditControlBean;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditVO;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditListVO;

import java.io.Serializable;

/**
 * <p>Title: IodauditDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class IodauditDelegate {

    private static IodauditControl control;

    public IodauditDelegate() throws Exception {
        control = (IodauditControl) ControlFactory.build(IodauditControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public IodauditVO doCreate(IodauditVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(IodauditVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public IodauditVO doUpdate(IodauditVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public IodauditVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (IodauditVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(IodauditListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
