/**
* auto-generated code
* Sat Nov 28 17:58:40 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnauditlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ExmnauditlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnauditlogControl extends AbstractControl {
    public ExmnauditlogVO doCreate(ExmnauditlogVO vo, User user)
        throws Exception;

    public void doRemove(ExmnauditlogVO vo, User user)
        throws Exception;

    public ExmnauditlogVO doUpdate(ExmnauditlogVO vo, User user)
        throws Exception;

    public ExmnauditlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnauditlogListVO params, User user)
        throws Exception;

}
