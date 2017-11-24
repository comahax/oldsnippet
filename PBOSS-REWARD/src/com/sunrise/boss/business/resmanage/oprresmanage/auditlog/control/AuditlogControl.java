/**
* auto-generated code
* Sat Jun 14 21:14:25 CST 2008
*/
package com.sunrise.boss.business.resmanage.oprresmanage.auditlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.oprresmanage.auditlog.persistent.AuditlogVO;
import com.sunrise.boss.business.resmanage.oprresmanage.auditlog.persistent.AuditlogListVO;

import java.io.Serializable;

/**
 * <p>Title: AuditlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface AuditlogControl extends AbstractControl {
    public AuditlogVO doCreate(AuditlogVO vo, User user)
        throws Exception;

    public void doRemove(AuditlogVO vo, User user)
        throws Exception;

    public AuditlogVO doUpdate(AuditlogVO vo, User user)
        throws Exception;

    public AuditlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AuditlogListVO params, User user)
        throws Exception;

}
