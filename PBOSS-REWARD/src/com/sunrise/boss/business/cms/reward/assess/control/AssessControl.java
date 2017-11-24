/**
* auto-generated code
* Sat Jun 25 17:13:50 CST 2011
*/
package com.sunrise.boss.business.cms.reward.assess.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessListVO;

import java.io.Serializable;

/**
 * <p>Title: AssessControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface AssessControl extends AbstractControl {
    public AssessVO doCreate(AssessVO vo, User user)
        throws Exception;

    public void doRemove(AssessVO vo, User user)
        throws Exception;

    public AssessVO doUpdate(AssessVO vo, User user)
        throws Exception;

    public AssessVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AssessListVO params, User user)
        throws Exception;

}
