/**
* auto-generated code
* Tue Jun 03 20:21:31 CST 2014
*/
package com.sunrise.boss.business.cms.reward.chadtbaseprodid.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidVO;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtBaseprodidControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChAdtBaseprodidControl extends AbstractControl {
    public ChAdtBaseprodidVO doCreate(ChAdtBaseprodidVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtBaseprodidVO vo, User user)
        throws Exception;

    public ChAdtBaseprodidVO doUpdate(ChAdtBaseprodidVO vo, User user)
        throws Exception;

    public ChAdtBaseprodidVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtBaseprodidListVO params, User user)
        throws Exception;

}
