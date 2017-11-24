package com.gmcc.pboss.biz.info.regactInfo.service.impl;

import java.util.ArrayList;

import com.gmcc.pboss.biz.info.regactInfo.dao.RegactStatisticsDao;
import com.gmcc.pboss.biz.info.regactInfo.service.RegactStatisticsService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatistics;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatisticsQueryParameter;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

public class RegactStatisticsServiceImpl extends QueryBaseServiceImpl implements RegactStatisticsService {

	public RegactStatisticsServiceImpl() {
		this.serviceCode = ServiceCode.REGACT_TOTAL;
		this.serviceName = "���׿�������ͳ�Ʋ�ѯ";
		this.isNeedLogin = true;
	}

	private RegactStatisticsDao regactStatisticsDao;

	public RegactStatisticsDao getRegactStatisticsDao() {
		return regactStatisticsDao;
	}

	public void setRegactStatisticsDao(RegactStatisticsDao regactStatisticsDao) {
		this.regactStatisticsDao = regactStatisticsDao;
	}

	public QueryResult getAll(QueryParameter parameter) {
		
		Assert.isTrue(RegactStatisticsQueryParameter.class.isAssignableFrom(parameter.getClass()), ServiceConditionCode.REGACT_PARAMETER_TYPE, "�����������Ͳ�ƥ��");

		int actualActived = regactStatisticsDao.getActualActivedQuantity((RegactStatisticsQueryParameter) parameter);//ʵ�ʼ�����
		int validActived = regactStatisticsDao.getValidActivedQuantity((RegactStatisticsQueryParameter) parameter);//��Ч������
		int rewardActived = regactStatisticsDao.getRewardActivedQuantity((RegactStatisticsQueryParameter) parameter);//���ϼƳ꼤����

		ArrayList regactStatisticsList = new ArrayList();
		/*
		 * actualActived ʵ�ʼ�����  validActived ��Ч������ rewardActived ���ϼƳ꼤����
		 */
		regactStatisticsList.add(new RegactStatistics(actualActived, validActived, rewardActived));

		QueryResult result = new QueryResult(Page.EMPTY, regactStatisticsList);

		return result;
	}

}
