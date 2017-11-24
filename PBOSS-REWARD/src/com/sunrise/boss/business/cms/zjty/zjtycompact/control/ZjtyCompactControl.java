/**
* auto-generated code
* Wed Dec 28 14:39:42 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtycompact.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCompactControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public interface ZjtyCompactControl extends AbstractControl {
    public ZjtyCompactVO doCreate(ZjtyCompactVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyCompactVO vo, User user)
        throws Exception;

    public ZjtyCompactVO doUpdate(ZjtyCompactVO vo, User user)
        throws Exception;

    public ZjtyCompactVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyCompactListVO params, User user)
        throws Exception;

}
