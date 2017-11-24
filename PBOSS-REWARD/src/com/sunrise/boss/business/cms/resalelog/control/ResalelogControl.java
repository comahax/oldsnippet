/**
* auto-generated code
* Fri Jan 04 16:05:28 CST 2008
*/
package com.sunrise.boss.business.cms.resalelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resalelog.persistent.ResalelogVO;
import com.sunrise.boss.business.cms.resalelog.persistent.ResalelogListVO;

import java.io.Serializable;

/**
 * <p>Title: ResalelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ResalelogControl extends AbstractControl {
    public ResalelogVO doCreate(ResalelogVO vo, User user)
        throws Exception;

    public void doRemove(ResalelogVO vo, User user)
        throws Exception;

    public ResalelogVO doUpdate(ResalelogVO vo, User user)
        throws Exception;

    public ResalelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ResalelogListVO params, User user)
        throws Exception;

}
