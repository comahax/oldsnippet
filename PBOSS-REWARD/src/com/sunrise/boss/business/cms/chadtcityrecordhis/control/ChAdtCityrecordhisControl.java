/**
* auto-generated code
* Mon Sep 03 20:43:09 CST 2012
*/
package com.sunrise.boss.business.cms.chadtcityrecordhis.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisVO;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtCityrecordhisControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChAdtCityrecordhisControl extends AbstractControl {
    public ChAdtCityrecordhisVO doCreate(ChAdtCityrecordhisVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtCityrecordhisVO vo, User user)
        throws Exception;

    public ChAdtCityrecordhisVO doUpdate(ChAdtCityrecordhisVO vo, User user)
        throws Exception;

    public ChAdtCityrecordhisVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtCityrecordhisListVO params, User user)
        throws Exception;

}
