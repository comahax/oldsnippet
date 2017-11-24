/**
* auto-generated code
* Fri Feb 01 18:28:31 CST 2008
*/
package com.sunrise.boss.delegate.cms.stdrewardlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardlog.control.StdrewardlogControl;
import com.sunrise.boss.business.cms.stdrewardlog.control.StdrewardlogControlBean;
import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogVO;
import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardlogDelegate {

    private static StdrewardlogControl control;

    public StdrewardlogDelegate() throws Exception {
        control = (StdrewardlogControl) ControlFactory.build(StdrewardlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public StdrewardlogVO doCreate(StdrewardlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(StdrewardlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public StdrewardlogVO doUpdate(StdrewardlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public StdrewardlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (StdrewardlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(StdrewardlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
