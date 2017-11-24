/**
* auto-generated code
* Wed Sep 04 21:22:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardadc.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdRewardadcControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPdRewardadcControl extends AbstractControl {
    public ChPdRewardadcVO doCreate(ChPdRewardadcVO vo, User user)
        throws Exception;

    public void doRemove(ChPdRewardadcVO vo, User user)
        throws Exception;

    public ChPdRewardadcVO doUpdate(ChPdRewardadcVO vo, User user)
        throws Exception;

    public ChPdRewardadcVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdRewardadcListVO params, User user)
        throws Exception;

}
