/**
* auto-generated code
* Tue Sep 18 16:24:42 CST 2012
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjnoncycControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface StdrewardbjnoncycControl extends AbstractControl {
    public StdrewardbjnoncycVO doCreate(StdrewardbjnoncycVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbjnoncycVO vo, User user)
        throws Exception;

    public StdrewardbjnoncycVO doUpdate(StdrewardbjnoncycVO vo, User user)
        throws Exception;

    public StdrewardbjnoncycVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbjnoncycListVO params, User user)
        throws Exception;

}
