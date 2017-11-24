/**
* auto-generated code
* Tue Oct 17 17:36:53 CST 2006
*/
package com.sunrise.boss.business.cms.areacterlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogVO;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogListVO;

import java.io.Serializable;

/**
 * <p>Title: AreacterlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface AreacterlogControl extends AbstractControl {
    public AreacterlogVO doCreate(AreacterlogVO vo, User user)
        throws Exception;

    public void doRemove(AreacterlogVO vo, User user)
        throws Exception;

    public AreacterlogVO doUpdate(AreacterlogVO vo, User user)
        throws Exception;

    public AreacterlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AreacterlogListVO params, User user)
        throws Exception;

}
