/**
* auto-generated code
* Wed Oct 18 14:52:06 CST 2006
*/
package com.sunrise.boss.business.cms.bchcontlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchcontlog.persistent.BchcontlogVO;
import com.sunrise.boss.business.cms.bchcontlog.persistent.BchcontlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BchcontlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface BchcontlogControl extends AbstractControl {
    public BchcontlogVO doCreate(BchcontlogVO vo, User user)
        throws Exception;

    public void doRemove(BchcontlogVO vo, User user)
        throws Exception;

    public BchcontlogVO doUpdate(BchcontlogVO vo, User user)
        throws Exception;

    public BchcontlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BchcontlogListVO params, User user)
        throws Exception;

}
