/**
* auto-generated code
* Fri Feb 15 15:25:15 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busiloadlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogVO;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BusiloadlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public interface BusiloadlogControl extends AbstractControl {
    public BusiloadlogVO doCreate(BusiloadlogVO vo, User user)
        throws Exception;

    public void doRemove(BusiloadlogVO vo, User user)
        throws Exception;

    public BusiloadlogVO doUpdate(BusiloadlogVO vo, User user)
        throws Exception;

    public BusiloadlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusiloadlogListVO params, User user)
        throws Exception;

}
