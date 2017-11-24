/**
 * auto-generated code
 * Mon Sep 14 14:51:11 CST 2009
 */
package com.gmcc.pboss.business.promotion.spproposal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import open.tool.rule.data.VO;

import org.hibernate.Session;

import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: SpproposalDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SpproposalDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public SpproposalDAO() {
		super(SpproposalVO.class);
	}

	/**
	 * 返回“参与者”、“商品种类”及“促销资源”笛卡尔积
	 * @return
	 */
	public Map<VO, Object> getDescartesMap() throws Exception {
		Session session = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pt.WAYID,pc.COMCATEGORY,pr.RESID from CH_CX_PPZLNPTNR pt "
				+ "cross join CH_CX_PPZLNCOM pc cross join CH_CX_PPZLNRES pr";
		Map<VO, Object> resultMap = new HashMap<VO, Object>();
		try {
			session = SessionUtils.currentSession(getDbFlag());
			conn = session.connection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DefaultVO vo = new DefaultVO();
				HashMap<String, Object> keys = new HashMap<String, Object>();
				keys.put("WAYID", rs.getString("WAYID"));
				keys.put("COMCATEGORY", rs.getString("COMCATEGORY"));
				keys.put("RESID", rs.getString("RESID"));
				vo.setKeys(keys);
				// 业务量设为null
				vo.setValue(null);
				resultMap.put(vo, null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
		}
		return resultMap;
	}
}
