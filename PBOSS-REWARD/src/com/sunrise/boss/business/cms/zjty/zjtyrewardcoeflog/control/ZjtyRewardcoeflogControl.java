/**
* auto-generated code
* Sat Dec 27 10:22:09 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRewardcoeflogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyRewardcoeflogControl extends AbstractControl {
    public ZjtyRewardcoeflogVO doCreate(ZjtyRewardcoeflogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyRewardcoeflogVO vo, User user)
        throws Exception;

    public ZjtyRewardcoeflogVO doUpdate(ZjtyRewardcoeflogVO vo, User user)
        throws Exception;

    public ZjtyRewardcoeflogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyRewardcoeflogListVO params, User user)
        throws Exception;

}
