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
		this.serviceName = "月套卡激活量统计查询";
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
		
		Assert.isTrue(RegactStatisticsQueryParameter.class.isAssignableFrom(parameter.getClass()), ServiceConditionCode.REGACT_PARAMETER_TYPE, "参数对象类型不匹配");

		int actualActived = regactStatisticsDao.getActualActivedQuantity((RegactStatisticsQueryParameter) parameter);//实际激活量
		int validActived = regactStatisticsDao.getValidActivedQuantity((RegactStatisticsQueryParameter) parameter);//有效激活量
		int rewardActived = regactStatisticsDao.getRewardActivedQuantity((RegactStatisticsQueryParameter) parameter);//符合计酬激活量

		ArrayList regactStatisticsList = new ArrayList();
		/*
		 * actualActived 实际激活量  validActived 有效激活量 rewardActived 符合计酬激活量
		 */
		regactStatisticsList.add(new RegactStatistics(actualActived, validActived, rewardActived));

		QueryResult result = new QueryResult(Page.EMPTY, regactStatisticsList);

		return result;
	}

}
