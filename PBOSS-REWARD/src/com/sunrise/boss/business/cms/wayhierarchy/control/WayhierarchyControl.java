/**
* auto-generated code
* Tue Sep 12 17:06:59 CST 2006
*/
package com.sunrise.boss.business.cms.wayhierarchy.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyVO;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyListVO;

import java.io.Serializable;
import java.rmi.*;

/**
 * <p>Title: WayhierarchyControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WayhierarchyControl extends AbstractControl {
    public WayhierarchyVO doCreate(WayhierarchyVO vo, User user)
        throws  Exception;

    public void doRemove(WayhierarchyVO vo, User user)
        throws  Exception;

    public WayhierarchyVO doUpdate(WayhierarchyVO vo, User user)
        throws  Exception;

    public WayhierarchyVO doFindByPk(Serializable pk, User user)
        throws  Exception;

    public DataPackage doQuery(WayhierarchyListVO params, User user)
        throws  Exception;

	public boolean check(User user)  throws  Exception;

	public void build(User user)  throws  Exception;
	
	public boolean check(String wayid, User user) throws  Exception;
	
	public void build(String wayid, User user) throws  Exception;

}
