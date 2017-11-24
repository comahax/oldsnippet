/**
* auto-generated code
* Fri Jul 08 11:36:28 CST 2011
*/
package com.sunrise.boss.business.cms.waystrarewardstd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdListVO;

import java.io.Serializable;

/**
 * <p>Title: WaystrarewardstdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface WaystrarewardstdControl extends AbstractControl {
    public WaystrarewardstdVO doCreate(WaystrarewardstdVO vo, User user)
        throws Exception;

    public void doRemove(WaystrarewardstdVO vo, User user)
        throws Exception;

    public WaystrarewardstdVO doUpdate(WaystrarewardstdVO vo, User user)
        throws Exception;

    public WaystrarewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaystrarewardstdListVO params, User user)
        throws Exception;

}
