/**
* auto-generated code
* Sun Nov 29 14:17:13 CST 2009
*/
package com.sunrise.boss.business.cms.examine.coefrevisionlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogVO;
import com.sunrise.boss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CoefrevisionlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CoefrevisionlogControl extends AbstractControl {
    public CoefrevisionlogVO doCreate(CoefrevisionlogVO vo, User user)
        throws Exception;

    public void doRemove(CoefrevisionlogVO vo, User user)
        throws Exception;

    public CoefrevisionlogVO doUpdate(CoefrevisionlogVO vo, User user)
        throws Exception;

    public CoefrevisionlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CoefrevisionlogListVO params, User user)
        throws Exception;

}
