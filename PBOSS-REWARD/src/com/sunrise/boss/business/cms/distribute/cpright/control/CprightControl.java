/**
* auto-generated code
* Wed Dec 27 11:34:25 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cpright.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpright.persistent.CprightVO;
import com.sunrise.boss.business.cms.distribute.cpright.persistent.CprightListVO;

import java.io.Serializable;

/**
 * <p>Title: CprightControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface CprightControl extends AbstractControl {
    public CprightVO doCreate(CprightVO vo, User user)
        throws Exception;

    public void doRemove(CprightVO vo, User user)
        throws Exception;

    public CprightVO doUpdate(CprightVO vo, User user)
        throws Exception;

    public CprightVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CprightListVO params, User user)
        throws Exception;

}
