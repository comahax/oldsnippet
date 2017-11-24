/**
 * auto-generated code
 * Tue Sep 15 10:37:06 CST 2015
 */
package com.gmcc.pboss.control.reward.chcwpaymentsend;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendDBParam;
import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendVO;
import com.gmcc.pboss.business.reward.chcwpaymentsend.VChCwPaymentsendDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ChCwPaymentsend </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author ydr
 * @version 1.0
 */
public interface ChCwPaymentsend extends AbstractControl {
    public ChCwPaymentsendVO doCreate(ChCwPaymentsendVO vo) throws Exception;

    public void doRemoveByVO(ChCwPaymentsendVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ChCwPaymentsendVO doUpdate(ChCwPaymentsendVO vo) throws Exception;

    public ChCwPaymentsendVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ChCwPaymentsendDBParam params) throws Exception;
    
    public DataPackage doQueryByNamedSql(String sql, VChCwPaymentsendDBParam params, int type) throws Exception;

    public DataPackage doQuerySbatchBySql(ChCwPaymentsendDBParam params, int type) throws Exception;
}
