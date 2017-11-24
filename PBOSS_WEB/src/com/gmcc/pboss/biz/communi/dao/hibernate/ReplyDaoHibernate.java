package com.gmcc.pboss.biz.communi.dao.hibernate;

import com.gmcc.pboss.biz.communi.dao.ReplyDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.communi.ChPwReply;

public class ReplyDaoHibernate extends BaseDaoHibernate implements ReplyDao {

	public ReplyDaoHibernate() {
		super(ChPwReply.class);
	}
	
//	public QueryResult doQueryReplys(CommunicatePlateauParameter parameter) {
//		List<ChPwReply> replys = new ArrayList<ChPwReply>();
//		Query query = getSession().
//						getNamedQuery("com.gmcc.pboss.model.communi.queryReplys").
//							setLong("advinfoid", parameter.getAdvinfoid()).
//								setString("employeeid", parameter.getEmployeeid());
//		result = query.list();
//		return result;
//		
//	}

}
