/**
* auto-generated code
* Thu Dec 24 14:26:30 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtycompcoeflog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogListVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.control.ZjtyCompcoeflogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.control.ZjtyCompcoeflogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCompcoeflogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyCompcoeflogDelegate {

    private static ZjtyCompcoeflogControl control;

    public ZjtyCompcoeflogDelegate() throws Exception {
        control = (ZjtyCompcoeflogControl) ControlFactory.build(ZjtyCompcoeflogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyCompcoeflogVO doCreate(ZjtyCompcoeflogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyCompcoeflogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyCompcoeflogVO doUpdate(ZjtyCompcoeflogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyCompcoeflogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyCompcoeflogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyCompcoeflogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
