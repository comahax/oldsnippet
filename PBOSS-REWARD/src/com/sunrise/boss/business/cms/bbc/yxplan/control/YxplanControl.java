/**
* auto-generated code
* Tue May 05 11:03:52 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.yxplan.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanVO;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanListVO;

import java.io.Serializable;

/**
 * <p>Title: yxplanControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface YxplanControl extends AbstractControl {
    public YxplanVO doCreate(YxplanVO vo, User user)
        throws Exception;

    public void doRemove(YxplanVO vo, User user)
        throws Exception;

    public YxplanVO doUpdate(YxplanVO vo, User user)
        throws Exception;

    public YxplanVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxplanListVO params, User user)
        throws Exception;

}
