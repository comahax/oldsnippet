/**
* auto-generated code
* Tue Sep 19 21:22:32 CST 2006
*/
package com.sunrise.boss.business.cms.recompense.control;

import com.sunrise.boss.business.cms.recompense.persistent.RecompenseListVO;
import com.sunrise.boss.business.cms.recompense.persistent.RecompenseVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

import java.io.Serializable;

/**
 * <p>Title: RecompenseControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RecompenseControl extends AbstractControl {
    public RecompenseVO doCreate(RecompenseVO vo, User user)
        throws Exception;

    public void doRemove(RecompenseVO vo, User user)
        throws Exception;

    public RecompenseVO doUpdate(RecompenseVO vo, User user)
        throws Exception;

    public RecompenseVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RecompenseListVO params, User user)
        throws Exception;

}
