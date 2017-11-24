/**
* auto-generated code
* Fri Oct 15 15:43:07 CST 2010
*/
package com.sunrise.boss.business.cms.reward.disintegral.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralVO;
import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralListVO;

import java.io.Serializable;

/**
 * <p>Title: DisintegralControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface DisintegralControl extends AbstractControl {
    public DisintegralVO doCreate(DisintegralVO vo, User user)
        throws Exception;

    public void doRemove(DisintegralVO vo, User user)
        throws Exception;

    public DisintegralVO doUpdate(DisintegralVO vo, User user)
        throws Exception;

    public DisintegralVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DisintegralListVO params, User user)
        throws Exception;

}
