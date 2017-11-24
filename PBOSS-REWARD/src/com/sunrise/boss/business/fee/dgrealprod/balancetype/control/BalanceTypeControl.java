/**
* auto-generated code
* Fri Apr 18 10:45:38 CST 2008
*/
package com.sunrise.boss.business.fee.dgrealprod.balancetype.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent.BalanceTypeVO;
import com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent.BalanceTypeListVO;

import java.io.Serializable;

/**
 * <p>Title: BalanceTypeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
public interface BalanceTypeControl extends AbstractControl {
    public BalanceTypeVO doCreate(BalanceTypeVO vo, User user)
        throws Exception;

    public void doRemove(BalanceTypeVO vo, User user)
        throws Exception;

    public BalanceTypeVO doUpdate(BalanceTypeVO vo, User user)
        throws Exception;

    public BalanceTypeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BalanceTypeListVO params, User user)
        throws Exception;

}
