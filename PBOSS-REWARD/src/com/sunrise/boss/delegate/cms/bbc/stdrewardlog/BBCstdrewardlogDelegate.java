/**
* auto-generated code
* Tue Aug 26 14:34:07 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.stdrewardlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogVO;
import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardlog.control.BBCstdrewardlogControlBean;
import com.sunrise.boss.business.cms.bbc.stdrewardlog.control.BBCstdrewardlogControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BBCstdrewardlogDelegate {

    private static BBCstdrewardlogControl control;

    public BBCstdrewardlogDelegate() throws Exception {
        control = (BBCstdrewardlogControl) ControlFactory.build(BBCstdrewardlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BBCstdrewardlogVO doCreate(BBCstdrewardlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BBCstdrewardlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public BBCstdrewardlogVO doUpdate(BBCstdrewardlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BBCstdrewardlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BBCstdrewardlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BBCstdrewardlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
