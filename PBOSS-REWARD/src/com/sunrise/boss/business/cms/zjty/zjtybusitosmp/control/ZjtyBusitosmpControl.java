/**
* auto-generated code
* Thu Dec 24 16:13:49 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusitosmp.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusitosmpControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyBusitosmpControl extends AbstractControl {
    public ZjtyBusitosmpVO doCreate(ZjtyBusitosmpVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyBusitosmpVO vo, User user)
        throws Exception;

    public ZjtyBusitosmpVO doUpdate(ZjtyBusitosmpVO vo, User user)
        throws Exception;

    public ZjtyBusitosmpVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyBusitosmpListVO params, User user)
        throws Exception;

}
