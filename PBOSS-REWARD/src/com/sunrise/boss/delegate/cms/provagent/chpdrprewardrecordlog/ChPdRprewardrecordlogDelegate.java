/**
* auto-generated code
* Sun Sep 08 15:35:41 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdrprewardrecordlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogListVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.control.ChPdRprewardrecordlogControlBean;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.control.ChPdRprewardrecordlogControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdRprewardrecordlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRprewardrecordlogDelegate {

    private static ChPdRprewardrecordlogControl control;

    public ChPdRprewardrecordlogDelegate() throws Exception {
        control = (ChPdRprewardrecordlogControl) ControlFactory.build(ChPdRprewardrecordlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdRprewardrecordlogVO doCreate(ChPdRprewardrecordlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdRprewardrecordlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdRprewardrecordlogVO doUpdate(ChPdRprewardrecordlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdRprewardrecordlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdRprewardrecordlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdRprewardrecordlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
