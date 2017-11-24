/**
* auto-generated code
* Wed Oct 18 14:55:37 CST 2006
*/
package com.sunrise.boss.business.cms.wayacctlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogVO;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogListVO;

import java.io.Serializable;

/**
 * <p>Title: WayacctlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WayacctlogControl extends AbstractControl {
    public WayacctlogVO doCreate(WayacctlogVO vo, User user)
        throws Exception;

    public void doRemove(WayacctlogVO vo, User user)
        throws Exception;

    public WayacctlogVO doUpdate(WayacctlogVO vo, User user)
        throws Exception;

    public WayacctlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WayacctlogListVO params, User user)
        throws Exception;

}
