/**
* auto-generated code
* Wed Aug 29 19:13:31 CST 2012
*/
package com.sunrise.boss.business.cms.vchpwoperation.control;

import com.sunrise.boss.business.cms.vchpwoperation.persistent.VChPwOperationListVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: VChPwOperationControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface VChPwOperationControl extends AbstractControl { 
    public DataPackage doQuery(VChPwOperationListVO params, User user)
       throws Exception;

}
