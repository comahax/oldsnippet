/**
* auto-generated code
* Tue Nov 24 10:54:37 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnperiod.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodListVO;
import com.sunrise.boss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnperiodControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnperiodControl extends AbstractControl {
    public ExmnperiodVO doCreate(ExmnperiodVO vo, User user)
        throws Exception;

    public void doRemove(ExmnperiodVO vo, User user)
        throws Exception;

    public ExmnperiodVO doUpdate(ExmnperiodVO vo, User user)
        throws Exception;

    public ExmnperiodVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnperiodListVO params, User user)
        throws Exception;
    
    public boolean doCheckBeingPeriod(ExmnperiodVO vo, User user)
    throws Exception;

}
