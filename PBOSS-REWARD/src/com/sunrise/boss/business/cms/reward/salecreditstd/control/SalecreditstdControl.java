/**
* auto-generated code
* Wed May 18 10:32:19 CST 2011
*/
package com.sunrise.boss.business.cms.reward.salecreditstd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdVO;
import com.sunrise.boss.business.cms.reward.salecreditstd.persistent.SalecreditstdListVO;

import java.io.Serializable;

/**
 * <p>Title: SalecreditstdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface SalecreditstdControl extends AbstractControl {
    public SalecreditstdVO doCreate(SalecreditstdVO vo, User user)
        throws Exception;

    public void doRemove(SalecreditstdVO vo, User user)
        throws Exception;

    public SalecreditstdVO doUpdate(SalecreditstdVO vo, User user)
        throws Exception;

    public SalecreditstdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SalecreditstdListVO params, User user)
        throws Exception;

}
