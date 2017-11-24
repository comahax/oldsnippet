package com.sunrise.jop.infrastructure.sysadmin;

import org.apache.commons.lang.builder.*;

/**
 * ×Ö·û´®·ç¸ñ
 * @author He Kun (Sunrise,Guangzhou, CN)
 *
 */
public class ManageLogToStringStyle extends ToStringStyle {
	
	public static final ToStringStyle MANAGE_LOG_STYLE = new ManageLogToStringStyle();

	public ManageLogToStringStyle() {
		super();
		this.setUseClassName(false);
		this.setUseIdentityHashCode(false);
	}
}
