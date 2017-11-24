package com.gmcc.pboss.business.promotion.pquantity;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.common.utils.tools.BusinessUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class PromotionPquantityDAO extends AbstractDAO{

	 /**
     * default constructor
     */
	public PromotionPquantityDAO() {
		super(PartnerresVO.class);
	}

	 /**
     * 统计上个月各个渠道的套卡激活量
     * @return
     * @throws Exception
     */
    public Map<String,BigDecimal> statActiveSMPLastMonth() throws Exception{
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String,BigDecimal> resultMap = new HashMap<String,BigDecimal>();
		String sql = "select WAYID,count(*) inActiveQuantity " +
					 "from FX_SW_PARTNERRES where RESTYPE = 'COMRESSMP' and " +
					 "ISACTIVE = 1 AND ACTTIME >= ? group by WAYID";
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sql);
			Date firstDayOfLastMonth = BusinessUtils.getLastMonthFirstDay(getCurrentTime());
			
			pstmt.setTimestamp(1, new Timestamp(firstDayOfLastMonth.getTime()));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultMap.put(rs.getString(1), rs.getBigDecimal(2));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			if(pstmt!= null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw e;
				}
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					throw e;
				}
		}
    	return resultMap;
    }
}
