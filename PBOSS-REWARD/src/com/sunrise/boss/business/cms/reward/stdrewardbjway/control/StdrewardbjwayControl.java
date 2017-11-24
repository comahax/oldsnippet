/**
* auto-generated code
* Tue Jan 05 10:01:34 CST 2010
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjway.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjwayControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface StdrewardbjwayControl extends AbstractControl {
    public StdrewardbjwayVO doCreate(StdrewardbjwayVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbjwayVO vo, User user)
        throws Exception;

    public StdrewardbjwayVO doUpdate(StdrewardbjwayVO vo, User user)
        throws Exception;

    public StdrewardbjwayVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbjwayListVO params, User user)
        throws Exception;

}
