/**
* auto-generated code
* Wed Oct 18 14:48:22 CST 2006
*/
package com.sunrise.boss.business.cms.waylog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogVO;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogListVO;

import java.io.Serializable;

/**
 * <p>Title: WaylogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WaylogControl extends AbstractControl {
    public WaylogVO doCreate(WaylogVO vo, User user)
        throws Exception;

    public void doRemove(WaylogVO vo, User user)
        throws Exception;

    public WaylogVO doUpdate(WaylogVO vo, User user)
        throws Exception;

    public WaylogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaylogListVO params, User user)
        throws Exception;

}
