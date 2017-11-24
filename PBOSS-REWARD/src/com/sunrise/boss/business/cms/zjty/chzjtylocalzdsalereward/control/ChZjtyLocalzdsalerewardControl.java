/**
* auto-generated code
* Sat Mar 09 12:12:34 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalzdsalerewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChZjtyLocalzdsalerewardControl extends AbstractControl {
    public ChZjtyLocalzdsalerewardVO doCreate(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception;

    public ChZjtyLocalzdsalerewardVO doUpdate(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception;

    public ChZjtyLocalzdsalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyLocalzdsalerewardListVO params, User user)
        throws Exception;

    public DataPackage doQueryTotal(ChZjtyLocalzdsalerewardListVO params, User user)
        throws Exception;
}
