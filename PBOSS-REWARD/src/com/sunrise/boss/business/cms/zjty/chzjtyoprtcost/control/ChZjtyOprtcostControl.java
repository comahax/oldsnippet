/**
* auto-generated code
* Fri Feb 13 16:59:53 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostVO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyOprtcostControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public interface ChZjtyOprtcostControl extends AbstractControl {
    public ChZjtyOprtcostVO doCreate(ChZjtyOprtcostVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyOprtcostVO vo, User user)
        throws Exception;

    public ChZjtyOprtcostVO doUpdate(ChZjtyOprtcostVO vo, User user)
        throws Exception;

    public ChZjtyOprtcostVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyOprtcostListVO params, User user)
        throws Exception;

}
