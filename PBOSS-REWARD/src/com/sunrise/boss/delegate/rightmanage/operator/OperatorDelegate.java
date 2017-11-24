/**
* auto-generated code
* Sat Oct 21 10:49:43 CST 2006
*/
package com.sunrise.boss.delegate.rightmanage.operator;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2VO;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2ListVO;
import com.sunrise.boss.business.rightmanage.operator.control.Operator2ControlBean;
import com.sunrise.boss.business.rightmanage.operator.control.Operator2Control;

import java.io.Serializable;

/**
 * <p>Title: OperatorDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperatorDelegate {

    private static Operator2Control control;

    public OperatorDelegate() throws Exception {
        control = (Operator2Control) ControlFactory.build(Operator2ControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public Operator2VO doCreate(Operator2VO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(Operator2VO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public Operator2VO doUpdate(Operator2VO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public Operator2VO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (Operator2VO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(Operator2ListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
