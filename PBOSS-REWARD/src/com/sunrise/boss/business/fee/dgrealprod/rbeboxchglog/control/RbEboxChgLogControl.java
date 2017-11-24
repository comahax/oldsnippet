/**
* auto-generated code
* Fri Apr 18 17:19:00 CST 2008
*/
package com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogVO;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogListVO;

import java.io.Serializable;

/**
 * <p>Title: RbEboxChgLogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
public interface RbEboxChgLogControl extends AbstractControl {
    public RbEboxChgLogVO doCreate(RbEboxChgLogVO vo, User user)
        throws Exception;

    public void doRemove(RbEboxChgLogVO vo, User user)
        throws Exception;

    public RbEboxChgLogVO doUpdate(RbEboxChgLogVO vo, User user)
        throws Exception;

    public RbEboxChgLogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RbEboxChgLogListVO params, User user)
        throws Exception;

}
