/**
* auto-generated code
* Mon Aug 21 16:04:22 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupinfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.zifee.areagroupinfo.persistent.AreaGroupInfoVO;
import com.sunrise.boss.business.zifee.areagroupinfo.persistent.AreaGroupInfoListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;


/**
 * <p>Title: AreaGroupInfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface AreaGroupInfoControl extends AbstractControl {
    public AreaGroupInfoVO doCreate(AreaGroupInfoVO vo, User user)
        throws Exception;

    public AreaGroupInfoVO doUpdate(AreaGroupInfoVO vo, User user)
        throws Exception;

    public AreaGroupInfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AreaGroupInfoListVO params, User user)
        throws Exception;
    
    public void doRemoveByVO(AreaGroupInfoVO vo, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, User user) throws Exception;

}
