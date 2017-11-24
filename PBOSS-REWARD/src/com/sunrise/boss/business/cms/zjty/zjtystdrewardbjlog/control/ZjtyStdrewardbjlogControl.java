/**
* auto-generated code
* Tue Oct 28 11:36:29 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyStdrewardbjlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyStdrewardbjlogControl extends AbstractControl {
    public ZjtyStdrewardbjlogVO doCreate(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception;

    public ZjtyStdrewardbjlogVO doUpdate(ZjtyStdrewardbjlogVO vo, User user)
        throws Exception;

    public ZjtyStdrewardbjlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyStdrewardbjlogListVO params, User user)
        throws Exception;

}
