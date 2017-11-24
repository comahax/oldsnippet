/**
* auto-generated code
* Tue May 17 18:38:00 CST 2011
*/
package com.sunrise.boss.business.cms.reward.credittotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalVO;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalListVO;

import java.io.Serializable;

/**
 * <p>Title: CredittotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface CredittotalControl extends AbstractControl {
    public CredittotalVO doCreate(CredittotalVO vo, User user)
        throws Exception;

    public void doRemove(CredittotalVO vo, User user)
        throws Exception;

    public CredittotalVO doUpdate(CredittotalVO vo, User user)
        throws Exception;

    public CredittotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CredittotalListVO params, User user)
        throws Exception;

}
