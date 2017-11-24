package com.gmcc.pboss.biz.info.regactInfo.dao;

import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatisticsQueryParameter;

public interface RegactStatisticsDao {

	/**
	 * ʵ�ʼ�����
	 */
	public int getActualActivedQuantity(RegactStatisticsQueryParameter parameter);

	/**
	 *��Ч������
	 */
	public int getValidActivedQuantity(RegactStatisticsQueryParameter parameter);

	/**
	 * ���ϼƳ꼤����
	 */
	public int getRewardActivedQuantity(RegactStatisticsQueryParameter parameter);

}
