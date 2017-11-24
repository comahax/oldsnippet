/**
* auto-generated code
* Sat Mar 09 12:11:47 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalrewardtotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChZjtyLocalrewardtotalControl extends AbstractControl {
    public ChZjtyLocalrewardtotalVO doCreate(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocalrewardtotalVO doUpdate(ChZjtyLocalrewardtotalVO vo, User user)
        throws Exception;

    public ChZjtyLocalrewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyLocalrewardtotalListVO params, User user)
        throws Exception;

    public DataPackage doQueryTotal(ChZjtyLocalrewardtotalListVO params, User user)
        throws Exception;
}
