/**
* auto-generated code
* Tue Dec 20 12:00:28 CST 2011
*/
package com.sunrise.boss.business.cms.chadtbusitoapprove.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveVO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtBusitoapproveControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface ChAdtBusitoapproveControl extends AbstractControl {
    public ChAdtBusitoapproveVO doCreate(ChAdtBusitoapproveVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtBusitoapproveVO vo, User user)
        throws Exception;

    public ChAdtBusitoapproveVO doUpdate(ChAdtBusitoapproveVO vo, User user)
        throws Exception;

    public ChAdtBusitoapproveVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtBusitoapproveListVO params, User user)
        throws Exception;

}
