/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardtotal.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: WayintegraltransruleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public interface BbcRewardtotalControl extends AbstractControl {
    public BbcRewardtotalVO doCreate(BbcRewardtotalVO vo, User user)
        throws Exception;

    public void doRemove(BbcRewardtotalVO vo, User user)
        throws Exception;

    public BbcRewardtotalVO doUpdate(BbcRewardtotalVO vo, User user)
        throws Exception;

    public BbcRewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcRewardtotalListVO params, User user)
        throws Exception;

}
