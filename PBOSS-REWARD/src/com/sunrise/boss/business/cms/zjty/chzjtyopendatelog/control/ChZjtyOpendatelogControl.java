/**
* auto-generated code
* Mon Feb 16 10:04:17 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.persistent.ChZjtyOpendatelogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.persistent.ChZjtyOpendatelogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyOpendatelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public interface ChZjtyOpendatelogControl extends AbstractControl {
    public ChZjtyOpendatelogVO doCreate(ChZjtyOpendatelogVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyOpendatelogVO vo, User user)
        throws Exception;

    public ChZjtyOpendatelogVO doUpdate(ChZjtyOpendatelogVO vo, User user)
        throws Exception;

    public ChZjtyOpendatelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyOpendatelogListVO params, User user)
        throws Exception;

}
