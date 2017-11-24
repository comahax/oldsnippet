/**
* auto-generated code
* Thu Sep 04 10:43:57 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.opnacctmap.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapListVO;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctListVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: OpnacctmapControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0 
 */
public interface OpnacctmapControl extends AbstractControl {
    public OpnacctmapVO doCreate(OpnacctmapVO vo, User user)
        throws Exception;

    public void doRemove(OpnacctmapVO vo, User user)
        throws Exception;

    public OpnacctmapVO doUpdate(OpnacctmapVO vo, User user)
        throws Exception;

    public OpnacctmapVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(OpnacctmapListVO params, User user)
        throws Exception;

}
