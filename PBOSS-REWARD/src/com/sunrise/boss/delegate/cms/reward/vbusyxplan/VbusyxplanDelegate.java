/**
* auto-generated code
* Sun Aug 01 20:25:48 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.vbusyxplan;

import com.sunrise.boss.business.cms.reward.vbusyxplan.control.VbusyxplanControl;
import com.sunrise.boss.business.cms.reward.vbusyxplan.control.VbusyxplanControlBean;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: VbusyxplanDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class VbusyxplanDelegate {

    private static VbusyxplanControl control;

    public VbusyxplanDelegate() throws Exception {
        control = (VbusyxplanControl) ControlFactory.build(VbusyxplanControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DataPackage doQuery(VbusyxplanListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
