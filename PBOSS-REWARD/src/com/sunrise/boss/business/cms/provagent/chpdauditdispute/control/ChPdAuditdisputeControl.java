/**
* auto-generated code
* Tue Sep 03 20:54:50 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdauditdispute.control;

import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeListVO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: ChPdAuditdisputeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChPdAuditdisputeControl extends AbstractControl {
    public ChPdAuditdisputeVO doCreate(ChPdAuditdisputeVO vo, User user)
        throws Exception;

    public void doRemove(ChPdAuditdisputeVO vo, User user)
        throws Exception;

    public ChPdAuditdisputeVO doUpdate(ChPdAuditdisputeVO vo, User user)
        throws Exception;

    public ChPdAuditdisputeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdAuditdisputeListVO params, User user)
        throws Exception;

}
