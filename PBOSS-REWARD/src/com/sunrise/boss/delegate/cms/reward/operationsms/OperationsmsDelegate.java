/**
* auto-generated code
* Mon Feb 21 10:31:26 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.operationsms;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsListVO;
import com.sunrise.boss.business.cms.reward.operationsms.control.OperationsmsControlBean;
import com.sunrise.boss.business.cms.reward.operationsms.control.OperationsmsControl;

import java.io.Serializable;

/**
 * <p>Title: OperationsmsDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class OperationsmsDelegate {

    private static OperationsmsControl control;

    public OperationsmsDelegate() throws Exception {
        control = (OperationsmsControl) ControlFactory.build(OperationsmsControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public OperationsmsVO doCreate(OperationsmsVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(OperationsmsVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public OperationsmsVO doUpdate(OperationsmsVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public OperationsmsVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (OperationsmsVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(OperationsmsListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
