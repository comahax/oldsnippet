/**
* auto-generated code
* Wed Sep 04 20:56:32 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeVO;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeListVO;

import java.io.Serializable;

/**
 * <p>Title: VChPdAccountchargeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface VChPdAccountchargeControl extends AbstractControl {
    public VChPdAccountchargeVO doCreate(VChPdAccountchargeVO vo, User user)
        throws Exception;

    public void doRemove(VChPdAccountchargeVO vo, User user)
        throws Exception;

    public VChPdAccountchargeVO doUpdate(VChPdAccountchargeVO vo, User user)
        throws Exception;

    public VChPdAccountchargeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(VChPdAccountchargeListVO params, User user)
        throws Exception;

}
