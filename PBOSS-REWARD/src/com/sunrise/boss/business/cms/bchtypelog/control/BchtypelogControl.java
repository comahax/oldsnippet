/**
* auto-generated code
* Tue Oct 17 17:36:16 CST 2006
*/
package com.sunrise.boss.business.cms.bchtypelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogVO;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogListVO;

import java.io.Serializable;

/**
 * <p>Title: BchtypelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface BchtypelogControl extends AbstractControl {
    public BchtypelogVO doCreate(BchtypelogVO vo, User user)
        throws Exception;

    public void doRemove(BchtypelogVO vo, User user)
        throws Exception;

    public BchtypelogVO doUpdate(BchtypelogVO vo, User user)
        throws Exception;

    public BchtypelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BchtypelogListVO params, User user)
        throws Exception;

}
