package com.gmcc.pboss.control.sales.bgcontrol.autobossinaccount;


import org.apache.log4j.Logger;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public interface AutoBossInAccount extends AbstractControl {

	//订单自动入账处理
	public void process(DataPackage dp,User user,Logger log) throws Exception;

}
