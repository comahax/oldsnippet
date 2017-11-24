/**
* auto-generated code
* Sat May 11 16:40:18 CST 2013
*/
package com.sunrise.boss.business.cms.chzdplatforminfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoVO;
import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZdPlatforminfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface ChZdPlatforminfoControl extends AbstractControl {
    public ChZdPlatforminfoVO doCreate(ChZdPlatforminfoVO vo, User user)
        throws Exception;

    public void doRemove(ChZdPlatforminfoVO vo, User user)
        throws Exception;

    public ChZdPlatforminfoVO doUpdate(ChZdPlatforminfoVO vo, User user)
        throws Exception;

    public ChZdPlatforminfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZdPlatforminfoListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryForZdplatform(ChZdPlatforminfoListVO params, User user)
    throws Exception;
    
    public DataPackage doQueryForProducttype(ChZdPlatforminfoListVO params, User user)
    throws Exception;

}
