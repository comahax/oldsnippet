/**
* auto-generated code
* Mon Apr 08 15:52:02 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdVO;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyTerewardstdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChZjtyTerewardstdControl extends AbstractControl {
    public ChZjtyTerewardstdVO doCreate(ChZjtyTerewardstdVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyTerewardstdVO vo, User user)
        throws Exception;

    public ChZjtyTerewardstdVO doUpdate(ChZjtyTerewardstdVO vo, User user)
        throws Exception;

    public ChZjtyTerewardstdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyTerewardstdListVO params, User user)
        throws Exception;

}
