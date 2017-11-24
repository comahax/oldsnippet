/**
* auto-generated code
* Tue Sep 03 17:48:46 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdentproduct;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.control.ChPdEntproductControl;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.control.ChPdEntproductControlBean;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductListVO;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdEntproductDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdEntproductDelegate {

    private static ChPdEntproductControl control;

    public ChPdEntproductDelegate() throws Exception {
        control = (ChPdEntproductControl) ControlFactory.build(ChPdEntproductControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdEntproductVO doCreate(ChPdEntproductVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdEntproductVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdEntproductVO doUpdate(ChPdEntproductVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdEntproductVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdEntproductVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdEntproductListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
