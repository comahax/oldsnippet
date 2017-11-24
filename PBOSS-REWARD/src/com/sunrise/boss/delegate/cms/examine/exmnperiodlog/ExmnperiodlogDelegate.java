/**
* auto-generated code
* Tue Nov 24 10:57:58 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnperiodlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogVO;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogListVO;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.control.ExmnperiodlogControlBean;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.control.ExmnperiodlogControl;

import java.io.Serializable;

/**
 * <p>Title: ExmnperiodlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnperiodlogDelegate {

    private static ExmnperiodlogControl control;

    public ExmnperiodlogDelegate() throws Exception {
        control = (ExmnperiodlogControl) ControlFactory.build(ExmnperiodlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnperiodlogVO doCreate(ExmnperiodlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnperiodlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnperiodlogVO doUpdate(ExmnperiodlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnperiodlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnperiodlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnperiodlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
