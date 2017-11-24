/**
* auto-generated code
* Tue Apr 17 11:01:07 CST 2007
*/
package com.sunrise.boss.business.cms.microarealog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.microarealog.persistent.MicroarealogVO;
import com.sunrise.boss.business.cms.microarealog.persistent.MicroarealogListVO;

import java.io.Serializable;

/**
 * <p>Title: MicroarealogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public interface MicroarealogControl extends AbstractControl {
    public MicroarealogVO doCreate(MicroarealogVO vo, User user)
        throws Exception;

    public void doRemove(MicroarealogVO vo, User user)
        throws Exception;

    public MicroarealogVO doUpdate(MicroarealogVO vo, User user)
        throws Exception;

    public MicroarealogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MicroarealogListVO params, User user)
        throws Exception;

}
