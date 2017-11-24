/**
* auto-generated code
* Fri Dec 30 15:15:14 CST 2011
*/
package com.sunrise.boss.delegate.cms.zjty.zjtystdreward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardListVO;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.control.ZjtyStdrewardControlBean;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.control.ZjtyStdrewardControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyStdrewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyStdrewardDelegate {

    private static ZjtyStdrewardControl control;

    public ZjtyStdrewardDelegate() throws Exception {
        control = (ZjtyStdrewardControl) ControlFactory.build(ZjtyStdrewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyStdrewardVO doCreate(ZjtyStdrewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyStdrewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyStdrewardVO doUpdate(ZjtyStdrewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyStdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyStdrewardVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyStdrewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
