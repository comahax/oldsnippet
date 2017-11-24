/**
* auto-generated code
* Tue Sep 18 16:26:16 CST 2012
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.persistent.StdrewardbjnoncyclogVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyclog.persistent.StdrewardbjnoncyclogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjnoncyclogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface StdrewardbjnoncyclogControl extends AbstractControl {
    public StdrewardbjnoncyclogVO doCreate(StdrewardbjnoncyclogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbjnoncyclogVO vo, User user)
        throws Exception;

    public StdrewardbjnoncyclogVO doUpdate(StdrewardbjnoncyclogVO vo, User user)
        throws Exception;

    public StdrewardbjnoncyclogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbjnoncyclogListVO params, User user)
        throws Exception;

}
