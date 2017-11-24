/**
* auto-generated code
* Fri Oct 15 15:45:05 CST 2010
*/
package com.sunrise.boss.business.cms.reward.disintegrallog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogVO;
import com.sunrise.boss.business.cms.reward.disintegrallog.persistent.DisintegrallogListVO;

import java.io.Serializable;

/**
 * <p>Title: DisintegrallogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface DisintegrallogControl extends AbstractControl {
    public DisintegrallogVO doCreate(DisintegrallogVO vo, User user)
        throws Exception;

    public void doRemove(DisintegrallogVO vo, User user)
        throws Exception;

    public DisintegrallogVO doUpdate(DisintegrallogVO vo, User user)
        throws Exception;

    public DisintegrallogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DisintegrallogListVO params, User user)
        throws Exception;

}
