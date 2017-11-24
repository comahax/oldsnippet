/**
* auto-generated code
* Wed Dec 07 09:27:39 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.blacklist.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistVO;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistListVO;

import java.io.Serializable;

/**
 * <p>Title: BlacklistControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface BlacklistControl extends AbstractControl {
    public BlacklistVO doCreate(BlacklistVO vo, User user)
        throws Exception;

    public void doRemove(BlacklistVO vo, User user)
        throws Exception;

    public BlacklistVO doUpdate(BlacklistVO vo, User user)
        throws Exception;

    public BlacklistVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BlacklistListVO params, User user)
        throws Exception;

}
