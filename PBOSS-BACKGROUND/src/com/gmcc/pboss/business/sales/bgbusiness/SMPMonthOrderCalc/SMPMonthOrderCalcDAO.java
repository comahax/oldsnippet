package com.gmcc.pboss.business.sales.bgbusiness.SMPMonthOrderCalc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoVO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class SMPMonthOrderCalcDAO extends AbstractDAO {

	public SMPMonthOrderCalcDAO() {
		super(MonorderinfoVO.class);
	}
	
	/**
	 * 删除month指定月份的订购量数据
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public int deleteMonthOrder(String month) throws Exception{
		
		Session session = SessionUtils.currentSession();
		String delSql = "delete from MonorderinfoVO where MONTH = :month";
		int deleteRow = 0;
		try {
			deleteRow = session.createQuery(delSql)
							.setString("month", month)
							.executeUpdate();
			
		}catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return deleteRow;
    }
    
    /**
     * 获取 在months指定月份中发生订购业务的所有渠道的套卡品牌的总激活量
     * @param months
     * @param cityid
     * @return 映射中的 key = PartnerSMPBrandVO(包含渠道id和套卡品牌); value = 总月份数|总激活量|渠道星级
     * @throws Exception
     */
    public Map<PartnerSMPBrandVO,String> statMonthOrder(String[] months,String cityid) throws Exception{
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int paramIndex = 0;
		Map<PartnerSMPBrandVO,String> resultMap = new HashMap<PartnerSMPBrandVO,String>();
		StringBuffer sql = new StringBuffer();
		sql.append("select m.wayid,m.brand,max(w.starlevel),count(distinct(month)),NVL(sum(actamt),0) ").
		    append("from FX_SW_MONORDERINFO m inner join CH_PW_WAY w on m.wayid = w.wayid ")
		    .append("where w.waytype = 'AG' and w.cityid = ? ");
		for(int i=0;i<months.length;i++) {
			if(i == 0) {
				sql.append(" and ( month = ? ");
			}else if(i < months.length - 1){
				sql.append(" or month = ? ");
			}
			if(i == months.length - 1) {
				sql.append(" or month = ? ) ");
			}
		}
		sql.append(" group by  m.wayid,m.brand");
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(++paramIndex, cityid);
			for(int i=0;i<months.length;i++) {
				pstmt.setString(++paramIndex,months[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String wayid = rs.getString(1);
				String brand = rs.getString(2);
				BigDecimal starlevel = rs.getBigDecimal(3);
				BigDecimal totalMonths = rs.getBigDecimal(4);
				BigDecimal totalActiveAmt = rs.getBigDecimal(5);
				
				resultMap.put(new PartnerSMPBrandVO(wayid,brand), totalMonths+"|"+totalActiveAmt+"|"+starlevel);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
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
