package com.gmcc.pboss.biz.info.way.service.impl;

import com.gmcc.pboss.biz.info.way.dao.WayDao;
import com.gmcc.pboss.biz.info.way.service.WayService;
import com.gmcc.pboss.biz.info.way.support.WayQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class WayServiceImpl extends BaseServiceImpl implements WayService {

	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public WayServiceImpl(){
		super();
		this.serviceCode = ServiceCode.WAY_DETAILS;
		this.serviceName = "������ϸ��ѯ";
		isNeedLogin = true;// ��Ҫ��¼
	}
	private WayDao wayDetailDao;
	
	public WayDao getWayDetailDao() {
		return wayDetailDao;
	}

	public void setWayDetailDao(WayDao wayDetailDao) {
		this.wayDetailDao = wayDetailDao;
	}
	
	/**
	 * ��ѯ-������ϸ��Ϣ��HQL��ѯ
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new WayQueryParameterProcessor());
		QueryResult queryResult = this.wayDetailDao.getAll(this.getProcessor(),parameter);

		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}

}
