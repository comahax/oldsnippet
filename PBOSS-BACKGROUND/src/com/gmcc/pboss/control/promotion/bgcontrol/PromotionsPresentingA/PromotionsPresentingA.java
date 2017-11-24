package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPresentingA;

import java.util.Map;

import open.tool.rule.data.VO;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface PromotionsPresentingA extends AbstractControl {

	/**
	 * 计算最终赠送商品及赠送数量，保存于“赠送明细[CH_CX_PRESENTINGDTL]”表，并保存已促销渠道记录
	 * @param srcData
	 * @param pid
	 * @param ruleid
	 * @throws Exception
	 */
	public void doHandlePresentingA(Map<VO, Object> srcData, long pid, long ruleid) 
		throws Exception;
	
	/**
	 * 赠送（事后）促销方案模块入口方法
	 * @param pid 方案标识
	 * @throws Exception
	 */
	public void doProcess(long pid) throws Exception;
}
