package com.gmcc.pboss.control.reward.rate;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rate.RateDBParam;
import com.gmcc.pboss.business.reward.rate.RateVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rate </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Rate extends AbstractControl {
    public RateVO doCreate(RateVO vo) throws Exception;

    public void doRemoveByVO(RateVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RateVO doUpdate(RateVO vo) throws Exception;

    public RateVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RateDBParam params) throws Exception;

}
