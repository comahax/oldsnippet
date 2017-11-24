/**
* auto-generated code
* Tue Aug 21 10:38:31 CST 2012
*/
package com.sunrise.boss.business.cms.paymentbatch.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchVO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchListVO;

import java.io.Serializable;

/**
 * <p>Title: PaymentbatchControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface PaymentbatchControl extends AbstractControl {
    public PaymentbatchVO doCreate(PaymentbatchVO vo, User user)
        throws Exception;

    public void doRemove(PaymentbatchVO vo, User user)
        throws Exception;

    public PaymentbatchVO doUpdate(PaymentbatchVO vo, User user)
        throws Exception;

    public PaymentbatchVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PaymentbatchListVO params, User user)
        throws Exception;

    public void doPayment(Short isflag, String batchno, User user)
        throws Exception;
}
