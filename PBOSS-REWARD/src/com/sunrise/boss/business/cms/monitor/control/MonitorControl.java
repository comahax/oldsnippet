/**
* auto-generated code
* Tue Aug 21 08:42:57 CST 2012
*/
package com.sunrise.boss.business.cms.monitor.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorVO;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorListVO;

import java.io.Serializable;

/**
 * <p>Title: MonitorControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface MonitorControl extends AbstractControl {
    public MonitorVO doCreate(MonitorVO vo, User user)
        throws Exception;

    public void doRemove(MonitorVO vo, User user)
        throws Exception;

    public MonitorVO doUpdate(MonitorVO vo, User user)
        throws Exception;

    public MonitorVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MonitorListVO params, User user)
        throws Exception;
    
    public String doCreateaccount(MonitorListVO params, User user)
    	throws Exception;

}
