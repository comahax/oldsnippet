package com.gmcc.pboss.biz.communi.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.communi.dao.CommunicatePlateauDao;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;

public class CommunicatePlateauDaoHibernate extends BaseHqlQueryDao implements CommunicatePlateauDao {

	public CommunicatePlateauDaoHibernate() {
		super(ChPwAdvinfo.class);
	}
	
	public ChPwRcvobj getRcvobjByIds(CommunicatePlateauParameter parameter) {
		ChPwRcvobj rcvobj = null;
		Query query = getSession().
						getNamedQuery("com.gmcc.pboss.model.communi.queryRcvobjByIds").
							setLong("advinfoid", parameter.getAdvinfoid().longValue())
								.setString("employeeid", parameter.getEmployeeid());
		rcvobj = (ChPwRcvobj)query.uniqueResult();
		return rcvobj;
	}
	/**
	 * 获取地市沟通平台中的公开信息
	 * @param maxRows
	 * @return
	 */
	public List<ChPwAdvinfo> queryCityPublicInfo(int maxRows) {
		List<ChPwAdvinfo> result = new ArrayList<ChPwAdvinfo>();
		Query query = getSession().
						getNamedQuery("com.gmcc.pboss.model.communi.queryCityPublicInfo").
							setDate("curDate", new java.util.Date());
		query.setFirstResult(0);
		query.setMaxResults(maxRows);
		result = query.list();
		return result;
	}
}
