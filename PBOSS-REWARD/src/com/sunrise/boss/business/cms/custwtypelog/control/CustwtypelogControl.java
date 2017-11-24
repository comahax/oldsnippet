/**
* auto-generated code
* Tue Oct 17 17:34:18 CST 2006
*/
package com.sunrise.boss.business.cms.custwtypelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custwtypelog.persistent.CustwtypelogVO;
import com.sunrise.boss.business.cms.custwtypelog.persistent.CustwtypelogListVO;

import java.io.Serializable;

/**
 * <p>Title: CustwtypelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface CustwtypelogControl extends AbstractControl {
    public CustwtypelogVO doCreate(CustwtypelogVO vo, User user)
        throws Exception;

    public void doRemove(CustwtypelogVO vo, User user)
        throws Exception;

    public CustwtypelogVO doUpdate(CustwtypelogVO vo, User user)
        throws Exception;

    public CustwtypelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CustwtypelogListVO params, User user)
        throws Exception;

}
