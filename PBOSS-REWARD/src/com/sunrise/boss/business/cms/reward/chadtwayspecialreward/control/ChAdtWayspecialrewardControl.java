/**
* auto-generated code
* Sat Nov 16 10:49:38 CST 2013
*/
package com.sunrise.boss.business.cms.reward.chadtwayspecialreward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardVO;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtWayspecialrewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface ChAdtWayspecialrewardControl extends AbstractControl {
    public ChAdtWayspecialrewardVO doCreate(ChAdtWayspecialrewardVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtWayspecialrewardVO vo, User user)
        throws Exception;

    public ChAdtWayspecialrewardVO doUpdate(ChAdtWayspecialrewardVO vo, User user)
        throws Exception;

    public ChAdtWayspecialrewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtWayspecialrewardListVO params, User user)
        throws Exception;

}
