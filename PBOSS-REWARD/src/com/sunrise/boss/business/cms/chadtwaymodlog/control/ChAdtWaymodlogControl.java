/**
* auto-generated code
* Fri Jan 11 10:41:27 CST 2013
*/
package com.sunrise.boss.business.cms.chadtwaymodlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogVO;
import com.sunrise.boss.business.cms.chadtwaymodlog.persistent.ChAdtWaymodlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtWaymodlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChAdtWaymodlogControl extends AbstractControl {
    public ChAdtWaymodlogVO doCreate(ChAdtWaymodlogVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtWaymodlogVO vo, User user)
        throws Exception;

    public ChAdtWaymodlogVO doUpdate(ChAdtWaymodlogVO vo, User user)
        throws Exception;

    public ChAdtWaymodlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtWaymodlogListVO params, User user)
        throws Exception;

}
