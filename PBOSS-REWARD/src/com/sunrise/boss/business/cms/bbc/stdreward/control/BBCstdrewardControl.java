/**
* auto-generated code
* Wed Aug 27 09:24:49 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdreward.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardListVO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BBCstdrewardControl extends AbstractControl {
    public BBCstdrewardVO doCreate(BBCstdrewardVO vo, User user)
        throws Exception;

    public void doRemove(BBCstdrewardVO vo, User user)
        throws Exception;

    public BBCstdrewardVO doUpdate(BBCstdrewardVO vo, User user)
        throws Exception;

    public BBCstdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BBCstdrewardListVO params, User user)
        throws Exception;

}
