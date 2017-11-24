package com.gmcc.pboss.control.sales.realtimemt;

import java.util.List;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface RealTimeOrder extends AbstractControl {

	public void process() throws Exception;
	// Edit by zhangsiwei for [BOSS（CR_ZQ20100611_1051316 PBOSS系统肇庆红黄绿分配方案）需求概要设计]
	public void doUpdateRealtimeOrder(String wayId,List<DictitemVO> brands) throws Exception;
}
