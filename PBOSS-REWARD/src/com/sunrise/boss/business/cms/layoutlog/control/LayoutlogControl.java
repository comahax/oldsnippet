/**
* auto-generated code
* Fri Dec 21 09:56:55 CST 2007
*/
package com.sunrise.boss.business.cms.layoutlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.layoutlog.persistent.LayoutlogVO;
import com.sunrise.boss.business.cms.layoutlog.persistent.LayoutlogListVO;

import java.io.Serializable;

/**
 * <p>Title: LayoutlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface LayoutlogControl extends AbstractControl {
    public LayoutlogVO doCreate(LayoutlogVO vo, User user)
        throws Exception;

    public void doRemove(LayoutlogVO vo, User user)
        throws Exception;

    public LayoutlogVO doUpdate(LayoutlogVO vo, User user)
        throws Exception;

    public LayoutlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(LayoutlogListVO params, User user)
        throws Exception;

}
