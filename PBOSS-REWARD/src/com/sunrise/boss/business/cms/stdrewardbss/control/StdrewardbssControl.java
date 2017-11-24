/**
* auto-generated code
* Sat Apr 23 11:54:03 CST 2011
*/
package com.sunrise.boss.business.cms.stdrewardbss.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssVO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbssControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface StdrewardbssControl extends AbstractControl {
    public StdrewardbssVO doCreate(StdrewardbssVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbssVO vo, User user)
        throws Exception;

    public StdrewardbssVO doUpdate(StdrewardbssVO vo, User user)
        throws Exception;

    public StdrewardbssVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbssListVO params, User user)
        throws Exception;

}
