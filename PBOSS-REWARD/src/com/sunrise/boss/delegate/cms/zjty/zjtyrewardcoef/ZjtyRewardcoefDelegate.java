/**
* auto-generated code
* Fri Oct 24 09:17:11 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoef;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefListVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.control.ZjtyRewardcoefControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.control.ZjtyRewardcoefControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRewardcoefDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyRewardcoefDelegate {

    private static ZjtyRewardcoefControl control;

    public ZjtyRewardcoefDelegate() throws Exception {
        control = (ZjtyRewardcoefControl) ControlFactory.build(ZjtyRewardcoefControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyRewardcoefVO doCreate(ZjtyRewardcoefVO vo, User user)
        throws Exception {
        return control.doSave(vo, user);
    }
    public void doRemove(ZjtyRewardcoefVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyRewardcoefVO doUpdate(ZjtyRewardcoefVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyRewardcoefVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyRewardcoefVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyRewardcoefListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
