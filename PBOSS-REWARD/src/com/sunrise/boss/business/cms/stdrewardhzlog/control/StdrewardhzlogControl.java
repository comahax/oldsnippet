/**
* auto-generated code
* Sun Feb 01 11:20:05 CST 2009
*/
package com.sunrise.boss.business.cms.stdrewardhzlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogVO;
import com.sunrise.boss.business.cms.stdrewardhzlog.persistent.StdrewardhzlogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardhzlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface StdrewardhzlogControl extends AbstractControl {
    public StdrewardhzlogVO doCreate(StdrewardhzlogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardhzlogVO vo, User user)
        throws Exception;

    public StdrewardhzlogVO doUpdate(StdrewardhzlogVO vo, User user)
        throws Exception;

    public StdrewardhzlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardhzlogListVO params, User user)
        throws Exception;

}
