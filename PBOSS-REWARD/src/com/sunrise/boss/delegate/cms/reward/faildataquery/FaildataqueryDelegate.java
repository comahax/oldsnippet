/**
* auto-generated code
* Sat Feb 02 14:33:50 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.faildataquery;

import com.sunrise.boss.business.cms.reward.adtcode.control.AdtcodeControl;
import com.sunrise.boss.business.cms.reward.adtcode.control.AdtcodeControlBean;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.business.cms.reward.faildataquery.control.FaildataqueryControl;
import com.sunrise.boss.business.cms.reward.faildataquery.control.FaildataqueryControlBean;
import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: FaildataqueryDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FaildataqueryDelegate {

    private static FaildataqueryControl control;

    public FaildataqueryDelegate() throws Exception {
        control = (FaildataqueryControl) ControlFactory.build(FaildataqueryControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public DataPackage doQuery(FaildataqueryListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
