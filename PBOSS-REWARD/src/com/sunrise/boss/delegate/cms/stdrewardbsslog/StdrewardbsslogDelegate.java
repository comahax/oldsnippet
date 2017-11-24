/**
* auto-generated code
* Sat Apr 23 11:54:51 CST 2011
*/
package com.sunrise.boss.delegate.cms.stdrewardbsslog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogVO;
import com.sunrise.boss.business.cms.stdrewardbsslog.persistent.StdrewardbsslogListVO;
import com.sunrise.boss.business.cms.stdrewardbsslog.control.StdrewardbsslogControlBean;
import com.sunrise.boss.business.cms.stdrewardbsslog.control.StdrewardbsslogControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbsslogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class StdrewardbsslogDelegate {

    private static StdrewardbsslogControl control;

    public StdrewardbsslogDelegate() throws Exception {
        control = (StdrewardbsslogControl) ControlFactory.build(StdrewardbsslogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardbsslogVO doCreate(StdrewardbsslogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardbsslogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardbsslogVO doUpdate(StdrewardbsslogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardbsslogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardbsslogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardbsslogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
