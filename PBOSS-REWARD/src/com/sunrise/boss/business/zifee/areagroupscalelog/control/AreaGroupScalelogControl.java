/**
* auto-generated code
* Tue Oct 24 17:04:07 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupscalelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.areagroupscalelog.persistent.AreaGroupScalelogVO;
import com.sunrise.boss.business.zifee.areagroupscalelog.persistent.AreaGroupScalelogListVO;

import java.io.Serializable;

/**
 * <p>Title: AreaGroupScalelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface AreaGroupScalelogControl extends AbstractControl {
    public AreaGroupScalelogVO doCreate(AreaGroupScalelogVO vo, User user)
        throws Exception;

    public void doRemove(AreaGroupScalelogVO vo, User user)
        throws Exception;

    public AreaGroupScalelogVO doUpdate(AreaGroupScalelogVO vo, User user)
        throws Exception;

    public AreaGroupScalelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AreaGroupScalelogListVO params, User user)
        throws Exception;

}
