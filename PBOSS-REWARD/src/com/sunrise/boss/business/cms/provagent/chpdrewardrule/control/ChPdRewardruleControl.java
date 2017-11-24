/**
* auto-generated code
* Wed Sep 04 16:35:49 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrewardrule.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdRewardruleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPdRewardruleControl extends AbstractControl {
    public ChPdRewardruleVO doCreate(ChPdRewardruleVO vo, User user)
        throws Exception;

    public void doRemove(ChPdRewardruleVO vo, User user)
        throws Exception;

    public ChPdRewardruleVO doUpdate(ChPdRewardruleVO vo, User user)
        throws Exception;

    public ChPdRewardruleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdRewardruleListVO params, User user)
        throws Exception;

}
