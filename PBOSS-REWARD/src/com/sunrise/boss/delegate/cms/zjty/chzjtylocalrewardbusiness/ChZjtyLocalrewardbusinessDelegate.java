/**
* auto-generated code
* Sat Mar 09 12:10:59 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtylocalrewardbusiness;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.control.ChZjtyLocalrewardbusinessControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.control.ChZjtyLocalrewardbusinessControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalrewardbusinessDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalrewardbusinessDelegate {

    private static ChZjtyLocalrewardbusinessControl control;

    public ChZjtyLocalrewardbusinessDelegate() throws Exception {
        control = (ChZjtyLocalrewardbusinessControl) ControlFactory.build(ChZjtyLocalrewardbusinessControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyLocalrewardbusinessVO doCreate(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyLocalrewardbusinessVO doUpdate(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyLocalrewardbusinessVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyLocalrewardbusinessVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyLocalrewardbusinessListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQueryTotal(ChZjtyLocalrewardbusinessListVO params, User user)
        throws Exception {
        return control.doQueryTotal(params, user);
    }
}
