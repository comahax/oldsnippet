package com.gmcc.pboss.biz.info.rewardtd.settlementmonth.dao.hibernate;

import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.dao.SettlementMonthDao;
import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support.SettlementMonth;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;

public class SettlementMonthDaoHibernate extends BaseHqlQueryDao  implements SettlementMonthDao{
	
	public SettlementMonthDaoHibernate() {
		super(SettlementMonth.class);
	}   
	

}
