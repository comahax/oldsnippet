package com.gmcc.pboss.control.reward.paymentlog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paymentlog.PaymentlogDBParam;
import com.gmcc.pboss.business.reward.paymentlog.PaymentlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Paymentlog </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Paymentlog extends AbstractControl {
    public PaymentlogVO doCreate(PaymentlogVO vo) throws Exception;

    public void doRemoveByVO(PaymentlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PaymentlogVO doUpdate(PaymentlogVO vo) throws Exception;

    public PaymentlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PaymentlogDBParam params) throws Exception;

}
