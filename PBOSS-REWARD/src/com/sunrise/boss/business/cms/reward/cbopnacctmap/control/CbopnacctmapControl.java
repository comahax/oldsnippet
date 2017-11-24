/**
* auto-generated code
* Mon Sep 22 09:01:03 CST 2008
*/
package com.sunrise.boss.business.cms.reward.cbopnacctmap.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.CbopnacctmapVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.CbopnacctmapListVO;

import java.io.Serializable;

/**
 * <p>Title: CbopnacctmapControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface CbopnacctmapControl extends AbstractControl {
    public CbopnacctmapVO doCreate(CbopnacctmapVO vo, User user)
        throws Exception;

    public void doRemove(CbopnacctmapVO vo, User user)
        throws Exception;

    public CbopnacctmapVO doUpdate(CbopnacctmapVO vo, User user)
        throws Exception;

    public CbopnacctmapVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CbopnacctmapListVO params, User user)
        throws Exception;

}
