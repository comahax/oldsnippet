/**
* auto-generated code
* Fri Aug 28 11:17:48 CST 2009
*/
package com.sunrise.boss.business.cms.reward.busitocom.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomListVO;

import java.io.Serializable;

/**
 * <p>Title: BusitocomControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface BusitocomControl extends AbstractControl {
    public BusitocomVO doCreate(BusitocomVO vo, User user)
        throws Exception;

    public void doRemove(BusitocomVO vo, User user)
        throws Exception;

    public BusitocomVO doUpdate(BusitocomVO vo, User user)
        throws Exception;

    public BusitocomVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusitocomListVO params, User user)
        throws Exception;

}
