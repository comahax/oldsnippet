/**
* auto-generated code
* Mon Feb 16 10:04:47 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyOprtcostlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public interface ChZjtyOprtcostlogControl extends AbstractControl {
    public ChZjtyOprtcostlogVO doCreate(ChZjtyOprtcostlogVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyOprtcostlogVO vo, User user)
        throws Exception;

    public ChZjtyOprtcostlogVO doUpdate(ChZjtyOprtcostlogVO vo, User user)
        throws Exception;

    public ChZjtyOprtcostlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyOprtcostlogListVO params, User user)
        throws Exception;

}
