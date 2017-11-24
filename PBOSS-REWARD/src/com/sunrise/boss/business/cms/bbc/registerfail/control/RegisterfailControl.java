/**
* auto-generated code
* Fri Dec 09 10:19:02 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.registerfail.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailVO;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailListVO;

import java.io.Serializable;

/**
 * <p>Title: RegisterfailControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface RegisterfailControl extends AbstractControl {
    public RegisterfailVO doCreate(RegisterfailVO vo, User user)
        throws Exception;

    public void doRemove(RegisterfailVO vo, User user)
        throws Exception;

    public RegisterfailVO doUpdate(RegisterfailVO vo, User user)
        throws Exception;

    public RegisterfailVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RegisterfailListVO params, User user)
        throws Exception;

}
