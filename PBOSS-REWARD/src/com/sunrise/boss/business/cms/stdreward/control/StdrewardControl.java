/**
* auto-generated code
* Fri Feb 01 18:05:53 CST 2008
*/
package com.sunrise.boss.business.cms.stdreward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface StdrewardControl extends AbstractControl {
    public StdrewardVO doCreate(StdrewardVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardVO vo, User user)
        throws Exception;

    public StdrewardVO doUpdate(StdrewardVO vo, User user)
        throws Exception;

    public StdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryfor5455(StdrewardListVO params, User user)
    throws Exception;
}
