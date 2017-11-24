/**
* auto-generated code
* Fri Aug 28 11:21:30 CST 2009
*/
package com.sunrise.boss.business.cms.reward.busitocomlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogVO;
import com.sunrise.boss.business.cms.reward.busitocomlog.persistent.BusitocomlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BusitocomlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface BusitocomlogControl extends AbstractControl {
    public BusitocomlogVO doCreate(BusitocomlogVO vo, User user)
        throws Exception;

    public void doRemove(BusitocomlogVO vo, User user)
        throws Exception;

    public BusitocomlogVO doUpdate(BusitocomlogVO vo, User user)
        throws Exception;

    public BusitocomlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusitocomlogListVO params, User user)
        throws Exception;

}
