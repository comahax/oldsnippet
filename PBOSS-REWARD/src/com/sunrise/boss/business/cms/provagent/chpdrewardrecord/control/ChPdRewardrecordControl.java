/**
* auto-generated code
* Wed Sep 04 21:04:55 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdRewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPdRewardrecordControl extends AbstractControl {
    public ChPdRewardrecordVO doCreate(ChPdRewardrecordVO vo, User user)
        throws Exception;

    public void doRemove(ChPdRewardrecordVO vo, User user)
        throws Exception;

    public ChPdRewardrecordVO doUpdate(ChPdRewardrecordVO vo, User user)
        throws Exception;

    public ChPdRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdRewardrecordListVO params, User user)
        throws Exception;

}
