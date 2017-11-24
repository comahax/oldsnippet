/**
* auto-generated code
* Tue Apr 10 15:46:57 CST 2012
*/
package com.sunrise.boss.business.cms.reward.typeinfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoVO;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoListVO;

import java.io.Serializable;

/**
 * <p>Title: TypeinfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface TypeinfoControl extends AbstractControl {
    public TypeinfoVO doCreate(TypeinfoVO vo, User user)
        throws Exception;

    public void doRemove(TypeinfoVO vo, User user)
        throws Exception;

    public TypeinfoVO doUpdate(TypeinfoVO vo, User user)
        throws Exception;

    public TypeinfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(TypeinfoListVO params, User user)
        throws Exception;

}
