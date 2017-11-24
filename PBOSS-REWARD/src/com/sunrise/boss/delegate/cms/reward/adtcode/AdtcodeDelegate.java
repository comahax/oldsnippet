/**
* auto-generated code
* Sat Feb 02 14:33:50 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.adtcode;

import com.sunrise.boss.business.cms.reward.adtcode.control.AdtcodeControl;
import com.sunrise.boss.business.cms.reward.adtcode.control.AdtcodeControlBean;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: FaildataqueryDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdtcodeDelegate {

    private static AdtcodeControl control;

    public AdtcodeDelegate() throws Exception {
        control = (AdtcodeControl) ControlFactory.build(AdtcodeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public DataPackage doQuery(AdtcodeListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
