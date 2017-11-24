/**
* auto-generated code
* Thu Aug 24 11:07:55 CST 2006
*/
package com.sunrise.boss.business.cms.areacenter.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterVO;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterListVO;

import java.io.Serializable;

/**
 * <p>Title: AreacenterControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface AreacenterControl extends AbstractControl {
    public AreacenterVO doCreate(AreacenterVO vo, User user)
        throws Exception;

    public void doRemove(AreacenterVO vo, User user)
        throws Exception;

    public AreacenterVO doUpdate(AreacenterVO vo, User user)
        throws Exception;

    public AreacenterVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AreacenterListVO params, User user)
        throws Exception;

	public DataPackage getCenters(User user) throws Exception;

}
