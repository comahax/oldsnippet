package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.intf;

import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * �׿������ʼ���ģʽ�ӿ�
 * @author zsw
 * @date 2010-03-18
 */
public interface CalcMode {

	public void doSMPActiveRateCalc(DBAccessUser user) throws Exception;
}
