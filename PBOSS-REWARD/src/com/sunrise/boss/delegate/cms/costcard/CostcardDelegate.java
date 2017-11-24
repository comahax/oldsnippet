/**
* auto-generated code
* Fri May 02 07:02:06 CST 2008
*/
package com.sunrise.boss.delegate.cms.costcard;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.costcard.control.CostcardControl;
import com.sunrise.boss.business.cms.costcard.control.CostcardControlBean;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardVO;
import com.sunrise.boss.business.cms.costcard.persistent.CostcardListVO;

import java.io.Serializable;

/**
 * <p>Title: CostcardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CostcardDelegate {

    private static CostcardControl control;

    public CostcardDelegate() throws Exception {
        control = (CostcardControl) ControlFactory.build(CostcardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CostcardVO doCreate(CostcardVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CostcardVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CostcardVO doUpdate(CostcardVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CostcardVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CostcardVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CostcardListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
