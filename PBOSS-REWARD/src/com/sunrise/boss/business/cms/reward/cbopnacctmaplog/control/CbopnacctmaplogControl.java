/**
* auto-generated code
* Mon Sep 22 09:03:07 CST 2008
*/
package com.sunrise.boss.business.cms.reward.cbopnacctmaplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.persistent.CbopnacctmaplogVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.persistent.CbopnacctmaplogListVO;

import java.io.Serializable;

/**
 * <p>Title: CbopnacctmaplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface CbopnacctmaplogControl extends AbstractControl {
    public CbopnacctmaplogVO doCreate(CbopnacctmaplogVO vo, User user)
        throws Exception;

    public void doRemove(CbopnacctmaplogVO vo, User user)
        throws Exception;

    public CbopnacctmaplogVO doUpdate(CbopnacctmaplogVO vo, User user)
        throws Exception;

    public CbopnacctmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CbopnacctmaplogListVO params, User user)
        throws Exception;

}
