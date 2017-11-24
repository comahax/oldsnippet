/**
* auto-generated code
* Thu Dec 24 14:22:12 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtycompcoef.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCompcoefControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyCompcoefControl extends AbstractControl {
    public ZjtyCompcoefVO doCreate(ZjtyCompcoefVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyCompcoefVO vo, User user)
        throws Exception;

    public ZjtyCompcoefVO doUpdate(ZjtyCompcoefVO vo, User user)
        throws Exception;

    public ZjtyCompcoefVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyCompcoefListVO params, User user)
        throws Exception;

}
