/**
* auto-generated code
* Sun Aug 01 20:25:48 CST 2010
*/
package com.sunrise.boss.business.cms.reward.vbusyxplan.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanListVO;


/**
 * <p>Title: VbusyxplanControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public interface VbusyxplanControl extends AbstractControl {

    public DataPackage doQuery(VbusyxplanListVO params, User user)
        throws Exception;

}
