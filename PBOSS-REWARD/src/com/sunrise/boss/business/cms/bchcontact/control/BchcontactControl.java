/**
* auto-generated code
* Fri Aug 25 11:28:40 CST 2006
*/
package com.sunrise.boss.business.cms.bchcontact.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactListVO;

import java.io.Serializable;

/**
 * <p>Title: BchcontactControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface BchcontactControl extends AbstractControl {
    public BchcontactVO doCreate(BchcontactVO vo, User user)
        throws Exception;

    public void doRemove(BchcontactVO vo, User user)
        throws Exception;

    public BchcontactVO doUpdate(BchcontactVO vo, User user)
        throws Exception;

    public BchcontactVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BchcontactListVO params, User user)
        throws Exception;
    
    public DataPackage queryByOprcodeAndType(BchcontactListVO params,User user) throws Exception;

}
