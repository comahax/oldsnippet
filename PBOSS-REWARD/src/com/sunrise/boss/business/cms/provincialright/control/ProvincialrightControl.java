/**
* auto-generated code
* Sat Jul 29 16:54:43 CST 2006
*/
package com.sunrise.boss.business.cms.provincialright.control;

import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CompanyControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ProvincialrightControl extends AbstractControl {
    
    public boolean checkPurview(User user,String PurviewId) throws Exception;
    
    public DataPackage doQuery(ProvincialrightListVO params, User user)
	throws Exception;
}
