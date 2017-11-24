/**
* auto-generated code
* Sat Mar 09 12:02:30 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalgdrewardtotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChZjtyLocalgdrewardtotalControl extends AbstractControl {
    public ChZjtyLocalgdrewardtotalVO doCreate(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocalgdrewardtotalVO doUpdate(ChZjtyLocalgdrewardtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocalgdrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyLocalgdrewardtotalListVO params, User user)
        throws Exception;

    public DataPackage doQueryTotal(ChZjtyLocalgdrewardtotalListVO params, User user)
        throws Exception;

}
