/**
* auto-generated code
* Wed Nov 16 16:25:57 CST 2011
*/
package com.sunrise.boss.delegate.cms.nores;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.nores.persistent.NoresVO;
import com.sunrise.boss.business.cms.nores.persistent.NoresListVO;
import com.sunrise.boss.business.cms.nores.control.NoresControlBean;
import com.sunrise.boss.business.cms.nores.control.NoresControl;

import java.io.Serializable;

/**
 * <p>Title: NoresDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class NoresDelegate {

    private static NoresControl control;

    public NoresDelegate() throws Exception {
        control = (NoresControl) ControlFactory.build(NoresControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public NoresVO doCreate(NoresVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(NoresVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public NoresVO doUpdate(NoresVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public NoresVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (NoresVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(NoresListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
