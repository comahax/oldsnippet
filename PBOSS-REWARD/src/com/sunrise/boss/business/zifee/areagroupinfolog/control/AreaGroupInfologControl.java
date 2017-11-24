/**
* auto-generated code
* Tue Oct 24 16:57:25 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupinfolog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.areagroupinfolog.persistent.AreaGroupInfologVO;
import com.sunrise.boss.business.zifee.areagroupinfolog.persistent.AreaGroupInfologListVO;

import java.io.Serializable;

/**
 * <p>Title: AreaGroupInfologControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface AreaGroupInfologControl extends AbstractControl {
    public AreaGroupInfologVO doCreate(AreaGroupInfologVO vo, User user)
        throws Exception;

    public void doRemove(AreaGroupInfologVO vo, User user)
        throws Exception;

    public AreaGroupInfologVO doUpdate(AreaGroupInfologVO vo, User user)
        throws Exception;

    public AreaGroupInfologVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AreaGroupInfologListVO params, User user)
        throws Exception;

}
