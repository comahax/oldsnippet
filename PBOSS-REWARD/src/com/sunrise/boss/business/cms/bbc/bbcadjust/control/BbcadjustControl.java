/**
* auto-generated code
* Wed Aug 26 15:42:00 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcadjust.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustVO;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustListVO;

import java.io.Serializable;

/**
 * <p>Title: BbcadjustControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface BbcadjustControl extends AbstractControl {
    public BbcadjustVO doCreate(BbcadjustVO vo, User user)
        throws Exception;

    public void doRemove(BbcadjustVO vo, User user)
        throws Exception;

    public BbcadjustVO doUpdate(BbcadjustVO vo, User user)
        throws Exception;

    public BbcadjustVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcadjustListVO params, User user)
        throws Exception;

}
