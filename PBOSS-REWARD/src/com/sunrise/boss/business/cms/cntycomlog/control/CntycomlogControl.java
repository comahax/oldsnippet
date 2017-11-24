/**
* auto-generated code
* Tue Oct 17 17:46:15 CST 2006
*/
package com.sunrise.boss.business.cms.cntycomlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogVO;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CntycomlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface CntycomlogControl extends AbstractControl {
    public CntycomlogVO doCreate(CntycomlogVO vo, User user)
        throws Exception;

    public void doRemove(CntycomlogVO vo, User user)
        throws Exception;

    public CntycomlogVO doUpdate(CntycomlogVO vo, User user)
        throws Exception;

    public CntycomlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CntycomlogListVO params, User user)
        throws Exception;

}
