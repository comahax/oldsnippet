/**
* auto-generated code
* Wed Mar 05 16:44:25 CST 2008
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public interface StdrewardbjlogControl extends AbstractControl {
    public StdrewardbjlogVO doCreate(StdrewardbjlogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbjlogVO vo, User user)
        throws Exception;

    public StdrewardbjlogVO doUpdate(StdrewardbjlogVO vo, User user)
        throws Exception;

    public StdrewardbjlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbjlogListVO params, User user)
        throws Exception;

}
