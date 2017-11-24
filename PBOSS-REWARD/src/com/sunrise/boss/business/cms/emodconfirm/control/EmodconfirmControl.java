/**
* auto-generated code
* Thu Mar 03 20:02:58 CST 2011
*/
package com.sunrise.boss.business.cms.emodconfirm.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmVO;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmListVO;

import java.io.Serializable;

/**
 * <p>Title: EmodconfirmControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public interface EmodconfirmControl extends AbstractControl {
    public EmodconfirmVO doCreate(EmodconfirmVO vo, User user)
        throws Exception;

    public void doRemove(EmodconfirmVO vo, User user)
        throws Exception;

    public EmodconfirmVO doUpdate(EmodconfirmVO vo, User user)
        throws Exception;

    public EmodconfirmVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(EmodconfirmListVO params, User user)
        throws Exception;

}
