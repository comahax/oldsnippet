/**
* auto-generated code
* Thu Oct 23 12:58:00 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyoperationlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyOperationlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyOperationlogControl extends AbstractControl {
    public ZjtyOperationlogVO doCreate(ZjtyOperationlogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyOperationlogVO vo, User user)
        throws Exception;

    public ZjtyOperationlogVO doUpdate(ZjtyOperationlogVO vo, User user)
        throws Exception;

    public ZjtyOperationlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyOperationlogListVO params, User user)
        throws Exception;

}
