/**
* auto-generated code
* Wed Nov 25 11:12:10 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnitem;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.sunrise.boss.business.cms.examine.exmnitem.control.ExmnitemControlBean;
import com.sunrise.boss.business.cms.examine.exmnitem.control.ExmnitemControl;

import java.io.Serializable;

/**
 * <p>Title: ExmnitemDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemDelegate {

    private static ExmnitemControl control;

    public ExmnitemDelegate() throws Exception {
        control = (ExmnitemControl) ControlFactory.build(ExmnitemControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnitemVO doCreate(ExmnitemVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnitemVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public void doRemoveItem(Serializable pkVO,String itemcityid, User user)
    throws Exception {
    control.doRemoveItem(pkVO,itemcityid, user);
}

    public ExmnitemVO doUpdate(ExmnitemVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnitemVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnitemVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnitemListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQueryExmnitemList(ExmnitemListVO params, User user)
    throws Exception {
    return control.doQueryExmnitemList(params, user);
}

}
