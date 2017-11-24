/**
* auto-generated code
* Fri May 27 12:04:23 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.tax;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxVO;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxListVO;
import com.sunrise.boss.business.cms.reward.tax.control.TaxControlBean;
import com.sunrise.boss.business.cms.reward.tax.control.TaxControl;

import java.io.Serializable;

/**
 * <p>Title: TaxDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class TaxDelegate {

    private static TaxControl control;

    public TaxDelegate() throws Exception {
        control = (TaxControl) ControlFactory.build(TaxControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public TaxVO doCreate(TaxVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(TaxVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public TaxVO doUpdate(TaxVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public TaxVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (TaxVO) control.doFindByPk(pk, user);
    }
    
    public TaxVO doFindByPk2(Serializable pk, User user)
	    throws Exception {
	    return (TaxVO) control.doFindByPk2(pk, user);
    }

    public DataPackage doQuery(TaxListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
