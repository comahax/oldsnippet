/**
* auto-generated code
* Mon Jan 04 11:40:46 CST 2010
*/
package com.sunrise.boss.business.cms.reward.busitosmp.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpVO;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpListVO;

import java.io.Serializable;

/**
 * <p>Title: BusitosmpControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface BusitosmpControl extends AbstractControl {
    public BusitosmpVO doCreate(BusitosmpVO vo, User user)
        throws Exception;

    public void doRemove(BusitosmpVO vo, User user)
        throws Exception;

    public BusitosmpVO doUpdate(BusitosmpVO vo, User user)
        throws Exception;

    public BusitosmpVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusitosmpListVO params, User user)
        throws Exception;

}
