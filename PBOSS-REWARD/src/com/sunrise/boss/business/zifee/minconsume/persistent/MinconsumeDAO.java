/**
 * auto-generated code
 * Fri Aug 08 14:58:15 CST 2008
 */
package com.sunrise.boss.business.zifee.minconsume.persistent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: MinconsumeDAO
 * </p>
 * <p>
 * Description: Data Access Object for MinconsumeVO
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
public class MinconsumeDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public MinconsumeDAO() {
		super(MinconsumeVO.class);
	}

	public boolean hasCyclecount(String yxplanid) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		Connection conn = session.connection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from PC_PS_MINCONSUME where CYCLECOUNT < 1 and (yxplanid like '%"
					+ yxplanid + "%')";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {

		}
	}
//	public static void main(String []args)
//	{
//		String yxplanid="abc";
//		String sql = "select * from PC_PS_MINCONSUME where CYCLECOUNT < 1 and (yxplanid like '%"
//			+ yxplanid + "%')";
//		System.out.println(sql);
//	}
}
