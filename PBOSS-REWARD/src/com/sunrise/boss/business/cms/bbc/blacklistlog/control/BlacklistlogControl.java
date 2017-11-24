/**
* auto-generated code
* Wed Dec 07 09:31:25 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.blacklistlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogVO;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BlacklistlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface BlacklistlogControl extends AbstractControl {
    public BlacklistlogVO doCreate(BlacklistlogVO vo, User user)
        throws Exception;

    public void doRemove(BlacklistlogVO vo, User user)
        throws Exception;

    public BlacklistlogVO doUpdate(BlacklistlogVO vo, User user)
        throws Exception;

    public BlacklistlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BlacklistlogListVO params, User user)
        throws Exception;

}
