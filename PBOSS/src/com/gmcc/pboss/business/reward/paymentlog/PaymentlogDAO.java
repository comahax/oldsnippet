package com.gmcc.pboss.business.reward.paymentlog;

import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: PaymentlogDAO</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PaymentlogDAO extends AbstractDAO {

    public PaymentlogDAO(){
        super(PaymentlogVO.class);
    }
}
