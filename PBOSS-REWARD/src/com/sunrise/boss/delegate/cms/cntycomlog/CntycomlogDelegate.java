/**
* auto-generated code
* Tue Oct 17 17:46:15 CST 2006
*/
package com.sunrise.boss.delegate.cms.cntycomlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cntycomlog.control.CntycomlogControl;
import com.sunrise.boss.business.cms.cntycomlog.control.CntycomlogControlBean;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogVO;
import com.sunrise.boss.business.cms.cntycomlog.persistent.CntycomlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CntycomlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class CntycomlogDelegate {

    private static CntycomlogControl control;

    public CntycomlogDelegate() throws Exception {
        control = (CntycomlogControl) ControlFactory.build(CntycomlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CntycomlogVO doCreate(CntycomlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CntycomlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CntycomlogVO doUpdate(CntycomlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CntycomlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CntycomlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CntycomlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
