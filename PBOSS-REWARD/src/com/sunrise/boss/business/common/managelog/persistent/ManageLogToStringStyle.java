package com.sunrise.boss.business.common.managelog.persistent;

import org.apache.commons.lang.builder.ToStringStyle;


public class ManageLogToStringStyle extends ToStringStyle {
	  public static final ToStringStyle MANAGE_LOG_STYLE = new
      ManageLogToStringStyle();

  public ManageLogToStringStyle() {
    super();
    this.setShortClassName(true);
    this.setUseClassName(false);
    this.setUseIdentityHashCode(false);
  }
}
