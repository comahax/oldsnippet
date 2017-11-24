/**
* auto-generated code
* Mon Jun 20 09:11:28 GMT 2011
*/
package com.sunrise.boss.business.cms.mendregister.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterVO;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterListVO;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: MendregisterControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface MendregisterControl extends AbstractControl {
    public MendregisterVO doCreate(MendregisterVO vo, User user)
        throws Exception;

    public void doRemove(MendregisterVO vo, User user)
        throws Exception;

    public MendregisterVO doUpdate(MendregisterVO vo, User user)
        throws Exception;

    public MendregisterVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MendregisterListVO params, User user)
        throws Exception;
    public boolean checkIfExistIn31Days(String mobile,Date selltime, User user)
		throws Exception;
//    public MendregisterVO doCreateWithCheck(MendregisterVO vo, User user)
//		throws Exception;
}
