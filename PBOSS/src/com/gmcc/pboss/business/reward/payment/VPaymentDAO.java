package com.gmcc.pboss.business.reward.payment;

import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: PaymentDAO</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class VPaymentDAO extends AbstractDAO {

    public VPaymentDAO(){
        super(VPaymentVO.class);
    }
}