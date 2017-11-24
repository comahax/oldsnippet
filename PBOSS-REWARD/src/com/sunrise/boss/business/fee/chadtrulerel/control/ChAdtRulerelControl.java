/**
* auto-generated code
* Wed Feb 06 14:54:24 CST 2013
*/
package com.sunrise.boss.business.fee.chadtrulerel.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelVO;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtRulerelControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public interface ChAdtRulerelControl extends AbstractControl {
    public ChAdtRulerelVO doCreate(ChAdtRulerelVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtRulerelVO vo, User user)
        throws Exception;

    public ChAdtRulerelVO doUpdate(ChAdtRulerelVO vo, User user)
        throws Exception;

    public ChAdtRulerelVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtRulerelListVO params, User user)
        throws Exception;

}
