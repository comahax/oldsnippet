/**
* auto-generated code
* Sat Jul 29 16:54:43 CST 2006
*/
package com.sunrise.boss.business.admin.purview.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.purview.persistent.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: CompanyControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface PurviewControl extends AbstractControl {
    
    public boolean checkPurview(String operId,String PurviewId) throws Exception;
}
