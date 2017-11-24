package com.gmcc.pboss.business.base.acl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class ACLDAO extends AbstractDAO{
	
	/**
	 * 
	 * @param opercode
	 *            Operator Id get From Session
	 * @param pageId
	 *            pageId eg:1A2B3C4D
	 * @return
	 */
	public boolean checkPermission(String opercode, String pageId) {
		return checkPermission(opercode, pageId, CoreConfigInfo.COMMON_DB_NAME);
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
			
			Session session = SessionUtils.currentSession(dbFlag);
			Connection conn = session.connection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, opercode);
			ps.setString(2, pageId);
			ps.setString(3, opercode);
			ps.setString(4, pageId);
//			ÕÑÁ¼É¾³ýÁËSELECT operid, rightid
//            FROM SA_SR_OPERRIGHT
//            WHERE status = 1
//              AND flag = 0
//              AND operid = ?
//              AND rightid = ?)
//			ps.setString(5, opercode);
//			ps.setString(6, pageId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				hasPerssion = true;
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasPerssion;
	}
}
