/**
* auto-generated code
* Sat Mar 09 12:12:34 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtylocalzdsalereward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.control.ChZjtyLocalzdsalerewardControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.control.ChZjtyLocalzdsalerewardControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalzdsalerewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalzdsalerewardDelegate {

    private static ChZjtyLocalzdsalerewardControl control;

    public ChZjtyLocalzdsalerewardDelegate() throws Exception {
        control = (ChZjtyLocalzdsalerewardControl) ControlFactory.build(ChZjtyLocalzdsalerewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyLocalzdsalerewardVO doCreate(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyLocalzdsalerewardVO doUpdate(ChZjtyLocalzdsalerewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyLocalzdsalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyLocalzdsalerewardVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyLocalzdsalerewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryTotal(ChZjtyLocalzdsalerewardListVO params, User user)
        throws Exception {
        return control.doQueryTotal(params, user);
    }
}
