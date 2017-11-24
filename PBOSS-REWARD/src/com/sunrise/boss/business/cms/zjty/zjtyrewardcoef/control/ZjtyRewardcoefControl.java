/**
* auto-generated code
* Fri Oct 24 09:17:11 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRewardcoefControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyRewardcoefControl extends AbstractControl {
    public ZjtyRewardcoefVO doSave(ZjtyRewardcoefVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyRewardcoefVO vo, User user)
        throws Exception;

    public ZjtyRewardcoefVO doUpdate(ZjtyRewardcoefVO vo, User user)
        throws Exception;

    public ZjtyRewardcoefVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyRewardcoefListVO params, User user)
        throws Exception;

}
