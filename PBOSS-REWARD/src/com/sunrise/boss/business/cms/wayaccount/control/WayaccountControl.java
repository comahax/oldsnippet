/**
* auto-generated code
* Sat Aug 26 10:44:13 CST 2006
*/
package com.sunrise.boss.business.cms.wayaccount.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;

import java.io.Serializable;

/**
 * <p>Title: WayaccountControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface WayaccountControl extends AbstractControl {
    public WayaccountVO doCreate(WayaccountVO vo, User user)
        throws Exception;

    public void doRemove(WayaccountVO vo, User user)
        throws Exception;

    public WayaccountVO doUpdate(WayaccountVO vo, User user)
        throws Exception;

    public WayaccountVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WayaccountListVO params, User user)
        throws Exception;

    public DataPackage queryByOprcodeAndType(WayaccountListVO params, User user)
	throws Exception ;
}
