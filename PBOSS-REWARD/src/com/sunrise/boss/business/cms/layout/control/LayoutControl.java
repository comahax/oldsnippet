/**
* auto-generated code
* Tue Dec 18 19:10:45 CST 2007
*/
package com.sunrise.boss.business.cms.layout.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.layout.persistent.LayoutVO;
import com.sunrise.boss.business.cms.layout.persistent.LayoutListVO;

import java.io.Serializable;

/**
 * <p>Title: LayoutControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface LayoutControl extends AbstractControl {
    public LayoutVO doCreate(LayoutVO vo, User user)
        throws Exception;

    public void doRemove(LayoutVO vo, User user)
        throws Exception;

    public LayoutVO doUpdate(LayoutVO vo, User user)
        throws Exception;

    public LayoutVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(LayoutListVO params, User user)
        throws Exception;

}
