/**
* auto-generated code
* Sun Nov 29 14:16:41 CST 2009
*/
package com.sunrise.boss.business.cms.examine.coefrevision.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionVO;
import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionListVO;

import java.io.Serializable;

/**
 * <p>Title: CoefrevisionControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CoefrevisionControl extends AbstractControl {
    public CoefrevisionVO doCreate(CoefrevisionVO vo, User user)
        throws Exception;

    public void doRemove(CoefrevisionVO vo, User user)
        throws Exception;

    public CoefrevisionVO doUpdate(CoefrevisionVO vo, User user)
        throws Exception;

    public CoefrevisionVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CoefrevisionListVO params, User user)
        throws Exception;

}
