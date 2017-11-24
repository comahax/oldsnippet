/**
* auto-generated code
* Thu Feb 14 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbs.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsListVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsdVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: StdrewardbsControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */ 
public interface StdrewardbsControl extends AbstractControl {
    public StdrewardVO doCreate(StdrewardVO vo,List list,User user)
        throws Exception;

    public void doRemove(StdrewardVO vo,User user)
        throws Exception;

    public StdrewardVO doUpdate(StdrewardVO vo,List list,User user)
        throws Exception;
    
    public StdrewardbsdVO doUpdatestar(StdrewardbsdVO vo,User user)
    throws Exception;

    public StdrewardbsdVO doFindByPk(Serializable pk, User user)
        throws Exception;
    
    public StdrewardbsdVO doFindByPkcity(Serializable pk, User user)
    throws Exception;
    
    public StdrewardbsVO doCheck(Serializable pk, User user)
    throws Exception;
    
    public DataPackage doQuery(StdrewardbsListVO params, User user)
        throws Exception;
    
}
