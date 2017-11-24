/**
* auto-generated code
* Wed Apr 11 11:02:17 CST 2007
*/
package com.sunrise.boss.business.cms.servcent.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentListVO;

import java.io.Serializable;

/**
 * <p>Title: ServcentControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public interface ServcentControl extends AbstractControl {
    public ServcentVO doCreate(ServcentVO vo, User user)
        throws Exception;

    public void doRemove(ServcentVO vo, User user)
        throws Exception;

    public ServcentVO doUpdate(ServcentVO vo, User user)
        throws Exception;

    public ServcentVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ServcentListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryByOprcode(ServcentListVO params, User user)
    	throws Exception;
    
    public boolean doIfOrgcodenull(String adacode, User user) throws Exception;
    
    public void doUpdateOrgcode(String adacode, String orgcode, User user)
		throws Exception;
    
    public String doGetOrgcode(String adacode, User user) throws Exception ;
}
