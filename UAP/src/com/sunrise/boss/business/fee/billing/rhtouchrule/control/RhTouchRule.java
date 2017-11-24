/**
* auto-generated code
* Thu Mar 20 15:48:33 CST 2008
*/
package com.sunrise.boss.business.fee.billing.rhtouchrule.control;



import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.fee.billing.rhtouchrule.persistent.ResultVO;
import com.sunrise.boss.business.fee.billing.rhtouchrule.persistent.RhTouchRuleDBParam;
import com.sunrise.boss.business.fee.billing.rhtouchrule.persistent.RhTouchRuleVO;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RhTouchRuleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public interface RhTouchRule extends AbstractControl {
	
    public RhTouchRuleVO doCreate(RhTouchRuleVO vo, User user)
        throws Exception;

    public void doRemove(RhTouchRuleVO vo, User user)
        throws Exception;

    public RhTouchRuleVO doUpdate(RhTouchRuleVO vo, User user)
        throws Exception;

    public RhTouchRuleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RhTouchRuleDBParam params, User user)
        throws Exception;

    public String[] doShow(RhTouchRuleDBParam params, User user);
    
     public List doCity(RhTouchRuleDBParam params);
     
     public ResultVO getFlResu(RhTouchRuleDBParam params,User user);
}
