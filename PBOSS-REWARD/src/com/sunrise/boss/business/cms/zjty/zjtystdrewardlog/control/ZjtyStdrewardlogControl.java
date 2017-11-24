/**
* auto-generated code
* Tue Oct 28 11:33:15 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent.ZjtyStdrewardlogVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardlog.persistent.ZjtyStdrewardlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyStdrewardlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyStdrewardlogControl extends AbstractControl {
    public ZjtyStdrewardlogVO doCreate(ZjtyStdrewardlogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyStdrewardlogVO vo, User user)
        throws Exception;

    public ZjtyStdrewardlogVO doUpdate(ZjtyStdrewardlogVO vo, User user)
        throws Exception;

    public ZjtyStdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyStdrewardlogListVO params, User user)
        throws Exception;

}
