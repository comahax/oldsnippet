/**
* auto-generated code
* Wed Feb 29 11:21:27 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.zjtyfailrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordVO;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyFailrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public interface ZjtyFailrecordControl extends AbstractControl {
    public ZjtyFailrecordVO doCreate(ZjtyFailrecordVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyFailrecordVO vo, User user)
        throws Exception;

    public ZjtyFailrecordVO doUpdate(ZjtyFailrecordVO vo, User user)
        throws Exception;

    public ZjtyFailrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyFailrecordListVO params, User user)
        throws Exception;

}
