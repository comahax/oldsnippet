/**
* auto-generated code
* Fri Oct 08 15:00:14 CST 2010
*/
package com.sunrise.boss.business.cms.reward.stdrewardutlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardutlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface StdrewardutlogControl extends AbstractControl {
    public StdrewardutlogVO doCreate(StdrewardutlogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardutlogVO vo, User user)
        throws Exception;

    public StdrewardutlogVO doUpdate(StdrewardutlogVO vo, User user)
        throws Exception;

    public StdrewardutlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardutlogListVO params, User user)
        throws Exception;

}
