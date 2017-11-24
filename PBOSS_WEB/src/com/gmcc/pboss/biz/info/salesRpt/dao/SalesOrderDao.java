package com.gmcc.pboss.biz.info.salesRpt.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sales.FxSwOrder;

public interface SalesOrderDao extends BaseDao {
	/**
	 * 获取当月已经提交订单条数，不含用户取消的订单
	 * 默认时间限制是查询发生当月，通过获取系统时间实现
	 * 不统计CANCEL的订单
	 * @param code  合作商编码
	 * @return 当月有效订单数目
	 */
	public int getNumbers(String code);
	
	/**
	 * 根据ORDERID获取订单
	 * @param 订单ID
	 * @return 
	 */
	public FxSwOrder getById(String orderid);
}
