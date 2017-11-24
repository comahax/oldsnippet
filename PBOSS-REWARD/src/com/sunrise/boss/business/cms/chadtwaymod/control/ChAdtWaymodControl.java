/**
* auto-generated code
* Sat Jan 12 10:23:04 CST 2013
*/
package com.sunrise.boss.business.cms.chadtwaymod.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodVO;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtWaymodControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChAdtWaymodControl extends AbstractControl {
    public ChAdtWaymodVO doCreate(ChAdtWaymodVO vo, User user) throws Exception;

    public void doRemove(ChAdtWaymodVO vo, User user) throws Exception;

    public ChAdtWaymodVO doUpdate(ChAdtWaymodVO vo, User user) throws Exception;

    public ChAdtWaymodVO doFindByPk(Serializable pk, User user) throws Exception;

    public DataPackage doQuery(ChAdtWaymodListVO params, User user) throws Exception;

}
