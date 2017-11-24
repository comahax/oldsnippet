/**
* auto-generated code
* Mon Apr 16 17:13:59 CST 2007
*/
package com.sunrise.boss.business.cms.adimarealog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogVO;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogListVO;

import java.io.Serializable;

/**
 * <p>Title: AdimarealogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public interface AdimarealogControl extends AbstractControl {
    public AdimarealogVO doCreate(AdimarealogVO vo, User user)
        throws Exception;

    public void doRemove(AdimarealogVO vo, User user)
        throws Exception;

    public AdimarealogVO doUpdate(AdimarealogVO vo, User user)
        throws Exception;

    public AdimarealogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AdimarealogListVO params, User user)
        throws Exception;

}
