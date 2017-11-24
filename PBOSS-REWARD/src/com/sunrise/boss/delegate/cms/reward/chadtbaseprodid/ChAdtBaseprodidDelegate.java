/**
* auto-generated code
* Tue Jun 03 20:21:31 CST 2014
*/
package com.sunrise.boss.delegate.cms.reward.chadtbaseprodid;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidVO;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidListVO;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.control.ChAdtBaseprodidControlBean;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.control.ChAdtBaseprodidControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtBaseprodidDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtBaseprodidDelegate {

    private static ChAdtBaseprodidControl control;

    public ChAdtBaseprodidDelegate() throws Exception {
        control = (ChAdtBaseprodidControl) ControlFactory.build(ChAdtBaseprodidControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtBaseprodidVO doCreate(ChAdtBaseprodidVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtBaseprodidVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtBaseprodidVO doUpdate(ChAdtBaseprodidVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtBaseprodidVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtBaseprodidVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtBaseprodidListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
