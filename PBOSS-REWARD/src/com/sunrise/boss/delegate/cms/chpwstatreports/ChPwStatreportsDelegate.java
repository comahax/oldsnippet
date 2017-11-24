/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.delegate.cms.chpwstatreports;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwstatreports.persistent.ChPwStatreportsVO;
import com.sunrise.boss.business.cms.chpwstatreports.persistent.ChPwStatreportsListVO;
import com.sunrise.boss.business.cms.chpwstatreports.control.ChPwStatreportsControlBean;
import com.sunrise.boss.business.cms.chpwstatreports.control.ChPwStatreportsControl;

import java.io.Serializable;

/**
 * <p>Title: ChPwStatreportsDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPwStatreportsDelegate {

    private static ChPwStatreportsControl control;

    public ChPwStatreportsDelegate() throws Exception {
        control = (ChPwStatreportsControl) ControlFactory.build(ChPwStatreportsControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwStatreportsVO doCreate(ChPwStatreportsVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwStatreportsVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwStatreportsVO doUpdate(ChPwStatreportsVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwStatreportsVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwStatreportsVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwStatreportsListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
