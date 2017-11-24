/**
* auto-generated code
* Thu Mar 03 10:54:08 CST 2011
*/
package com.sunrise.boss.business.cms.waitreq.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqVO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqListVO;

import java.io.Serializable;

/**
 * <p>Title: WaitreqControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public interface WaitreqControl extends AbstractControl {
    public WaitreqVO doCreate(WaitreqVO vo, User user)
        throws Exception;

    public void doRemove(WaitreqVO vo, User user)
        throws Exception;

    public WaitreqVO doUpdate(WaitreqVO vo, User user)
        throws Exception;

    public WaitreqVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaitreqListVO params, User user)
        throws Exception;

}
