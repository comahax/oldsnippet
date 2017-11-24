/**
* auto-generated code
* Mon Feb 16 10:03:38 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.persistent.ChZjtyEmpltotallogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.persistent.ChZjtyEmpltotallogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyEmpltotallogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public interface ChZjtyEmpltotallogControl extends AbstractControl {
    public ChZjtyEmpltotallogVO doCreate(ChZjtyEmpltotallogVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyEmpltotallogVO vo, User user)
        throws Exception;

    public ChZjtyEmpltotallogVO doUpdate(ChZjtyEmpltotallogVO vo, User user)
        throws Exception;

    public ChZjtyEmpltotallogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyEmpltotallogListVO params, User user)
        throws Exception;

}
