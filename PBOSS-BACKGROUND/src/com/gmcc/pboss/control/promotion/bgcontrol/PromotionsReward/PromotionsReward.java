package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsReward;

import java.util.Map;

import open.tool.rule.data.VO;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface PromotionsReward extends AbstractControl {

	/**
	 * 计算酬金结果，把结果保存到酬金明细表，并保存已促销渠道记录
	 * @param srcData
	 * @param pid
	 * @param ruleid
	 * @throws Exception
	 */
	public void doHandleReward(Map<VO,Object> srcData, long pid, long ruleid) throws Exception;
	
	/**
	 * 酬金促销方案模块入口方法
	 * @param pid
	 * @throws Exception
	 */
	public void doProcess(long pid) throws Exception;
}
