/**
* auto-generated code
* Sun Nov 29 14:16:41 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.coefrevision;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionVO;
import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionListVO;
import com.sunrise.boss.business.cms.examine.coefrevision.control.CoefrevisionControlBean;
import com.sunrise.boss.business.cms.examine.coefrevision.control.CoefrevisionControl;

import java.io.Serializable;

/**
 * <p>Title: CoefrevisionDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CoefrevisionDelegate {

    private static CoefrevisionControl control;

    public CoefrevisionDelegate() throws Exception {
        control = (CoefrevisionControl) ControlFactory.build(CoefrevisionControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public CoefrevisionVO doCreate(CoefrevisionVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(CoefrevisionVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public CoefrevisionVO doUpdate(CoefrevisionVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public CoefrevisionVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CoefrevisionVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(CoefrevisionListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
