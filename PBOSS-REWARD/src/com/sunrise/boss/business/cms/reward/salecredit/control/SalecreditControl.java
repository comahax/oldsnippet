/**
* auto-generated code
* Tue May 17 15:57:34 CST 2011
*/
package com.sunrise.boss.business.cms.reward.salecredit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditVO;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditListVO;

import java.io.Serializable;

/**
 * <p>Title: SalecreditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface SalecreditControl extends AbstractControl {
    public SalecreditVO doCreate(SalecreditVO vo, User user)
        throws Exception;

    public void doRemove(SalecreditVO vo, User user)
        throws Exception;

    public SalecreditVO doUpdate(SalecreditVO vo, User user)
        throws Exception;

    public SalecreditVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SalecreditListVO params, User user)
        throws Exception;

}
