/**
* auto-generated code
* Tue May 17 15:57:34 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.salecredit;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditVO;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditListVO;
import com.sunrise.boss.business.cms.reward.salecredit.control.SalecreditControlBean;
import com.sunrise.boss.business.cms.reward.salecredit.control.SalecreditControl;

import java.io.Serializable;

/**
 * <p>Title: SalecreditDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditDelegate {

    private static SalecreditControl control;

    public SalecreditDelegate() throws Exception {
        control = (SalecreditControl) ControlFactory.build(SalecreditControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public SalecreditVO doCreate(SalecreditVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(SalecreditVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public SalecreditVO doUpdate(SalecreditVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public SalecreditVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (SalecreditVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(SalecreditListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
