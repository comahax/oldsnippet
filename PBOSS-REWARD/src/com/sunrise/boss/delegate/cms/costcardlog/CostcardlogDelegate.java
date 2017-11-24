/**
* auto-generated code
* Fri May 02 07:00:08 CST 2008
*/
package com.sunrise.boss.delegate.cms.costcardlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.costcardlog.control.CostcardlogControl;
import com.sunrise.boss.business.cms.costcardlog.control.CostcardlogControlBean;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogVO;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CostcardlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CostcardlogDelegate {

    private static CostcardlogControl control;

    public CostcardlogDelegate() throws Exception {
        control = (CostcardlogControl) ControlFactory.build(CostcardlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CostcardlogVO doCreate(CostcardlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CostcardlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CostcardlogVO doUpdate(CostcardlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CostcardlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CostcardlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CostcardlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
