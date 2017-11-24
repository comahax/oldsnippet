/**
* auto-generated code
* Wed Sep 02 10:14:50 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.unvrewardtotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalVO;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalListVO;

import java.io.Serializable;

/**
 * <p>Title: UnvRewardtotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface UnvRewardtotalControl extends AbstractControl {
    public UnvRewardtotalVO doCreate(UnvRewardtotalVO vo, User user)
        throws Exception;

    public void doRemove(UnvRewardtotalVO vo, User user)
        throws Exception;

    public UnvRewardtotalVO doUpdate(UnvRewardtotalVO vo, User user)
        throws Exception;

    public UnvRewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(UnvRewardtotalListVO params, User user)
        throws Exception;

}
