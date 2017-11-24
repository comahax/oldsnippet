/**
* auto-generated code
* Fri Dec 30 15:15:14 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtystdreward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyStdrewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public interface ZjtyStdrewardControl extends AbstractControl {
    public ZjtyStdrewardVO doCreate(ZjtyStdrewardVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyStdrewardVO vo, User user)
        throws Exception;

    public ZjtyStdrewardVO doUpdate(ZjtyStdrewardVO vo, User user)
        throws Exception;

    public ZjtyStdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyStdrewardListVO params, User user)
        throws Exception;

}
