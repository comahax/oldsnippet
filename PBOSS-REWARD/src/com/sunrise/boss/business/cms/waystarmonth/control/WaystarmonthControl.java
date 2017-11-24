/**
* auto-generated code
* Wed Feb 24 14:10:39 CST 2010
*/
package com.sunrise.boss.business.cms.waystarmonth.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthVO;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthListVO;

import java.io.Serializable;

/**
 * <p>Title: WaystarmonthControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface WaystarmonthControl extends AbstractControl {
    public WaystarmonthVO doCreate(WaystarmonthVO vo, User user)
        throws Exception;

    public void doRemove(WaystarmonthVO vo, User user)
        throws Exception;

    public WaystarmonthVO doUpdate(WaystarmonthVO vo, User user)
        throws Exception;

    public WaystarmonthVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaystarmonthListVO params, User user)
        throws Exception;
    
    public String queryEftmonthtype(User user) throws Exception;

}
