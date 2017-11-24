/**
* auto-generated code
* Mon Oct 27 11:56:04 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtycitylvlrwd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdVO;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdListVO;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.control.ZjtyCitylvlrwdControlBean;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.control.ZjtyCitylvlrwdControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCitylvlrwdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyCitylvlrwdDelegate {

    private static ZjtyCitylvlrwdControl control;

    public ZjtyCitylvlrwdDelegate() throws Exception {
        control = (ZjtyCitylvlrwdControl) ControlFactory.build(ZjtyCitylvlrwdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyCitylvlrwdVO doCreate(ZjtyCitylvlrwdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyCitylvlrwdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyCitylvlrwdVO doUpdate(ZjtyCitylvlrwdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyCitylvlrwdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyCitylvlrwdVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyCitylvlrwdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
