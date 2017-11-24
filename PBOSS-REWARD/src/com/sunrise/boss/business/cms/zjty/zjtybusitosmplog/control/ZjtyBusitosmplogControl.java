/**
* auto-generated code
* Thu Dec 24 16:14:35 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusitosmplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyBusitosmplogControl extends AbstractControl {
    public ZjtyBusitosmplogVO doCreate(ZjtyBusitosmplogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyBusitosmplogVO vo, User user)
        throws Exception;

    public ZjtyBusitosmplogVO doUpdate(ZjtyBusitosmplogVO vo, User user)
        throws Exception;

    public ZjtyBusitosmplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyBusitosmplogListVO params, User user)
        throws Exception;

}
