/**
* auto-generated code
* Thu Nov 19 11:08:41 CST 2009
*/
package com.sunrise.boss.business.cms.empmodel.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;

import java.io.Serializable;

/**
 * <p>Title: EmpmodelControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface EmpmodelControl extends AbstractControl {
    public EmpmodelVO doCreate(EmpmodelVO vo, User user)
        throws Exception;

    public void doRemove(EmpmodelVO vo, User user)
        throws Exception;

    public EmpmodelVO doUpdate(EmpmodelVO vo, User user)
        throws Exception;

    public EmpmodelVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(EmpmodelListVO params, User user)
        throws Exception;

}
