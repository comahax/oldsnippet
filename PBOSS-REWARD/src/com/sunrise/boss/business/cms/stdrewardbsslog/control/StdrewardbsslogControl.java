/**
* auto-generated code
* Sat Apr 23 11:54:51 CST 2011
*/
package com.sunrise.boss.business.cms.stdrewardbsslog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogVO;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbsslogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface StdrewardbsslogControl extends AbstractControl {
    public StdrewardbsslogVO doCreate(StdrewardbsslogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbsslogVO vo, User user)
        throws Exception;

    public StdrewardbsslogVO doUpdate(StdrewardbsslogVO vo, User user)
        throws Exception;

    public StdrewardbsslogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbsslogListVO params, User user)
        throws Exception;

}
