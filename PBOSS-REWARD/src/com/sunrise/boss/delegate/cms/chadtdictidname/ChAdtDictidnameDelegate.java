/**
* auto-generated code
* Mon Dec 19 14:58:11 CST 2011
*/
package com.sunrise.boss.delegate.cms.chadtdictidname;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameListVO;
import com.sunrise.boss.business.cms.chadtdictidname.control.ChAdtDictidnameControlBean;
import com.sunrise.boss.business.cms.chadtdictidname.control.ChAdtDictidnameControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtDictidnameDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtDictidnameDelegate {

    private static ChAdtDictidnameControl control;

    public ChAdtDictidnameDelegate() throws Exception {
        control = (ChAdtDictidnameControl) ControlFactory.build(ChAdtDictidnameControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtDictidnameVO doCreate(ChAdtDictidnameVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtDictidnameVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtDictidnameVO doUpdate(ChAdtDictidnameVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtDictidnameVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtDictidnameVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtDictidnameListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQuerySelf(ChAdtDictidnameListVO params, User user)
    throws Exception {
    	return control.doQuerySelf(params, user);
    }

}
