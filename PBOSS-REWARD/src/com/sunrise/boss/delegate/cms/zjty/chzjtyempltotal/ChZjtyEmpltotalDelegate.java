/**
* auto-generated code
* Fri Feb 13 16:49:58 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtyempltotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.control.ChZjtyEmpltotalControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.control.ChZjtyEmpltotalControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyEmpltotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyEmpltotalDelegate {

    private static ChZjtyEmpltotalControl control;

    public ChZjtyEmpltotalDelegate() throws Exception {
        control = (ChZjtyEmpltotalControl) ControlFactory.build(ChZjtyEmpltotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ChZjtyEmpltotalVO doCreate(ChZjtyEmpltotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ChZjtyEmpltotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ChZjtyEmpltotalVO doUpdate(ChZjtyEmpltotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ChZjtyEmpltotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyEmpltotalVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ChZjtyEmpltotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
