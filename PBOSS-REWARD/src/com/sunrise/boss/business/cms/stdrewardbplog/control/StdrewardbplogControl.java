/**
* auto-generated code
* Fri Feb 01 18:25:30 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogVO;
import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface StdrewardbplogControl extends AbstractControl {
    public StdrewardbplogVO doCreate(StdrewardbplogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbplogVO vo, User user)
        throws Exception;

    public StdrewardbplogVO doUpdate(StdrewardbplogVO vo, User user)
        throws Exception;

    public StdrewardbplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbplogListVO params, User user)
        throws Exception;

}
