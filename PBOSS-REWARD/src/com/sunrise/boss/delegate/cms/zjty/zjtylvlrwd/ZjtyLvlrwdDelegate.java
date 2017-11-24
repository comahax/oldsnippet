/**
* auto-generated code
* Mon Oct 27 10:18:25 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtylvlrwd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdVO;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdListVO;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.control.ZjtyLvlrwdControlBean;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.control.ZjtyLvlrwdControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyLvlrwdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyLvlrwdDelegate {

    private static ZjtyLvlrwdControl control;

    public ZjtyLvlrwdDelegate() throws Exception {
        control = (ZjtyLvlrwdControl) ControlFactory.build(ZjtyLvlrwdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyLvlrwdVO doCreate(ZjtyLvlrwdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyLvlrwdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyLvlrwdVO doUpdate(ZjtyLvlrwdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyLvlrwdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyLvlrwdVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyLvlrwdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
