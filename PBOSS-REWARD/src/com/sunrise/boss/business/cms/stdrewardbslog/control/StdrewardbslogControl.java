/**
* auto-generated code
* Fri Feb 01 18:27:26 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbslog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogVO;
import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbslogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface StdrewardbslogControl extends AbstractControl {
    public StdrewardbslogVO doCreate(StdrewardbslogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbslogVO vo, User user)
        throws Exception;

    public StdrewardbslogVO doUpdate(StdrewardbslogVO vo, User user)
        throws Exception;

    public StdrewardbslogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbslogListVO params, User user)
        throws Exception;

}
