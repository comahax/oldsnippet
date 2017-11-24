package com.gmcc.pboss.control.reward.payee;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payee.PayeeDBParam;
import com.gmcc.pboss.business.reward.payee.PayeeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Payee </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Payee extends AbstractControl {
    public PayeeVO doCreate(PayeeVO vo) throws Exception;

    public void doRemoveByVO(PayeeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PayeeVO doUpdate(PayeeVO vo) throws Exception;

    public PayeeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PayeeDBParam params) throws Exception;
    
    public DataPackage doQueryPayeeBySql(PayeeDBParam params, int type) throws Exception;

}
