/**
 * auto-generated code
 * Sun Jan 04 10:44:26 CST 2009
 */
package com.sunrise.boss.business.cms.reward.busiwayrel.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: BusiwayrelDAO
 * </p>
 * <p>
 * Description: Data Access Object for BusiwayrelVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BusiwayrelDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public BusiwayrelDAO() {
		super(BusiwayrelVO.class);
	}

	/**
	 * 查询符合条件的OPNID
	 */
	public String[] getOpnid(String opnid, String sqlName) throws Exception {
		String[] res = null;
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery query = (SQLQuery) session.getNamedQuery(sqlName);
		String queryString = query.getQueryString();
		Connection conn = session.connection();
		PreparedStatement ps = conn.prepareStatement(queryString);
		ps.setString(1, opnid);
		ResultSet rs = ps.executeQuery();
		String str = "";
		while (rs.next()) {
			str += rs.getString(1) + ",";
		}
		if (!"".equals(str)) {
			str = str.substring(0, str.length() - 1);
			// if(str)
			res = StringUtils.splitPreserveAllTokens(str, ",");
		}
		ps.close();
		return res;
	}

	public static void main(String[] args) {
		String str = "aa,bb,";
//		System.out.println(str.substring(0, str.length() - 1));
	}
}
