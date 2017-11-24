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
	 * ��HQL���������ѯ ����Ψһ�Ľ��
	 * @param processor ʹ��DefaultHqlQueryProcessor��������ȡHQL�Ĳ���
	 * @param parameter ��ѯ����
	 * @return
	 */
	public Object getOne(QueryParameterProcessor processor, QueryParameter parameter);
	
	/**
	 * ��ȡ������Ϣ
	 * @param orderId ����ID
	 * @return
	 */
	public List<OrderState> getOrderInfo(String orderId);

	/**
	 * ��ȡ������Ʒ������ϸ
	 * @param orderId
	 * @return
	 */
	public List<FxSwOrdercomcate> getOrderComcateDtl(String orderId);
	
	/**
	 * ������ID����Ʒ����Ͷ������ͷ������ε���Ϣ
	 * @param orderId
	 * @param ordercomtype
	 * @param category
	 * @return
	 */
	public List<OrderPackageInfo> getOrderBatchNoDtl(String orderId,String ordercomtype,String category);
	
	/**
	 * ������ID����Ʒ����Ͷ������ͷ������ֵ����Сֵ����Ϣ
	 * @param orderId
	 * @param ordercomtype
	 * @param category
	 * @return
	 */
	public OrderPackageInfo getMaxMinDtl(String orderId,String ordercomtype,String category);
	/**
	 * ������ID�������̱��뷵�����͵��б�
	 * @param orderId
	 * @return
	 */
	public List<FxSwDisform> getFxSwDisform(String orderId,String discomcode);
	/**
	 * ������ȡ����
	 * @param wayid
	 * @return
	 */
	public Employee getWayNetEmployee(String wayid);
	
	/**
	 * �����͵��ź������̱����ȡ���͵���Ϣ
	 * @param recid
	 * @param discomcode
	 * @return
	 */
	public FxSwDisform getDisform(Long recid,String discomcode);
}
