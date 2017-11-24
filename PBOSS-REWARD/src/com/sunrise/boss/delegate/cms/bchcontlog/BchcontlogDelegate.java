/**
* auto-generated code
* Wed Oct 18 14:52:06 CST 2006
*/
package com.sunrise.boss.delegate.cms.bchcontlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchcontlog.control.BchcontlogControl;
import com.sunrise.boss.business.cms.bchcontlog.control.BchcontlogControlBean;
import com.sunrise.boss.business.cms.bchcontlog.persistent.BchcontlogVO;
import com.sunrise.boss.business.cms.bchcontlog.persistent.BchcontlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BchcontlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class BchcontlogDelegate {

    private static BchcontlogControl control;

    public BchcontlogDelegate() throws Exception {
        control = (BchcontlogControl) ControlFactory.build(BchcontlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BchcontlogVO doCreate(BchcontlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BchcontlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BchcontlogVO doUpdate(BchcontlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BchcontlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BchcontlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BchcontlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
