/**
* auto-generated code
* Sat Aug 26 11:34:28 CST 2006
*/
package com.sunrise.boss.business.cms.wayentitybch.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchVO;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchListVO;

import java.io.Serializable;

/**
 * <p>Title: WayentitybchControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WayentitybchControl extends AbstractControl {
    public WayentitybchVO doCreate(WayentitybchVO vo, User user)
        throws Exception;

    public void doRemove(WayentitybchVO vo, User user)
        throws Exception;

    public WayentitybchVO doUpdate(WayentitybchVO vo, User user)
        throws Exception;

    public WayentitybchVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WayentitybchListVO params, User user)
        throws Exception;
    public DataPackage getByBchtype(String bchtype, User user)
        throws Exception;
}
