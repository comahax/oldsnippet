/**
* auto-generated code
* Tue Jul 17 16:46:57 CST 2012
*/
package com.sunrise.boss.business.cms.et.chetstdreward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardVO;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardListVO;

import java.io.Serializable;

/**
 * <p>Title: ChEtStdrewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChEtStdrewardControl extends AbstractControl {
    public ChEtStdrewardVO doCreate(ChEtStdrewardVO vo, User user)
        throws Exception;

    public void doRemove(ChEtStdrewardVO vo, User user)
        throws Exception;

    public ChEtStdrewardVO doUpdate(ChEtStdrewardVO vo, User user)
        throws Exception;

    public ChEtStdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChEtStdrewardListVO params, User user)
        throws Exception;

}
