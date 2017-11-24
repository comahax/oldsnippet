/**
* auto-generated code
* Fri Feb 15 15:25:15 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.busiloadlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiloadlog.control.BusiloadlogControl;
import com.sunrise.boss.business.cms.reward.busiloadlog.control.BusiloadlogControlBean;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogVO;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BusiloadlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class BusiloadlogDelegate {

    private static BusiloadlogControl control;

    public BusiloadlogDelegate() throws Exception {
        control = (BusiloadlogControl) ControlFactory.build(BusiloadlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BusiloadlogVO doCreate(BusiloadlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BusiloadlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BusiloadlogVO doUpdate(BusiloadlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BusiloadlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BusiloadlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BusiloadlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
