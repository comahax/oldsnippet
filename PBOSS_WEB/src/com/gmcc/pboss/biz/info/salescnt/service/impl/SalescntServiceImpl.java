package com.gmcc.pboss.biz.info.salescnt.service.impl;

import java.util.ArrayList;

import com.gmcc.pboss.biz.info.salescnt.dao.SalescntDao;
import com.gmcc.pboss.biz.info.salescnt.service.SalescntService;
import com.gmcc.pboss.biz.info.salescnt.support.Salescnt;
import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

public class SalescntServiceImpl extends QueryBaseServiceImpl implements SalescntService {

	public SalescntServiceImpl() {
		//����ҵ���������
		serviceName = "���ۻ��ܲ�ѯ";
		serviceCode = ServiceCode.SALES_TOTAL;
		isNeedLogin = true;
	}
	
	private SalescntDao salescntDao;

	public SalescntDao getSalescntDao() {
		return salescntDao;
	}
	
	public void setSalescntDao(SalescntDao salescntDao) {
		this.salescntDao = salescntDao;
	}
	
	public QueryResult getAll(QueryParameter parameter) {
		
		Assert.isTrue(SalescntQueryParameter.class.isAssignableFrom(parameter.getClass()), ServiceConditionCode.REGACT_PARAMETER_TYPE, "�����������Ͳ�ƥ��");

		int resimCnt = salescntDao.getRegistersimCnt((SalescntQueryParameter) parameter);// �׿���������
		
		int renewCnt = salescntDao.getRegisternewCnt((SalescntQueryParameter) parameter);// ��ҵ����������
		
		ArrayList list = new ArrayList();
		list.add(new Salescnt("�׿�����", resimCnt));
		list.add(new Salescnt("��ҵ������", renewCnt));

		QueryResult result = new QueryResult(Page.EMPTY, list);

		return result;
	}
}
