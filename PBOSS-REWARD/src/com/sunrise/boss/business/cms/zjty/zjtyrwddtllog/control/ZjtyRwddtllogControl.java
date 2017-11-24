/**
* auto-generated code
* Tue Dec 29 15:07:40 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogVO;
import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRwddtllogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyRwddtllogControl extends AbstractControl {
    public ZjtyRwddtllogVO doCreate(ZjtyRwddtllogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyRwddtllogVO vo, User user)
        throws Exception;

    public ZjtyRwddtllogVO doUpdate(ZjtyRwddtllogVO vo, User user)
        throws Exception;

    public ZjtyRwddtllogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyRwddtllogListVO params, User user)
        throws Exception;

}
