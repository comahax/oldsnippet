/**
* auto-generated code
* Tue Jul 07 16:26:52 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyddtreward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyDdtrewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyDdtrewardControl extends AbstractControl {
    public ZjtyDdtrewardVO doCreate(ZjtyDdtrewardVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyDdtrewardVO vo, User user)
        throws Exception;

    public ZjtyDdtrewardVO doUpdate(ZjtyDdtrewardVO vo, User user)
        throws Exception;

    public ZjtyDdtrewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyDdtrewardListVO params, User user)
        throws Exception;

}
