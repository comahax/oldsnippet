/**
* auto-generated code
* Fri Apr 20 16:55:21 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.subtract.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractVO;
import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractListVO;

import java.io.Serializable;

/**
 * <p>Title: SubtractControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface SubtractControl extends AbstractControl {
    public SubtractVO doCreate(SubtractVO vo, User user)
        throws Exception;

    public void doRemove(SubtractVO vo, User user)
        throws Exception;

    public SubtractVO doUpdate(SubtractVO vo, User user)
        throws Exception;

    public SubtractVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SubtractListVO params, User user)
        throws Exception;

}
