/**
* auto-generated code
* Sat Mar 09 12:07:52 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocaljjrewardtotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChZjtyLocaljjrewardtotalControl extends AbstractControl {
    public ChZjtyLocaljjrewardtotalVO doCreate(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocaljjrewardtotalVO doUpdate(ChZjtyLocaljjrewardtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocaljjrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyLocaljjrewardtotalListVO params, User user)
        throws Exception;

    public DataPackage doQueryTotal(ChZjtyLocaljjrewardtotalListVO params, User user)
        throws Exception;
}
