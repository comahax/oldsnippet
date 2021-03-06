/**
* auto-generated code
* Sat Aug 26 11:33:48 CST 2006
*/
package com.sunrise.boss.business.cms.wayagentbch.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchVO;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchListVO;

import java.io.Serializable;

/**
 * <p>Title: WayagentbchControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WayagentbchControl extends AbstractControl {
    public WayagentbchVO doCreate(WayagentbchVO vo, User user)
        throws Exception;

    public void doRemove(WayagentbchVO vo, User user)
        throws Exception;

    public WayagentbchVO doUpdate(WayagentbchVO vo, User user)
        throws Exception;

    public WayagentbchVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WayagentbchListVO params, User user)
        throws Exception;
    public DataPackage getByBchtype(String bchtype, User user)
    throws Exception ;
}
