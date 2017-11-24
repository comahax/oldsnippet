/**
* auto-generated code
* Tue Sep 10 14:37:33 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdrprewardrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordListVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.control.ChPdRprewardrecordControlBean;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.control.ChPdRprewardrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdRprewardrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRprewardrecordDelegate {

    private static ChPdRprewardrecordControl control;

    public ChPdRprewardrecordDelegate() throws Exception {
        control = (ChPdRprewardrecordControl) ControlFactory.build(ChPdRprewardrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdRprewardrecordVO doCreate(ChPdRprewardrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdRprewardrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdRprewardrecordVO doUpdate(ChPdRprewardrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdRprewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdRprewardrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdRprewardrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
