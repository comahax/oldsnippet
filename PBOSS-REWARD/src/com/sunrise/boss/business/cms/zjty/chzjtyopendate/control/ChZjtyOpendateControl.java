/**
* auto-generated code
* Fri Feb 13 16:55:58 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyopendate.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateVO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyOpendateControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public interface ChZjtyOpendateControl extends AbstractControl {
    public ChZjtyOpendateVO doCreate(ChZjtyOpendateVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyOpendateVO vo, User user)
        throws Exception;

    public ChZjtyOpendateVO doUpdate(ChZjtyOpendateVO vo, User user)
        throws Exception;

    public ChZjtyOpendateVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyOpendateListVO params, User user)
        throws Exception;

}
