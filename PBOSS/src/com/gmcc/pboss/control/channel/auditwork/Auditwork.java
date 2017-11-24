/**
 * auto-generated code
 * Thu Oct 15 16:20:00 CST 2009
 */
package com.gmcc.pboss.control.channel.auditwork;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.auditwork.AuditworkDBParam;
import com.gmcc.pboss.business.channel.auditwork.AuditworkVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Auditwork </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Auditwork extends AbstractControl {
    public AuditworkVO doCreate(AuditworkVO vo) throws Exception;

    public void doRemoveByVO(AuditworkVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AuditworkVO doUpdate(AuditworkVO vo) throws Exception;

    public AuditworkVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AuditworkDBParam params) throws Exception;

}
