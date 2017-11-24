/**
 * auto-generated code
 * Sun Feb 03 10:15:39 CST 2008
 */
package com.sunrise.boss.business.cms.resale2.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resale2.persistent.Resale2VO;
import com.sunrise.boss.business.cms.resale2.persistent.Resale2ListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: Resale2Control
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
public interface Resale2Control extends AbstractControl {
	public String doQuery(String mobile, User user)
			throws Exception;

}
