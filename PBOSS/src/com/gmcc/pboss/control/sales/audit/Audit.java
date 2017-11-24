/**
 * auto-generated code
 * Wed Jul 28 15:30:49 CST 2010
 */
package com.gmcc.pboss.control.sales.audit;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.audit.AuditDBParam;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Audit </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Audit extends AbstractControl {
    public AuditVO doCreate(AuditVO vo) throws Exception;

    public void doRemoveByVO(AuditVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AuditVO doUpdate(AuditVO vo) throws Exception;

    public AuditVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AuditDBParam params) throws Exception;
    
    public void doBatchSubmitAudit(String[] orderids,String auditor) throws Exception;
    public void doSubmitAudit(String orderid, String auditor ,boolean isSingle)throws Exception ;
    public void doBatchAudit(String[] seqids,String state,String opinion)throws Exception ;
    public DataPackage doDefaultQuery(AuditDBParam params) throws Exception ;
    public DataPackage doGetAuditInfo(AuditDBParam param)throws Exception ;
    
    public void doBatchSubmitAudit2(String[] orderids, String auditor,String memo) throws Exception ;

}
