/**
* auto-generated code
* Wed Aug 27 09:37:44 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.stdrewardbjlog;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.control.BBCstdrewardbjlogControl;
import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.control.BBCstdrewardbjlogControlBean;
import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardbjlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BBCstdrewardbjlogDelegate {

    private static BBCstdrewardbjlogControl control;

    public BBCstdrewardbjlogDelegate() throws Exception {
        control = (BBCstdrewardbjlogControl) ControlFactory.build(BBCstdrewardbjlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BBCstdrewardbjlogVO doCreate(BBCstdrewardbjlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BBCstdrewardbjlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public BBCstdrewardbjlogVO doUpdate(BBCstdrewardbjlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BBCstdrewardbjlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BBCstdrewardbjlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BBCstdrewardbjlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
