/**
* auto-generated code
* Fri Dec 08 17:16:19 CST 2006
*/
package com.sunrise.boss.delegate.cms.fee.bail;

import java.io.Serializable;

import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.cms.fee.bail.control.BailControl;
import com.sunrise.boss.business.cms.fee.bail.control.BailControlBean;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailListVO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BailDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class BailDelegate {

    private static BailControl control;

    public BailDelegate() throws Exception {
        control = (BailControl) ControlFactory.build(BailControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BailVO doCreate(BailVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BailVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public BailVO doUpdate(BailVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BailVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BailVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BailListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public OperatorVO doOperatorFindByPk(Serializable pk, User user) 
        throws Exception {
        return control.doOperatorFindByPk(pk, user);
    }
}
