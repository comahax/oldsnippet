/**
* auto-generated code
* Wed Aug 26 15:55:18 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcadjustlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.persistent.BbcadjustlogVO;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.persistent.BbcadjustlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BbcadjustlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface BbcadjustlogControl extends AbstractControl {
    public BbcadjustlogVO doCreate(BbcadjustlogVO vo, User user)
        throws Exception;

    public void doRemove(BbcadjustlogVO vo, User user)
        throws Exception;

    public BbcadjustlogVO doUpdate(BbcadjustlogVO vo, User user)
        throws Exception;

    public BbcadjustlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcadjustlogListVO params, User user)
        throws Exception;

}
