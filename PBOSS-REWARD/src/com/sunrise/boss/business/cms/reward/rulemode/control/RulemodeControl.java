/**
* auto-generated code
* Tue Jul 14 09:24:12 CST 2009
*/
package com.sunrise.boss.business.cms.reward.rulemode.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeVO;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeListVO;

import java.io.Serializable;

/**
 * <p>Title: RulemodeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface RulemodeControl extends AbstractControl {
    public RulemodeVO doCreate(RulemodeVO vo, User user)
        throws Exception;

    public void doRemove(RulemodeVO vo, User user)
        throws Exception;

    public RulemodeVO doUpdate(RulemodeVO vo, User user)
        throws Exception;

    public RulemodeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RulemodeListVO params, User user)
        throws Exception;

}
