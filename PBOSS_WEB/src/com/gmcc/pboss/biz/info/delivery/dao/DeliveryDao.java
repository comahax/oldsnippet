package com.gmcc.pboss.biz.info.delivery.dao;

import java.util.List;

import com.gmcc.pboss.biz.info.delivery.bean.OrderPackageInfo;
import com.gmcc.pboss.biz.info.delivery.bean.OrderState;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.model.sales.FxSwOrdercomcate;
import com.gmcc.pboss.model.sales.FxSwOrderresdet;

public interface DeliveryDao extends BaseDao {

	/**
	 * 用HQL进行连表查询 返回唯一的结果
	 * @param processor 使用DefaultHqlQueryProcessor的子类提取HQL的操作
	 * @param parameter 查询参数
	 * @return
	 */
	public Object getOne(QueryParameterProcessor processor, QueryParameter parameter);
	
	/**
	 * 提取订单信息
	 * @param orderId 订单ID
	 * @return
	 */
	public List<OrderState> getOrderInfo(String orderId);

	/**
	 * 提取订单商品种类明细
	 * @param orderId
	 * @return
	 */
	public List<FxSwOrdercomcate> getOrderComcateDtl(String orderId);
	
	/**
	 * 按订单ID、商品种类和订单类型返回批次等信息
	 * @param orderId
	 * @param ordercomtype
	 * @param category
	 * @return
	 */
	public List<OrderPackageInfo> getOrderBatchNoDtl(String orderId,String ordercomtype,String category);
	
	/**
	 * 按订单ID、商品种类和订单类型返回最大值、最小值等信息
	 * @param orderId
	 * @param ordercomtype
	 * @param category
	 * @return
	 */
	public OrderPackageInfo getMaxMinDtl(String orderId,String ordercomtype,String category);
	/**
	 * 按订单ID和配送商编码返回配送单列表
	 * @param orderId
	 * @return
	 */
	public List<FxSwDisform> getFxSwDisform(String orderId,String discomcode);
	/**
	 * 按渠道取店主
	 * @param wayid
	 * @return
	 */
	public Employee getWayNetEmployee(String wayid);
	
	/**
	 * 按配送单号和配送商编码获取配送单信息
	 * @param recid
	 * @param discomcode
	 * @return
	 */
	public FxSwDisform getDisform(Long recid,String discomcode);
}
