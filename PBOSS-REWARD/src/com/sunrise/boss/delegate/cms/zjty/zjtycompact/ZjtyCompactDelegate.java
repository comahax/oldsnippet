/**
* auto-generated code
* Wed Dec 28 14:39:42 CST 2011
*/
package com.sunrise.boss.delegate.cms.zjty.zjtycompact;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactListVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.control.ZjtyCompactControlBean;
import com.sunrise.boss.business.cms.zjty.zjtycompact.control.ZjtyCompactControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCompactDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyCompactDelegate {

    private static ZjtyCompactControl control;

    public ZjtyCompactDelegate() throws Exception {
        control = (ZjtyCompactControl) ControlFactory.build(ZjtyCompactControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyCompactVO doCreate(ZjtyCompactVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyCompactVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyCompactVO doUpdate(ZjtyCompactVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyCompactVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyCompactVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyCompactListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
