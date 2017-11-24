/**
* auto-generated code
* Wed Sep 04 21:16:54 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.vchpdrprewardrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordVO;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordListVO;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.control.VChPdRprewardrecordControlBean;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.control.VChPdRprewardrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdRprewardrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPdRprewardrecordDelegate {

    private static VChPdRprewardrecordControl control;

    public VChPdRprewardrecordDelegate() throws Exception {
        control = (VChPdRprewardrecordControl) ControlFactory.build(VChPdRprewardrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public VChPdRprewardrecordVO doCreate(VChPdRprewardrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(VChPdRprewardrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public VChPdRprewardrecordVO doUpdate(VChPdRprewardrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public VChPdRprewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (VChPdRprewardrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(VChPdRprewardrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
