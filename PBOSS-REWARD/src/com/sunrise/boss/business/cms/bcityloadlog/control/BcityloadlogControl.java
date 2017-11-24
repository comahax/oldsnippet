/**
* auto-generated code
* Tue Feb 05 10:15:16 CST 2008
*/
package com.sunrise.boss.business.cms.bcityloadlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogVO;
import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BcityloadlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BcityloadlogControl extends AbstractControl {
    public BcityloadlogVO doCreate(BcityloadlogVO vo, User user)
        throws Exception;

    public void doRemove(BcityloadlogVO vo, User user)
        throws Exception;

    public BcityloadlogVO doUpdate(BcityloadlogVO vo, User user)
        throws Exception;

    public BcityloadlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BcityloadlogListVO params, User user)
        throws Exception;

}
