/**
* auto-generated code
* Thu Dec 24 14:22:12 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtycompcoef;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefListVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.control.ZjtyCompcoefControlBean;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.control.ZjtyCompcoefControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCompcoefDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyCompcoefDelegate {

    private static ZjtyCompcoefControl control;

    public ZjtyCompcoefDelegate() throws Exception {
        control = (ZjtyCompcoefControl) ControlFactory.build(ZjtyCompcoefControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyCompcoefVO doCreate(ZjtyCompcoefVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyCompcoefVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyCompcoefVO doUpdate(ZjtyCompcoefVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyCompcoefVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyCompcoefVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyCompcoefListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
