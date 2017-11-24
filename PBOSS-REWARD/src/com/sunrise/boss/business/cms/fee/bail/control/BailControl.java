/**
* auto-generated code
* Fri Dec 08 17:16:19 CST 2006
*/
package com.sunrise.boss.business.cms.fee.bail.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailVO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailListVO;

import java.io.Serializable;

/**
 * <p>Title: BailControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface BailControl extends AbstractControl {
    public BailVO doCreate(BailVO vo, User user)
        throws Exception;

    public void doRemove(BailVO vo, User user)
        throws Exception;

    public BailVO doUpdate(BailVO vo, User user)
        throws Exception;

    public BailVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BailListVO params, User user)
        throws Exception;
    public OperatorVO doOperatorFindByPk(Serializable pk, User user) throws Exception;

}
