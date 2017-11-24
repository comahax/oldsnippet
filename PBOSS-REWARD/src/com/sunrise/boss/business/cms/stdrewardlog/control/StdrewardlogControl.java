/**
* auto-generated code
* Fri Feb 01 18:28:31 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogVO;
import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface StdrewardlogControl extends AbstractControl {
    public StdrewardlogVO doCreate(StdrewardlogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardlogVO vo, User user)
        throws Exception;

    public StdrewardlogVO doUpdate(StdrewardlogVO vo, User user)
        throws Exception;

    public StdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardlogListVO params, User user)
        throws Exception;

}
