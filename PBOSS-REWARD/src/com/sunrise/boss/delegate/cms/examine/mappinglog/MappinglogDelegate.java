/**
* auto-generated code
* Sat Nov 28 17:50:09 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.mappinglog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogVO;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogListVO;
import com.sunrise.boss.business.cms.examine.mappinglog.control.MappinglogControlBean;
import com.sunrise.boss.business.cms.examine.mappinglog.control.MappinglogControl;

import java.io.Serializable;

/**
 * <p>Title: MappinglogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappinglogDelegate {

    private static MappinglogControl control;

    public MappinglogDelegate() throws Exception {
        control = (MappinglogControl) ControlFactory.build(MappinglogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public MappinglogVO doCreate(MappinglogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(MappinglogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public MappinglogVO doUpdate(MappinglogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public MappinglogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (MappinglogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(MappinglogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
