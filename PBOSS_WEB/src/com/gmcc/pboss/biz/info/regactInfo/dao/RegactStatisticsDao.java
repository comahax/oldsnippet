package com.gmcc.pboss.biz.info.regactInfo.dao;

import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatisticsQueryParameter;

public interface RegactStatisticsDao {

	/**
	 * 实际激活量
	 */
	public int getActualActivedQuantity(RegactStatisticsQueryParameter parameter);

	/**
	 *有效激活量
	 */
	public int getValidActivedQuantity(RegactStatisticsQueryParameter parameter);

	/**
	 * 符合计酬激活量
	 */
	public int getRewardActivedQuantity(RegactStatisticsQueryParameter parameter);

}
