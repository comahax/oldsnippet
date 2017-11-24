/**
* auto-generated code
* Fri May 02 07:02:06 CST 2008
*/
package com.sunrise.boss.business.cms.costcard.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardListVO;

import java.io.Serializable;

/**
 * <p>Title: CostcardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CostcardControl extends AbstractControl {
    public CostcardVO doCreate(CostcardVO vo, User user)
        throws Exception;

    public void doRemove(CostcardVO vo, User user)
        throws Exception;

    public CostcardVO doUpdate(CostcardVO vo, User user)
        throws Exception;

    public CostcardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CostcardListVO params, User user)
        throws Exception;

}
