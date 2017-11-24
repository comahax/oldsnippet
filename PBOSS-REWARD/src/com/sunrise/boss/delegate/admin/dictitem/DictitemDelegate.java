/**
* auto-generated code
* Thu Sep 21 16:09:09 CST 2006
*/
package com.sunrise.boss.delegate.admin.dictitem;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.dictitem.control.DictitemControl;
import com.sunrise.boss.business.admin.dictitem.control.DictitemControlBean;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>Title: DictitemDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class DictitemDelegate {

    private static DictitemControl control;

    public DictitemDelegate() throws Exception {
        control = (DictitemControl) ControlFactory.build(DictitemControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public DictitemVO doCreate(DictitemVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(DictitemVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public DictitemVO doUpdate(DictitemVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public DictitemVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (DictitemVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(DictitemListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }

    public Collection doFindAll(User user) throws Exception{
        return control.doFindAll(user);
    }
}
