/**
* auto-generated code
* Sun Nov 29 14:15:38 CST 2009
*/
package com.sunrise.boss.business.cms.examine.coefficient.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientListVO;

import java.io.Serializable;

/**
 * <p>Title: CoefficientControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CoefficientControl extends AbstractControl {
    public CoefficientVO doCreate(CoefficientVO vo, User user)
        throws Exception;

    public void doRemove(CoefficientVO vo, User user)
        throws Exception;

    public CoefficientVO doUpdate(CoefficientVO vo, User user)
        throws Exception;

    public CoefficientVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CoefficientListVO params, User user)
        throws Exception;

}
