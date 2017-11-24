/**
* auto-generated code
* Thu Dec 11 16:31:58 CST 2008
*/
package com.sunrise.boss.delegate.zifee.yxplansynlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansynlog.control.YxplansynlogControl;
import com.sunrise.boss.business.zifee.yxplansynlog.control.YxplansynlogControlBean;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogVO;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplansynlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class YxplansynlogDelegate {

    private static YxplansynlogControl control;

    public YxplansynlogDelegate() throws Exception {
        control = (YxplansynlogControl) ControlFactory.build(YxplansynlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxplansynlogVO doCopysyn(String yxplanid, User user)
			throws Exception {
		return control.doCopysyn(yxplanid, user);
}
//    public YxplansynlogVO doCreate(YxplansynlogVO vo, User user )
//        throws Exception {
//        return control.doCreate(vo, user);
//    }
//    public void doRemove(YxplansynlogVO vo, User user )
//        throws Exception {
//        control.doRemove(vo, user);
//    }
//    public YxplansynlogVO doUpdate(YxplansynlogVO vo, User user )
//        throws Exception {
//        return control.doUpdate(vo, user);
//    }
//    public YxplansynlogVO doFindByPk(Serializable pk, User user )
//        throws Exception {
//        return (YxplansynlogVO) control.doFindByPk(pk, user);
//    }
//    public DataPackage doQuery(YxplansynlogListVO params, User user )
//        throws Exception {
//        return control.doQuery(params, user);
//    }
}
