/**
* auto-generated code
* Sat Oct 10 09:26:17 CST 2009
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjstar.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjstarControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface StdrewardbjstarControl extends AbstractControl {
    public StdrewardbjstarVO doCreate(StdrewardbjstarVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbjstarVO vo, User user)
        throws Exception;

    public StdrewardbjstarVO doUpdate(StdrewardbjstarVO vo, User user)
        throws Exception;

    public StdrewardbjstarVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbjstarListVO params, User user)
        throws Exception;

}
