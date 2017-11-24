package com.gmcc.pboss.biz.info.servcent.service.impl;

import com.gmcc.pboss.biz.info.servcent.dao.ServcentDao;
import com.gmcc.pboss.biz.info.servcent.service.ServcentService;
import com.gmcc.pboss.biz.info.servcent.support.ServcentQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class ServcentServiceImpl extends BaseServiceImpl implements ServcentService {

	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public ServcentServiceImpl(){
		super();
		this.serviceCode = ServiceCode.SERVCENT_DETAILS;
		this.serviceName = "���۷������Ĳ�ѯ";
		isNeedLogin = true;// ��Ҫ��¼
	}
	
	private ServcentDao servcentDao;

	public ServcentDao getServcentDao() {
		return servcentDao;
	}

	public void setServcentDao(ServcentDao servcentDao) {
		this.servcentDao = servcentDao;
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
		this.setProcessor(new ServcentQueryParameterProcessor());
		QueryResult queryResult = this.servcentDao.getAll(this.getProcessor(),parameter);

		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
}
