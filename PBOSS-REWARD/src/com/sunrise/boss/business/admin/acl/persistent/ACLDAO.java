package com.sunrise.boss.business.admin.acl.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;

public class ACLDAO {
	/**
	 * 
	 * @param opercode
	 *            Operator Id get From Session
	 * @param pageId
	 *            pageId eg:1A2B3C4D
	 * @return
	 */
	public boolean checkPermission(String opercode, String pageId) {
		return checkPermission(opercode, pageId, SysInfo.COMMON_DB_FLAG);
	}

	/**
	 * 
	 * @param opercode
	 *            Operator Id get From Session
	 * @param pageIdpageId
	 *            eg:1A2B3C4D
	 * @param dbFlag
	 *            the default is DB_COMMON
	 * @return
	 */
	private boolean checkPermission(String opercode, String pageId, String dbFlag) {
		boolean hasPerssion = false;

		String sql = "SELECT  operid, rightid "
				+ "FROM (SELECT operid, rightid "
				+ "       FROM SA_SR_OPERRIGHT "
				+ "      WHERE status = 1 AND operid=? AND rightid=?"
				+ "    UNION SELECT a.operid, b.rightid "
				+ "     FROM sa_sr_OperRole a, sa_sr_RoleRight b "
				+ "    WHERE a.status = 1 AND b.status = 1 "
				+ "          AND a.roleid = b.itemid "
				+ "          AND a.operid=?  AND rightid=? )"
				+ " ORDER BY operid, rightid";
		try {
			//SessionUtil.newSession();
			Session session = SessionUtil.currentSession(dbFlag);
			Connection conn = session.connection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, opercode);
			ps.setString(2, pageId);
			ps.setString(3, opercode);
			ps.setString(4, pageId);
//			ps.setString(5, opercode);
//			ps.setString(6, pageId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				hasPerssion = true;
			}
			ps.close();
			//session.disconnect();
			//SessionUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasPerssion;
	}
}
