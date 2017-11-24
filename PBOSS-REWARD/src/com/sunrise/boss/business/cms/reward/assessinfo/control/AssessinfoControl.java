/**
* auto-generated code
* Thu Dec 01 14:14:15 CST 2011
*/
package com.sunrise.boss.business.cms.reward.assessinfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoListVO;

import java.io.Serializable;

/**
 * <p>Title: AssessinfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface AssessinfoControl extends AbstractControl {
    public AssessinfoVO doCreate(AssessinfoVO vo, User user)
        throws Exception;

    public void doRemove(AssessinfoVO vo, User user)
        throws Exception;

    public AssessinfoVO doUpdate(AssessinfoVO vo, User user)
        throws Exception;

    public AssessinfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AssessinfoListVO params, User user)
        throws Exception;

}
