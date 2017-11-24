/**
* auto-generated code
* Fri Apr 18 17:02:15 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleonbusi.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiVO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleonbusiControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public interface RuleonbusiControl extends AbstractControl {
    public RuleonbusiVO doCreate(RuleonbusiVO vo, User user)
        throws Exception;

    public void doRemove(RuleonbusiVO vo, User user)
        throws Exception;

    public RuleonbusiVO doUpdate(RuleonbusiVO vo, User user)
        throws Exception;

    public RuleonbusiVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RuleonbusiListVO params, User user)
        throws Exception;
    
    public DataPackage doQuery1(RuleonbusiListVO params, User user)
    throws Exception;

}
