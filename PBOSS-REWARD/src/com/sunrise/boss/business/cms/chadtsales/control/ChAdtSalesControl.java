/**
* auto-generated code
* Mon Jan 14 14:13:06 CST 2013
*/
package com.sunrise.boss.business.cms.chadtsales.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesVO;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtSalesControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface ChAdtSalesControl extends AbstractControl {
    public ChAdtSalesVO doCreate(ChAdtSalesVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtSalesVO vo, User user)
        throws Exception;

    public ChAdtSalesVO doUpdate(ChAdtSalesVO vo, User user)
        throws Exception;

    public ChAdtSalesVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtSalesListVO params, User user)
        throws Exception;

}
