/**
* auto-generated code
* Thu Dec 28 19:50:30 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cooperatorlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogVO;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CooperatorlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CooperatorlogControl extends AbstractControl {
    public CooperatorlogVO doCreate(CooperatorlogVO vo, User user)
        throws Exception;

    public void doRemove(CooperatorlogVO vo, User user)
        throws Exception;

    public CooperatorlogVO doUpdate(CooperatorlogVO vo, User user)
        throws Exception;

    public CooperatorlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CooperatorlogListVO params, User user)
        throws Exception;

}
