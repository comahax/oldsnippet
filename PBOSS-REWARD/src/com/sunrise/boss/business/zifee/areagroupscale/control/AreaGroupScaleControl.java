/**
* auto-generated code
* Mon Aug 21 20:59:07 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupscale.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.zifee.areagroupscale.persistent.AreaGroupScaleVO;
import com.sunrise.boss.business.zifee.areagroupscale.persistent.AreaGroupScaleListVO;
import com.sunrise.boss.ui.commons.User;

import java.io.Serializable;
import java.util.List;


/**
 * <p>Title: AreaGroupScaleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface AreaGroupScaleControl extends AbstractControl {
    public AreaGroupScaleVO doCreate(AreaGroupScaleVO vo, User user)
        throws Exception;

    public AreaGroupScaleVO doUpdate(AreaGroupScaleVO vo, User user)
        throws Exception;

    public AreaGroupScaleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AreaGroupScaleListVO params, User user)
        throws Exception;
    public void doRemoveByVO(AreaGroupScaleVO vo, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, User user) throws Exception;
    public List doFindByGroupid(String groupid, User user) throws Exception;
}
