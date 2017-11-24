/**
* auto-generated code
* Tue Aug 21 12:28:54 CST 2012
*/
package com.sunrise.boss.delegate.cms.chadtdcordhis;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisVO;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisListVO;
import com.sunrise.boss.business.cms.chadtdcordhis.control.ChAdtDcordhisControlBean;
import com.sunrise.boss.business.cms.chadtdcordhis.control.ChAdtDcordhisControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtDcordhisDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtDcordhisDelegate {

    private static ChAdtDcordhisControl control;

    public ChAdtDcordhisDelegate() throws Exception {
        control = (ChAdtDcordhisControl) ControlFactory.build(ChAdtDcordhisControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtDcordhisVO doCreate(ChAdtDcordhisVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtDcordhisVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtDcordhisVO doUpdate(ChAdtDcordhisVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtDcordhisVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtDcordhisVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtDcordhisListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
