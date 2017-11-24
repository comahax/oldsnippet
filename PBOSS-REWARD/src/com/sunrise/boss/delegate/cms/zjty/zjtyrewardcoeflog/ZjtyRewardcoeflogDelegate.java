/**
* auto-generated code
* Sat Dec 27 10:22:09 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoeflog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogListVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.control.ZjtyRewardcoeflogControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.control.ZjtyRewardcoeflogControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRewardcoeflogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyRewardcoeflogDelegate {

    private static ZjtyRewardcoeflogControl control;

    public ZjtyRewardcoeflogDelegate() throws Exception {
        control = (ZjtyRewardcoeflogControl) ControlFactory.build(ZjtyRewardcoeflogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyRewardcoeflogVO doCreate(ZjtyRewardcoeflogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyRewardcoeflogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyRewardcoeflogVO doUpdate(ZjtyRewardcoeflogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyRewardcoeflogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyRewardcoeflogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyRewardcoeflogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
