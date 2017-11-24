/**
* auto-generated code
* Thu Mar 03 11:37:46 CST 2011
*/
package com.sunrise.boss.business.cms.empconfirm.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmListVO;

import java.io.Serializable;

/**
 * <p>Title: EmpconfirmControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public interface EmpconfirmControl extends AbstractControl {
    public EmpconfirmVO doCreate(EmpconfirmVO vo, User user)
        throws Exception;

    public void doRemove(EmpconfirmVO vo, User user)
        throws Exception;

    public EmpconfirmVO doUpdate(EmpconfirmVO vo, User user)
        throws Exception;

    public EmpconfirmVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(EmpconfirmListVO params, User user)
        throws Exception;

}
