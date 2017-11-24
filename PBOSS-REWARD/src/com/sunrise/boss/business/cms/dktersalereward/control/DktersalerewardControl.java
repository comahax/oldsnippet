/**
* auto-generated code
* Fri May 03 16:45:00 CST 2013
*/
package com.sunrise.boss.business.cms.dktersalereward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardVO;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardListVO;

import java.io.Serializable;

/**
 * <p>Title: DktersalerewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface DktersalerewardControl extends AbstractControl {
    public DktersalerewardVO doCreate(DktersalerewardVO vo, User user)
        throws Exception;

    public void doRemove(DktersalerewardVO vo, User user)
        throws Exception;

    public DktersalerewardVO doUpdate(DktersalerewardVO vo, User user)
        throws Exception;

    public DktersalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DktersalerewardListVO params, User user)
        throws Exception;

    public DataPackage doQueryRewardTotal(DktersalerewardListVO params, User user)
        throws Exception;

}
