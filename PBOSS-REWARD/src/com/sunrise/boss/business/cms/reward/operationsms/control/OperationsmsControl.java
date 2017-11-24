/**
* auto-generated code
* Mon Feb 21 10:31:26 CST 2011
*/
package com.sunrise.boss.business.cms.reward.operationsms.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsVO;
import com.sunrise.boss.business.cms.reward.operationsms.persistent.OperationsmsListVO;

import java.io.Serializable;

/**
 * <p>Title: OperationsmsControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface OperationsmsControl extends AbstractControl {
    public OperationsmsVO doCreate(OperationsmsVO vo, User user)
        throws Exception;

    public void doRemove(OperationsmsVO vo, User user)
        throws Exception;

    public OperationsmsVO doUpdate(OperationsmsVO vo, User user)
        throws Exception;

    public OperationsmsVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(OperationsmsListVO params, User user)
        throws Exception;

}
