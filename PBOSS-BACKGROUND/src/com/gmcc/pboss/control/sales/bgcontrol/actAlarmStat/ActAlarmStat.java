package com.gmcc.pboss.control.sales.bgcontrol.actAlarmStat;

import java.util.Map;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface ActAlarmStat extends AbstractControl {

	/**
	 * ���㼤����Ԥ����ڲ���
	 * 
	 * @throws Exception
	 */
	public void doProcess() throws Exception;

	/**
	 * 
	 * @param actAlarmStatMap
	 * @param statType
	 * @param yearMonth
	 * @throws Exception
	 */
	public void doInsertActAlarmStat(
			Map<PartnerSMPBrandVO, Object[]> actAlarmStatMap, String statType,
			String yearMonth) throws Exception;
}
