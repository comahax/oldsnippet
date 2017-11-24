/**
* auto-generated code
* Wed Oct 18 16:15:34 CST 2006
*/
package com.sunrise.boss.delegate.cms.provincialright;

import com.sunrise.boss.business.cms.provincialright.control.ProvincialrightControl;
import com.sunrise.boss.business.cms.provincialright.control.ProvincialrightControlBean;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: PostinfologDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class ProvincialrightDelegate {

    private static ProvincialrightControl control;
    
    public ProvincialrightDelegate() throws Exception {
		control = (ProvincialrightControl) ControlFactory
				.build(ProvincialrightControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}
    
	public DataPackage doQuery(ProvincialrightListVO params, User user)
	throws Exception {
		return control.doQuery(params, user);
}

	public boolean checkPurview(User user, String PurviewId)
			throws Exception {
		return control.checkPurview(user,PurviewId);
	}

}
