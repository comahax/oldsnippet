/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.business.cms.operation.persistent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;

/**
 * <p>
 * Title: OperationDAO
 * </p>
 * <p>
 * Description: Data Access Object for OperationVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class OperationDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public OperationDAO() {
		super(OperationVO.class);
	}

	public DataPackage check(OperationListVO params) throws Exception {
		return queryByNamedSqlQuery("cms.operation.check", params);
	}

	public List doQueryupper(OperationListVO params) throws Exception {
		Session session = SessionUtil.currentSession(this.getDbFlag());
		Query query = session.getNamedQuery("cms.operation.queryupper");
		query.setString("id", params.get_se_opnid());
		query.setString("name", "%" + params.get_sk_name() + "%");
		List list = query.list();
		return list;
	}

	public String getFifthStr() throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		Connection conn = session.connection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select lpad(count(opnid)+1,5,'0')  from common.ch_pw_operation where isbusi=1";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String reStr = rs.getString(1);
				return reStr;
			} else {
				throw new Exception("SQL Óï¾ä²éÑ¯³ö´í!");
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {

		}
	}

	public DataPackage doQueryOperation(OperationListVO operationListVO) throws Exception {
		return this.queryByNamedSqlQuery("cms.operation.queryoperation",
				operationListVO);
	}
}