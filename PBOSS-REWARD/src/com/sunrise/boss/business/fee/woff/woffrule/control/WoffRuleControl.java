/**
* auto-generated code
* Fri Aug 11 09:34:48 CST 2006
*/
package com.sunrise.boss.business.fee.woff.woffrule.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.woff.woffrule.persistent.WoffRuleListVO;
import com.sunrise.boss.business.fee.woff.woffrule.persistent.WoffRuleVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: IbRuWoffruleVoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public interface WoffRuleControl extends AbstractControl {
    public WoffRuleVO doCreate(WoffRuleVO vo, User user)
        throws Exception;

    public void doRemove(WoffRuleVO vo, User user)
        throws Exception;

    public WoffRuleVO doUpdate(WoffRuleVO vo, User user)
        throws Exception;

    public WoffRuleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WoffRuleListVO params, User user)
        throws Exception;

}
