/**
* auto-generated code
* Mon Feb 21 20:51:42 CST 2011
*/
package com.sunrise.boss.business.cms.regnewwayemp.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpVO;
import com.sunrise.boss.business.cms.regnewwayemp.persistent.RegNewWayEmpListVO;

import java.io.Serializable;

/**
 * <p>Title: RegNewWayEmpControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface RegNewWayEmpControl extends AbstractControl {
    public RegNewWayEmpVO doCreate(RegNewWayEmpVO vo, User user)
        throws Exception;

    public void doRemove(RegNewWayEmpVO vo, User user)
        throws Exception;

    public RegNewWayEmpVO doUpdate(RegNewWayEmpVO vo, User user)
        throws Exception;

    public RegNewWayEmpVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RegNewWayEmpListVO params, User user)
        throws Exception;

}
