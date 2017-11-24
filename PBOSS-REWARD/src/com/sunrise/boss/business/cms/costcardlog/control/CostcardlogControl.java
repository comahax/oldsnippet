/**
* auto-generated code
* Fri May 02 07:00:08 CST 2008
*/
package com.sunrise.boss.business.cms.costcardlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogVO;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CostcardlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CostcardlogControl extends AbstractControl {
    public CostcardlogVO doCreate(CostcardlogVO vo, User user)
        throws Exception;

    public void doRemove(CostcardlogVO vo, User user)
        throws Exception;

    public CostcardlogVO doUpdate(CostcardlogVO vo, User user)
        throws Exception;

    public CostcardlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CostcardlogListVO params, User user)
        throws Exception;

}
