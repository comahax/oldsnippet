/**
* auto-generated code
* Wed Oct 18 14:54:55 CST 2006
*/
package com.sunrise.boss.business.cms.waycompctlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogVO;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogListVO;

import java.io.Serializable;

/**
 * <p>Title: WaycompctlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WaycompctlogControl extends AbstractControl {
    public WaycompctlogVO doCreate(WaycompctlogVO vo, User user)
        throws Exception;

    public void doRemove(WaycompctlogVO vo, User user)
        throws Exception;

    public WaycompctlogVO doUpdate(WaycompctlogVO vo, User user)
        throws Exception;

    public WaycompctlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaycompctlogListVO params, User user)
        throws Exception;

}
