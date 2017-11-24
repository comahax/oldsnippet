/**
* auto-generated code
* Wed Nov 25 11:14:06 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogVO;
import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ExmnitemlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnitemlogControl extends AbstractControl {
    public ExmnitemlogVO doCreate(ExmnitemlogVO vo, User user)
        throws Exception;

    public void doRemove(ExmnitemlogVO vo, User user)
        throws Exception;

    public ExmnitemlogVO doUpdate(ExmnitemlogVO vo, User user)
        throws Exception;

    public ExmnitemlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnitemlogListVO params, User user)
        throws Exception;

}
