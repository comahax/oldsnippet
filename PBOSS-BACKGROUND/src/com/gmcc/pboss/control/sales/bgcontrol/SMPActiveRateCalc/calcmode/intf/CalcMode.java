package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.intf;

import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * 套卡激活率计算模式接口
 * @author zsw
 * @date 2010-03-18
 */
public interface CalcMode {

	public void doSMPActiveRateCalc(DBAccessUser user) throws Exception;
}
