/**
* auto-generated code
* Mon Jan 14 11:41:04 CST 2013
*/
package com.sunrise.boss.business.cms.chadtsaleslog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogVO;
import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtSaleslogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface ChAdtSaleslogControl extends AbstractControl {
    public ChAdtSaleslogVO doCreate(ChAdtSaleslogVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtSaleslogVO vo, User user)
        throws Exception;

    public ChAdtSaleslogVO doUpdate(ChAdtSaleslogVO vo, User user)
        throws Exception;

    public ChAdtSaleslogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtSaleslogListVO params, User user)
        throws Exception;

}
