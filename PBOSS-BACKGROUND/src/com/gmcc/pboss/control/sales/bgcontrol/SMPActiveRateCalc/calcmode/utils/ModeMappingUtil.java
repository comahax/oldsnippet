package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * �׿������ʼ���ģʽ������ӳ��
 * @author zsw
 *
 */
public class ModeMappingUtil {

	private static final Map<String,String> modeMap = new HashMap<String,String>();
	static {
		modeMap.put("GENERAL", "com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.impl.GeneralCalcMode");
		modeMap.put("STDSTOCK", "com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.impl.StdStockCalcMode");
		modeMap.put("BUILDUP", "com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.impl.BuildupCalcMode");
	}
	
	public static String getModeClass(String modename) {
		return modeMap.get(modename);
	}
}
