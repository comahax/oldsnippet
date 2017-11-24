/**
* auto-generated code
* Tue Feb 28 17:21:47 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public interface ZjtyRewardrecordControl extends AbstractControl {
    public ZjtyRewardrecordVO doCreate(ZjtyRewardrecordVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyRewardrecordVO vo, User user)
        throws Exception;

    public ZjtyRewardrecordVO doUpdate(ZjtyRewardrecordVO vo, User user)
        throws Exception;

    public ZjtyRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyRewardrecordListVO params, User user)
        throws Exception;

}
