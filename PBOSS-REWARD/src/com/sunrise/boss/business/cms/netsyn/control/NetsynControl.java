/**
* auto-generated code
* Tue Jan 08 15:44:14 CST 2008
*/
package com.sunrise.boss.business.cms.netsyn.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynVO;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynListVO;

import java.io.Serializable;

/**
 * <p>Title: NetsynControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public interface NetsynControl extends AbstractControl {
    public NetsynVO doCreate(NetsynVO vo, User user)
        throws Exception;

    public void doRemove(NetsynVO vo, User user)
        throws Exception;

    public NetsynVO doUpdate(NetsynVO vo, User user)
        throws Exception;

    public NetsynVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(NetsynListVO params, User user)
        throws Exception;

}
