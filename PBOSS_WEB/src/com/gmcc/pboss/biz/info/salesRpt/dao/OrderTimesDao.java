package com.gmcc.pboss.biz.info.salesRpt.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sales.FxSwOrdertimes;

public interface OrderTimesDao extends BaseDao {
	/**
	 * ��󶩹�������ѯ
	 * @param type Լ�����ͣ�����APPWAY��
	 * @param code Լ�����󣨺����̱��룩
	 * @return ��Ӧ���ݿ���е�һ����¼������������ maxtimes
	 */
	public FxSwOrdertimes getForMaxtiems(String type,String code);
}
