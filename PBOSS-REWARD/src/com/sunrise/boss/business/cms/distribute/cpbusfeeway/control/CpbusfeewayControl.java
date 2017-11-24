/**
* auto-generated code
* Wed Dec 27 14:04:18 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cpbusfeeway.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent.CpbusfeewayVO;
import com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent.CpbusfeewayListVO;

import java.io.Serializable;

/**
 * <p>Title: CpbusfeewayControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface CpbusfeewayControl extends AbstractControl {
    public CpbusfeewayVO doCreate(CpbusfeewayVO vo, User user)
        throws Exception;

    public void doRemove(CpbusfeewayVO vo, User user)
        throws Exception;

    public CpbusfeewayVO doUpdate(CpbusfeewayVO vo, User user)
        throws Exception;

    public CpbusfeewayVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CpbusfeewayListVO params, User user)
        throws Exception;

}
