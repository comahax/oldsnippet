/**
* auto-generated code
* Fri Feb 13 16:49:58 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyempltotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyEmpltotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public interface ChZjtyEmpltotalControl extends AbstractControl {
    public ChZjtyEmpltotalVO doCreate(ChZjtyEmpltotalVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyEmpltotalVO vo, User user)
        throws Exception;

    public ChZjtyEmpltotalVO doUpdate(ChZjtyEmpltotalVO vo, User user)
        throws Exception;

    public ChZjtyEmpltotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyEmpltotalListVO params, User user)
        throws Exception;

}
