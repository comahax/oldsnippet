/**
* auto-generated code
* Sat Mar 09 12:10:11 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalperconfigtotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChZjtyLocalperconfigtotalControl extends AbstractControl {
    public ChZjtyLocalperconfigtotalVO doCreate(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocalperconfigtotalVO doUpdate(ChZjtyLocalperconfigtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocalperconfigtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyLocalperconfigtotalListVO params, User user)
        throws Exception;

    public DataPackage doQueryTotal(ChZjtyLocalperconfigtotalListVO params, User user)
        throws Exception;
}
