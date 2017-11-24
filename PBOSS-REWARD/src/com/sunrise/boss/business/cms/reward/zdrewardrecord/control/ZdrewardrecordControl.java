/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.business.cms.reward.zdrewardrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: ZdrewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ZdrewardrecordControl extends AbstractControl {
    public ZdrewardrecordVO doCreate(ZdrewardrecordVO vo, User user)
        throws Exception;

    public void doRemove(ZdrewardrecordVO vo, User user)
        throws Exception;

    public ZdrewardrecordVO doUpdate(ZdrewardrecordVO vo, User user)
        throws Exception;

    public ZdrewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZdrewardrecordListVO params, User user)
        throws Exception;

}
