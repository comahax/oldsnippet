package com.gmcc.pboss.control.reward.payment;

import com.gmcc.pboss.business.reward.payment.VUpoprcodeDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface VUpoprcode extends AbstractControl {
    public DataPackage doQuery(VUpoprcodeDBParam params) throws Exception;

    public DataPackage doQueryBySql(VUpoprcodeDBParam params) throws Exception;
}
