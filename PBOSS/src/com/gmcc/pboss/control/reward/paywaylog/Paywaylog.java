package com.gmcc.pboss.control.reward.paywaylog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paywaylog.PaywaylogDBParam;
import com.gmcc.pboss.business.reward.paywaylog.PaywaylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface Paywaylog  extends AbstractControl {
    public PaywaylogVO doCreate(PaywaylogVO vo) throws Exception;

    public void doRemoveByVO(PaywaylogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PaywaylogVO doUpdate(PaywaylogVO vo) throws Exception;

    public PaywaylogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PaywaylogDBParam params) throws Exception;
}
