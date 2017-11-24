/**
* auto-generated code
* Thu Dec 24 14:26:29 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCompcoeflogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyCompcoeflogControl extends AbstractControl {
    public ZjtyCompcoeflogVO doCreate(ZjtyCompcoeflogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyCompcoeflogVO vo, User user)
        throws Exception;

    public ZjtyCompcoeflogVO doUpdate(ZjtyCompcoeflogVO vo, User user)
        throws Exception;

    public ZjtyCompcoeflogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyCompcoeflogListVO params, User user)
        throws Exception;

}
