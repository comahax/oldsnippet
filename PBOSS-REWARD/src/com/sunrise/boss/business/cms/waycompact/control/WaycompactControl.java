/**
* auto-generated code
* Fri Aug 25 11:29:29 CST 2006
*/
package com.sunrise.boss.business.cms.waycompact.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactListVO;

import java.io.Serializable;

/**
 * <p>Title: WaycompactControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface WaycompactControl extends AbstractControl {
    public WaycompactVO doCreate(WaycompactVO vo, User user)
        throws Exception;

    public void doRemove(WaycompactVO vo, User user)
        throws Exception;

    public WaycompactVO doUpdate(WaycompactVO vo, User user)
        throws Exception;

    public WaycompactVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaycompactListVO params, User user)
        throws Exception;
    public DataPackage queryByOprcodeAndType(WaycompactListVO params, User user)
	throws Exception;
}
