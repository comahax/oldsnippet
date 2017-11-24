package com.gmcc.pboss.business.resource.wayrcstat;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class WayrcstatDAO extends AbstractDAO {

	public WayrcstatDAO() {
//		this.setVoClass(WayrcstatVO.class);
	}
	
	public DataPackage queryReal(DBQueryParam param) throws Exception {
		return queryByNamedSqlQuery("com.gmcc.pboss.business.resource.wayrcstat.doQueryreal", param);
	}
	
	public DataPackage queryHistory(DBQueryParam param) throws Exception {
		return queryByNamedSqlQuery("com.gmcc.pboss.business.resource.wayrcstat.doQueryhistory", param);
	}
	
//	public DataPackage queryByNamedSqlQuery(String name,Object param, String dbFlag) throws Exception {
//		
//		Hibernate3BaseDAO dao = (Hibernate3BaseDAO) this.getDelegateDAO();
//		Session session = (Session) dao.getCurrentSession();
//		
//		WayrcstatDBParam dbparam = (WayrcstatDBParam) param;
//		
//		SQLQuery query = (SQLQuery)session.getNamedQuery(name);
//		
//		query.setParameter(":cityid_1", dbFlag);
//		query.setParameter(":cityid_2", dbFlag);
//		query.setParameter(":cityid_3", dbFlag);
//		
//		String queryString = query.getQueryString();
//		
//		return dao.queryBySql(queryString, param, QUERY_TYPE_ALL, name);
//	}
}
