/**
 * auto-generated code
 * Mon Feb 04 12:03:22 CST 2008
 */
package com.sunrise.boss.delegate.cms.resale2;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resale2.control.Resale2Control;
import com.sunrise.boss.business.cms.resale2.control.Resale2ControlBean;
import com.sunrise.boss.business.cms.resale2.persistent.Resale2ListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: Rule2Delegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class Resale2Delegate {

	private static Resale2Control control;

	public Resale2Delegate() throws Exception {
		control = (Resale2Control) ControlFactory
				.build(Resale2ControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public String doQuery(String mobile, User user) throws Exception {
		return control.doQuery(mobile, user);
	}
}
