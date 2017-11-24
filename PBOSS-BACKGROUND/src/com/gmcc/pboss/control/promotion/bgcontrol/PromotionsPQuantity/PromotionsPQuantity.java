package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPQuantity;

import java.math.BigDecimal;
import java.util.Map;

import open.tool.rule.data.VO;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface PromotionsPQuantity  extends AbstractControl{

	/**
     * 统计上个月各个渠道的套卡激活量
     * @return
     * @throws Exception
     */
	public Map<String, BigDecimal> doStatActiveSMPLastMonth()
		throws Exception ;
	
	/**
	 * 计算提升订货量，把结果保存到“订货量提升明细”表中，并保存已促销渠道记录
	 * 
	 * @param srcData
	 * @param pid
	 * @param ruleid
	 * @param cityid
	 * @throws Exception
	 */
	public void doHandlePQuantity(Map<VO, Object> srcData, long pid, long ruleid) throws Exception;
	
	/**
	 * 订货量促销方案入口方法
	 * @param pid 方案标识
	 * @throws Exception
	 */
	public void doProcess(long pid) throws Exception;
}
