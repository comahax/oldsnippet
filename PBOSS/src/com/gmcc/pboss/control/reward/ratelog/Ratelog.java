package com.gmcc.pboss.control.reward.ratelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ratelog.RatelogDBParam;
import com.gmcc.pboss.business.reward.ratelog.RatelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ratelog </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Ratelog extends AbstractControl {
    public RatelogVO doCreate(RatelogVO vo) throws Exception;

    public void doRemoveByVO(RatelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RatelogVO doUpdate(RatelogVO vo) throws Exception;

    public RatelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RatelogDBParam params) throws Exception;

}
