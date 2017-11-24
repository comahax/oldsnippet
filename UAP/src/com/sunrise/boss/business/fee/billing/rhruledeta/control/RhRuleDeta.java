/**
* auto-generated code
* Tue Mar 18 11:36:17 CST 2008
*/
package com.sunrise.boss.business.fee.billing.rhruledeta.control;


import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaDBParam;
import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaVO;

import com.sunrise.jop.ui.User;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

import java.io.Serializable;

/**
 * <p>Title: RhRuleDetaControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public interface RhRuleDeta extends AbstractControl {
	
    public RhRuleDetaVO doCreate(RhRuleDetaVO vo, User user)
        throws Exception;

    public void doRemove(RhRuleDetaVO vo, User user)
        throws Exception;

    public RhRuleDetaVO doUpdate(RhRuleDetaVO vo, User user)
        throws Exception;

    public RhRuleDetaVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RhRuleDetaDBParam params, User user)
        throws Exception;

}
