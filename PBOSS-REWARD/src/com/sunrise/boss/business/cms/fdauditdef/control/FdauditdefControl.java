/**
* auto-generated code
* Thu Jul 26 17:37:14 CST 2007
*/
package com.sunrise.boss.business.cms.fdauditdef.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;

import java.io.Serializable;

/**
 * <p>Title: FdauditdefControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface FdauditdefControl extends AbstractControl {
    public FdauditdefVO doCreate(FdauditdefVO vo, User user)
        throws Exception;

    public void doRemove(FdauditdefVO vo, User user)
        throws Exception;

    public FdauditdefVO doUpdate(FdauditdefVO vo, User user)
        throws Exception;

    public FdauditdefVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FdauditdefListVO params, User user)
        throws Exception;
    
    public DataPackage queryAuditFields(String tablename,String typename,User user)
        throws Exception;
    
    public DataPackage queryAuditFields(String typename,User user)
        throws Exception;
    public DataPackage queryBySQLname(String typename,User user)
    throws Exception;
    
    public DataPackage queryTypes(User user) throws Exception ;
}
