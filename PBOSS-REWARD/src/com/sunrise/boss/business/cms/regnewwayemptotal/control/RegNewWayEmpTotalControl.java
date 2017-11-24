/**
* auto-generated code
* Thu Feb 24 15:31:21 CST 2011
*/
package com.sunrise.boss.business.cms.regnewwayemptotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalVO;
import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalListVO;

import java.io.Serializable;

/**
 * <p>Title: RegNewWayEmpTotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface RegNewWayEmpTotalControl extends AbstractControl {
    public RegNewWayEmpTotalVO doCreate(RegNewWayEmpTotalVO vo, User user)
        throws Exception;

    public void doRemove(RegNewWayEmpTotalVO vo, User user)
        throws Exception;

    public RegNewWayEmpTotalVO doUpdate(RegNewWayEmpTotalVO vo, User user)
        throws Exception;

    public RegNewWayEmpTotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RegNewWayEmpTotalListVO params, User user)
        throws Exception;

}
