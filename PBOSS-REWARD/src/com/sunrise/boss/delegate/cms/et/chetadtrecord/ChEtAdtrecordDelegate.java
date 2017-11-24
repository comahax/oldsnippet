/**
* auto-generated code
* Tue Jul 31 17:05:40 CST 2012
*/
package com.sunrise.boss.delegate.cms.et.chetadtrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordVO;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordListVO;
import com.sunrise.boss.business.cms.et.chetadtrecord.control.ChEtAdtrecordControlBean;
import com.sunrise.boss.business.cms.et.chetadtrecord.control.ChEtAdtrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ChEtAdtrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChEtAdtrecordDelegate {

    private static ChEtAdtrecordControl control;

    public ChEtAdtrecordDelegate() throws Exception {
        control = (ChEtAdtrecordControl) ControlFactory.build(ChEtAdtrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChEtAdtrecordVO doCreate(ChEtAdtrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChEtAdtrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChEtAdtrecordVO doUpdate(ChEtAdtrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChEtAdtrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChEtAdtrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChEtAdtrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
