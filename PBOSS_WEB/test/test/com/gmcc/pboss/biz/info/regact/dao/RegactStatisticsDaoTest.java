package test.com.gmcc.pboss.biz.info.regact.dao;

import com.gmcc.pboss.biz.info.regactInfo.dao.RegactStatisticsDao;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactStatisticsQueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class RegactStatisticsDaoTest extends BaseTest {

	private RegactStatisticsDao regactStatisticsDao;

	public RegactStatisticsDao getRegactStatisticsDao() {
		return regactStatisticsDao;
	}

	public void setRegactStatisticsDao(RegactStatisticsDao regactStatisticsDao) {
		this.regactStatisticsDao = regactStatisticsDao;
	}
	
	public void testGetValidActivedQuantity() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RegactStatisticsQueryParameter parameter = new RegactStatisticsQueryParameter();
		parameter.setMonth("200908");
		parameter.setWayid("CH_2323");
		System.out.println(regactStatisticsDao.getValidActivedQuantity(parameter));
	}

}
