/**
* auto-generated code
* Wed Aug 27 09:37:44 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdrewardbjlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardbjlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BBCstdrewardbjlogControl extends AbstractControl {
    public BBCstdrewardbjlogVO doCreate(BBCstdrewardbjlogVO vo, User user)
        throws Exception;

    public void doRemove(BBCstdrewardbjlogVO vo, User user)
        throws Exception;

    public BBCstdrewardbjlogVO doUpdate(BBCstdrewardbjlogVO vo, User user)
        throws Exception;

    public BBCstdrewardbjlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BBCstdrewardbjlogListVO params, User user)
        throws Exception;

}
