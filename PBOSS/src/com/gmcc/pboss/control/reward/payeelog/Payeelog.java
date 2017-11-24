package com.gmcc.pboss.control.reward.payeelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payeelog.PayeelogDBParam;
import com.gmcc.pboss.business.reward.payeelog.PayeelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Payeelog </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Payeelog extends AbstractControl {
    public PayeelogVO doCreate(PayeelogVO vo) throws Exception;

    public void doRemoveByVO(PayeelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PayeelogVO doUpdate(PayeelogVO vo) throws Exception;

    public PayeelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PayeelogDBParam params) throws Exception;

}
