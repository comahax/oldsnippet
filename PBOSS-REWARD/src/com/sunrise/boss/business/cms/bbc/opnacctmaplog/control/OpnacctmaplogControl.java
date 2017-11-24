/**
* auto-generated code
* Sun Sep 14 16:17:54 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.opnacctmaplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.persistent.OpnacctmaplogVO;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.persistent.OpnacctmaplogListVO;

import java.io.Serializable;

/**
 * <p>Title: OpnacctmaplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface OpnacctmaplogControl extends AbstractControl {
    public OpnacctmaplogVO doCreate(OpnacctmaplogVO vo, User user)
        throws Exception;

    public void doRemove(OpnacctmaplogVO vo, User user)
        throws Exception;

    public OpnacctmaplogVO doUpdate(OpnacctmaplogVO vo, User user)
        throws Exception;

    public OpnacctmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(OpnacctmaplogListVO params, User user)
        throws Exception;

}
