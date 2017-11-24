/**
 * auto-generated code
 * Fri Dec 17 11:26:27 CST 2010
 */
package com.gmcc.pboss.control.sales.auditdet;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.auditdet.AuditdetDBParam;
import com.gmcc.pboss.business.sales.auditdet.AuditdetVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Auditdet </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Auditdet extends AbstractControl {
    public AuditdetVO doCreate(AuditdetVO vo) throws Exception;

    public void doRemoveByVO(AuditdetVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AuditdetVO doUpdate(AuditdetVO vo) throws Exception;

    public AuditdetVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AuditdetDBParam params) throws Exception;

}
