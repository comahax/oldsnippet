package com.gmcc.pboss.control.reward.paymentsclog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paymentsclog.PaymentsclogDBParam;
import com.gmcc.pboss.business.reward.paymentsclog.PaymentsclogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Paymentsclog </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Paymentsclog extends AbstractControl {
    public PaymentsclogVO doCreate(PaymentsclogVO vo) throws Exception;

    public void doRemoveByVO(PaymentsclogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PaymentsclogVO doUpdate(PaymentsclogVO vo) throws Exception;

    public PaymentsclogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PaymentsclogDBParam params) throws Exception;

}
