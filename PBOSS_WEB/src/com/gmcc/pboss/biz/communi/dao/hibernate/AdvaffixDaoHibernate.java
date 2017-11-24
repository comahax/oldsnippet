package com.gmcc.pboss.biz.communi.dao.hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.communi.dao.AdvaffixDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.communi.ChPwAdvaffix;

public class AdvaffixDaoHibernate extends BaseDaoHibernate implements AdvaffixDao {

	public AdvaffixDaoHibernate() {
		super(ChPwAdvaffix.class);
	}
	
	public List<ChPwAdvaffix> doQueryAffixByAdvinfoid(Long advinfoid) {
		List<ChPwAdvaffix> result = new ArrayList<ChPwAdvaffix>();
		Query query = getSession().
						getNamedQuery("com.gmcc.pboss.model.communi.queryAffixByAdvinfoid").
							setLong("advinfoid", advinfoid);
		result = query.list();
		return result;
	}
}
