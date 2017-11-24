package com.gmcc.pboss.biz.info.salesRpt.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sales.FxSwOrdertimes;

public interface OrderTimesDao extends BaseDao {
	/**
	 * 最大订购次数查询
	 * @param type 约束类型（渠道APPWAY）
	 * @param code 约束对象（合作商编码）
	 * @return 对应数据库表中的一条记录，含最大次数项 maxtimes
	 */
	public FxSwOrdertimes getForMaxtiems(String type,String code);
}
