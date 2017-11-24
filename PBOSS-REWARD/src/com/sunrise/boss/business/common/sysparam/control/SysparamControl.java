package com.sunrise.boss.business.common.sysparam.control;

/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/

import java.io.Serializable;

import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: SysparamControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public interface SysparamControl extends AbstractControl {
    public SysparamVO doCreate(SysparamVO vo, User user)
        throws Exception;

    public void doRemove(SysparamVO vo, User user)
        throws Exception;

    public SysparamVO doUpdate(SysparamVO vo, User user)
        throws Exception;
    
    public SysparamVO doUpdate2(SysparamVO vo, User user)
    	throws Exception;

    public SysparamVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SysparamListVO params, User user)
        throws Exception;

    public String doFindByID(Long systemid, String paramtype, User user)
    throws Exception;    
}
