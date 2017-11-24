/**
* auto-generated code
* Tue Oct 17 17:31:29 CST 2006
*/
package com.sunrise.boss.business.cms.waytypelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogVO;
import com.sunrise.boss.business.cms.waytypelog.persistent.WaytypelogListVO;

import java.io.Serializable;

/**
 * <p>Title: WaytypelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WaytypelogControl extends AbstractControl {
    public WaytypelogVO doCreate(WaytypelogVO vo, User user)
        throws Exception;

    public void doRemove(WaytypelogVO vo, User user)
        throws Exception;

    public WaytypelogVO doUpdate(WaytypelogVO vo, User user)
        throws Exception;

    public WaytypelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaytypelogListVO params, User user)
        throws Exception;

}
