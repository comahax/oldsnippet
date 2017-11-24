/**
 * auto-generated code
 * Tue Aug 03 15:52:05 CST 2010
 */
package com.gmcc.pboss.control.sales.auditlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.auditlog.AuditlogDBParam;
import com.gmcc.pboss.business.sales.auditlog.AuditlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Auditlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Auditlog extends AbstractControl {
    public AuditlogVO doCreate(AuditlogVO vo) throws Exception;

    public void doRemoveByVO(AuditlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AuditlogVO doUpdate(AuditlogVO vo) throws Exception;

    public AuditlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AuditlogDBParam params) throws Exception;

}
