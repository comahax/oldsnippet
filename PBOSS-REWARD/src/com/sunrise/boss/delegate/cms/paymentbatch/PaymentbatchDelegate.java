/**
* auto-generated code
* Tue Aug 21 10:38:31 CST 2012
*/
package com.sunrise.boss.delegate.cms.paymentbatch;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchVO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchListVO;
import com.sunrise.boss.business.cms.paymentbatch.control.PaymentbatchControlBean;
import com.sunrise.boss.business.cms.paymentbatch.control.PaymentbatchControl;

import java.io.Serializable;

/**
 * <p>Title: PaymentbatchDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class PaymentbatchDelegate {

    private static PaymentbatchControl control;

    public PaymentbatchDelegate() throws Exception {
        control = (PaymentbatchControl) ControlFactory.build(PaymentbatchControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public PaymentbatchVO doCreate(PaymentbatchVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(PaymentbatchVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public PaymentbatchVO doUpdate(PaymentbatchVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public PaymentbatchVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (PaymentbatchVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(PaymentbatchListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public void doPayment(Short isflag, String batchno, User user)
        throws Exception {
        control.doPayment(isflag, batchno, user);
    }
}
