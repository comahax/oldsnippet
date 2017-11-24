/**
* auto-generated code
* Thu Dec 28 19:50:30 CST 2006
*/
package com.sunrise.boss.delegate.cms.distribute.cooperatorlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogVO;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogListVO;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.control.CooperatorlogControlBean;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.control.CooperatorlogControl;

import java.io.Serializable;

/**
 * <p>Title: CooperatorlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CooperatorlogDelegate {

    private static CooperatorlogControl control;

    public CooperatorlogDelegate() throws Exception {
        control = (CooperatorlogControl) ControlFactory.build(CooperatorlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CooperatorlogVO doCreate(CooperatorlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CooperatorlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public CooperatorlogVO doUpdate(CooperatorlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CooperatorlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CooperatorlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CooperatorlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
