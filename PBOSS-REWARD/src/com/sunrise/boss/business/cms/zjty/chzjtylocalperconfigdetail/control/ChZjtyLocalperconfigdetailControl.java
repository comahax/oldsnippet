/**
* auto-generated code
* Sat Mar 09 12:08:48 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalperconfigdetailControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChZjtyLocalperconfigdetailControl extends AbstractControl {
    public ChZjtyLocalperconfigdetailVO doCreate(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception;

    public ChZjtyLocalperconfigdetailVO doUpdate(ChZjtyLocalperconfigdetailVO vo, User user)
        throws Exception;

    public ChZjtyLocalperconfigdetailVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyLocalperconfigdetailListVO params, User user)
        throws Exception;

}
