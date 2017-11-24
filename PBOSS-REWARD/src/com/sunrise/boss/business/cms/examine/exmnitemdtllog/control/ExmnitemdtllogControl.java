/**
* auto-generated code
* Wed Nov 25 11:17:17 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemdtllog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogListVO;

import java.io.Serializable;

/**
 * <p>Title: ExmnitemdtllogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnitemdtllogControl extends AbstractControl {
    public ExmnitemdtllogVO doCreate(ExmnitemdtllogVO vo, User user)
        throws Exception;

    public void doRemove(ExmnitemdtllogVO vo, User user)
        throws Exception;

    public ExmnitemdtllogVO doUpdate(ExmnitemdtllogVO vo, User user)
        throws Exception;

    public ExmnitemdtllogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnitemdtllogListVO params, User user)
        throws Exception;

}
