/**
* auto-generated code
* Thu Feb 16 10:30:46 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salepointflag.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagVO;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagListVO;

import java.io.Serializable;

/**
 * <p>Title: SalepointflagControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface SalepointflagControl extends AbstractControl {
    public SalepointflagVO doCreate(SalepointflagVO vo, User user)
        throws Exception;

    public void doRemove(SalepointflagVO vo, User user)
        throws Exception;

    public SalepointflagVO doUpdate(SalepointflagVO vo, User user)
        throws Exception;

    public SalepointflagVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SalepointflagListVO params, User user)
        throws Exception;

}
