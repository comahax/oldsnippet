/**
* auto-generated code
* Sun Feb 01 17:08:50 CST 2009
*/
package com.sunrise.boss.business.cms.stdrewardhz.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: StdrewardhzControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli 
 * @version 1.0
 */
public interface StdrewardhzControl extends AbstractControl {
    public StdrewardhzVO doCreate(StdrewardhzVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardhzVO vo, User user)
        throws Exception;

    public StdrewardhzVO doUpdate(StdrewardhzVO vo, User user)
        throws Exception;

    public StdrewardhzVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardhzListVO params, User user)
        throws Exception;
    
    public StdrewardVO doSave(StdrewardVO stdrewardvo, List oldStarList, List newStarList, boolean isCity, User user)
    	throws Exception;

	public String doQueryHealth(User user) throws Exception;
    
}
