/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.control.communication.pendingtask;

import java.util.Date;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * <p>
 * Title: Advinfo
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public interface Pendingtask extends AbstractControl {
	public void doCreate(String title, String url, String desttype,
			String objid, Short smsnotify, String oprcode, Date releasetime,
			Date plantime) throws Exception;
}
