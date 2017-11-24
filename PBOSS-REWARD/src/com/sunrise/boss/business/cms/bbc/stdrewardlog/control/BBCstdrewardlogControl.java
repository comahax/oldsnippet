/**
* auto-generated code
* Tue Aug 26 14:34:07 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdrewardlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: StdrewardlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BBCstdrewardlogControl extends AbstractControl {
    public BBCstdrewardlogVO doCreate(BBCstdrewardlogVO vo, User user)
        throws Exception;

    public void doRemove(BBCstdrewardlogVO vo, User user)
        throws Exception;

    public BBCstdrewardlogVO doUpdate(BBCstdrewardlogVO vo, User user)
        throws Exception;

    public BBCstdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BBCstdrewardlogListVO params, User user)
        throws Exception;
}
