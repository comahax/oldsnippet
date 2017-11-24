/**
* auto-generated code
* Mon Apr 16 17:14:45 CST 2007
*/
package com.sunrise.boss.business.cms.servcentlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogVO;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ServcentlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public interface ServcentlogControl extends AbstractControl {
    public ServcentlogVO doCreate(ServcentlogVO vo, User user)
        throws Exception;

    public void doRemove(ServcentlogVO vo, User user)
        throws Exception;

    public ServcentlogVO doUpdate(ServcentlogVO vo, User user)
        throws Exception;

    public ServcentlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ServcentlogListVO params, User user)
        throws Exception;

}
