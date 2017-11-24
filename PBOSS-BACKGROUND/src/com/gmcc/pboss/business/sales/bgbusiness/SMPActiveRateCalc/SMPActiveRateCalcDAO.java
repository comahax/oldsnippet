package com.gmcc.pboss.business.sales.bgbusiness.SMPActiveRateCalc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.common.utils.tools.BusinessUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class SMPActiveRateCalcDAO extends AbstractDAO{

	public SMPActiveRateCalcDAO() {
		super(PartnerresVO.class);
	}
	
	/**
     *  <p>用于7.5.38 套卡激活率计算</p>
     *  <p>不区分品牌</p>
     * 	<p>按照合作商编码分组统计合作商资源表（FX_SW_PARTNERRES）中某时间段里的未激活和已激活的套卡数量</p>
     * @param activeOrderDay   已激活套卡订购天数
     * @param activeDay        已激活套卡激活天数
     * @param inActiveOrderDay 未激活套卡订购天数
     * @return
     */
   
    public Map<String,String> statSMPNotWithBrand(int activeOrderDay,
			int activeDay,int inActiveOrderDay) throws Exception{
    	
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String,String> resultMap = new HashMap<String,String>();
		StringBuffer sbSql = new StringBuffer("");
		sbSql.append(	"select pr1.wayid,pr2.wayid,NVL(pr1.inActiveQuantity,0) inActiveQuantity,NVL(pr2.activeQuantity,0) activeQuantiy " +
						"from (select WAYID,count(1) inActiveQuantity " +
						"from FX_SW_PARTNERRES  where "); 
		if(inActiveOrderDay > 0) {
			sbSql.append(" CREATETIME >= sysdate - ? ").append(" and CREATETIME <= sysdate and ");
		}
		sbSql.append(" RESTYPE='COMRESSMP' and isactive = 0  group by wayid) pr1 full join (select WAYID,count(1) activeQuantity " +
				"from FX_SW_PARTNERRES where ");
		
		if(activeOrderDay > 0) {
			sbSql.append(" CREATETIME >= sysdate - ? ").append(" and CREATETIME <= sysdate and ");
		}
		if(activeDay > 0) {
			sbSql.append(" ACTTIME >= sysdate - ? ").append(" and ACTTIME <= sysdate and ");
		}
		sbSql.append(" RESTYPE='COMRESSMP' and isactive = 1  group by wayid) pr2 on pr1.wayid = pr2.wayid ");
		
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sbSql.toString());
			int paramIndex = 0;
			if(inActiveOrderDay > 0) {
				pstmt.setInt(++paramIndex, inActiveOrderDay);
			}
			if(activeOrderDay > 0) {
				pstmt.setInt(++paramIndex, activeOrderDay);
			}
			if(activeDay > 0) {
				pstmt.setInt(++paramIndex, activeDay);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String wayid = rs.getString(1)!=null?rs.getString(1):rs.getString(2);
				long inActiveQuantity = rs.getBigDecimal(3).longValue();
				long activeQuantity = rs.getBigDecimal(4).longValue();
				resultMap.put(wayid,activeQuantity+"|"+inActiveQuantity);
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
    
    /**
     * <p>用于7.5.38 套卡激活率计算</p>
     * <p>区分品牌</p>
     * <p>按照合作商编码、套卡品牌分组统计合作商资源表（FX_SW_PARTNERRES）中某时间段里的未激活和已激活的套卡数量</p>
     * @param activeOrderDay   已激活套卡订购天数
     * @param activeDay        已激活套卡激活天数
     * @param inActiveOrderDay 未激活套卡订购天数
     * @return
     */
    public Map<PartnerSMPBrandVO,Long[]> statSMPWithBrand(int activeOrderDay,
			int activeDay,int inActiveOrderDay) throws Exception{
    	
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<PartnerSMPBrandVO,Long[]> resultMap = new HashMap<PartnerSMPBrandVO,Long[]>();
		
		StringBuffer sbSql = new StringBuffer("");
		sbSql.append(	" select pr1.wayid,pr1.brand,pr2.wayid,pr2.brand,NVL(pr1.inActiveQuantity,0) inActiveQuantity,NVL(pr2.activeQuantity,0) activeQuantiy " +
						"from (select WAYID,brand,count(1) inActiveQuantity " +
						"from FX_SW_PARTNERRES  where ");
		if(inActiveOrderDay > 0) {
			sbSql.append(" CREATETIME >= sysdate - ? ").append(" and CREATETIME <= sysdate and ");
		}
		sbSql.append(" RESTYPE='COMRESSMP' and isactive = 0  group by wayid,brand) pr1 full join (select WAYID,brand,count(1) activeQuantity " +
				  "from FX_SW_PARTNERRES where ");
		if(activeOrderDay > 0) {
			sbSql.append(" CREATETIME >= sysdate - ? ").append(" and CREATETIME <= sysdate and ");
		}
		if(activeDay > 0) {
			sbSql.append(" ACTTIME >= sysdate - ? ").append(" and ACTTIME <= sysdate and ");
		}
		sbSql.append("  RESTYPE='COMRESSMP' and isactive = 1  group by wayid,brand) pr2 on pr1.wayid = pr2.wayid and pr1.brand = pr2.brand");
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sbSql.toString());
			int paramIndex = 0;
			if(inActiveOrderDay > 0) {
				pstmt.setInt(++paramIndex, inActiveOrderDay);
			}
			if(activeOrderDay > 0) {
				pstmt.setInt(++paramIndex, activeOrderDay);
			}
			if(activeDay > 0) {
				pstmt.setInt(++paramIndex, activeDay);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String wayid = rs.getString(1)!=null?rs.getString(1):rs.getString(3);
				String brand = rs.getString(2)!=null?rs.getString(2):rs.getString(4);
				long inActiveQuantity = rs.getBigDecimal(5).longValue();
				long activeQuantity = rs.getBigDecimal(6).longValue();
				Long[] value = {activeQuantity,inActiveQuantity};
				resultMap.put(new PartnerSMPBrandVO(wayid,brand),value);
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
    
    /**
     * <pre>
     * 用于7.5.38 套卡激活率计算
     * 区分品牌 (根据CR_SW20100624_1065427修改)
     * 按照合作商编码、套卡品牌分组统计合作商资源表（FX_SW_PARTNERRES）中未激活套卡数量
     * </pre>
     * @return
     */
    public Map<PartnerSMPBrandVO,BigDecimal> statInActiveSMPWithBrand() throws Exception{
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<PartnerSMPBrandVO,BigDecimal> resultMap = new HashMap<PartnerSMPBrandVO,BigDecimal>();
		String sql = "select WAYID,BRAND,NVL(count(1),0) inActiveQuantity " +
					 "from FX_SW_PARTNERRES where ISACTIVE = 0 and RESTYPE = 'COMRESSMP' group by WAYID,BRAND";
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String wayid = rs.getString(1);
				String brand = rs.getString(2);
				resultMap.put(new PartnerSMPBrandVO(wayid,brand), rs.getBigDecimal(3));
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
    /**
     * <pre>
     * 用于7.5.38 套卡激活率计算
     * 区分品牌
     * 根据合作商编码，套卡品牌 分组统计合作商资源表（FX_SW_PARTNERRES）中某时间段里的激活量和订购量
     * </pre>
     * @param activeOrderDay 已激活套卡订购天数
     * @param activeDay      已激活套卡激活天数
     * @param orderDay       订购量订购天数
     * @return
     * @throws Exception
     */
    public Map<PartnerSMPBrandVO,String> statActiveAndOrderSMPWithBrand(int activeOrderDay,
			int activeDay,int orderDay) throws Exception {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<PartnerSMPBrandVO,String> resultMap = new HashMap<PartnerSMPBrandVO,String>();
		
		StringBuffer sbSql = new StringBuffer("");
		sbSql.append("select pr.wayid,pr.brand,count(1) totalQty,max(NVL(pr1.activeQty,0)) activeQty ")
			 .append("from FX_SW_PARTNERRES pr left join ")
			 .append("(select wayid,brand,count(1) activeQty from FX_SW_PARTNERRES where ");
		if(activeOrderDay > 0) {
			sbSql.append(" CREATETIME >= sysdate - ? and CREATETIME <= sysdate and ");
		}
		if(activeDay > 0) {
			sbSql.append(" ACTTIME >= sysdate - ? ").append(" and ACTTIME <= sysdate and ");
		}
		sbSql.append(" RESTYPE='COMRESSMP' and isactive = 1  group by wayid,brand) pr1 ")
			 .append(" on pr.wayid = pr1.wayid and pr.brand = pr1.brand where ");
		if(orderDay > 0) {
			sbSql.append("pr.CREATETIME >= sysdate - ? and pr.CREATETIME <= sysdate and ");
		}
		sbSql.append("pr.RESTYPE='COMRESSMP' group by pr.wayid,pr.brand");
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sbSql.toString());
			int paramIndex = 0;
			if(activeOrderDay > 0) {
				pstmt.setInt(++paramIndex, activeOrderDay);
			}
			if(activeDay > 0) {
				pstmt.setInt(++paramIndex, activeDay);
			}
			if(orderDay > 0) {
				pstmt.setInt(++paramIndex, orderDay);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String wayid = rs.getString(1);
				String brand = rs.getString(2);
				long orderQuantity = rs.getBigDecimal(3).longValue();
				long activeQuantity = rs.getBigDecimal(4).longValue();
				resultMap.put(new PartnerSMPBrandVO(wayid,brand),orderQuantity+"|"+activeQuantity);
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
    
    /**
     * <pre>
     * 用于7.5.38 套卡激活率计算
     * 不区分品牌
     * 根据合作商编码 分组统计合作商资源表（FX_SW_PARTNERRES）中某时间段里的激活量和订购量
     * </pre>
     * @param activeOrderDay 已激活套卡订购天数
     * @param activeDay      已激活套卡激活天数
     * @param orderDay       订购量订购天数
     * @return
     * @throws Exception
     */
    public Map<String,String> statActiveAndOrderSMPNotWithBrand(int activeOrderDay,
			int activeDay,int orderDay) throws Exception {
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String,String> resultMap = new HashMap<String,String>();
		
		StringBuffer sbSql = new StringBuffer("");
		sbSql.append("select pr.wayid,count(1) totalQty,max(NVL(pr1.activeQty,0)) activeQty ")
			 .append("from FX_SW_PARTNERRES pr left join ")
			 .append("(select wayid,count(1) activeQty from FX_SW_PARTNERRES where ");
		if(activeOrderDay > 0) {
			sbSql.append(" CREATETIME >= sysdate - ? and CREATETIME <= sysdate and ");
		}
		if(activeDay > 0) {
			sbSql.append(" ACTTIME >= sysdate - ? ").append(" and ACTTIME <= sysdate and ");
		}
		sbSql.append(" RESTYPE='COMRESSMP' and isactive = 1  group by wayid) pr1 ")
			 .append(" on pr.wayid = pr1.wayid where ");
		if(orderDay > 0) {
			sbSql.append("pr.CREATETIME >= sysdate - ? and pr.CREATETIME <= sysdate and ");
		}
		sbSql.append("pr.RESTYPE='COMRESSMP' group by pr.wayid");
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sbSql.toString());
			int paramIndex = 0;
			if(activeOrderDay > 0) {
				pstmt.setInt(++paramIndex, activeOrderDay);
			}
			if(activeDay > 0) {
				pstmt.setInt(++paramIndex, activeDay);
			}
			if(orderDay > 0) {
				pstmt.setInt(++paramIndex, orderDay);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String wayid = rs.getString(1);
				long orderQuantity = rs.getBigDecimal(2).longValue();
				long activeQuantity = rs.getBigDecimal(3).longValue();
				resultMap.put(wayid,orderQuantity+"|"+activeQuantity);
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
    /**
     * <pre>
     * 用于7.5.39 合作商套卡月订购量计算 
     * 区分品牌
     * 根据合作商编码，套卡品牌 对合作商资源表（FX_SW_PARTNERRES）数据分组统计上月的订购量和激活量
     * </pre>
     * @param wayid
     * @param brand
     * @param firstDayOfMonth
     * @param endDayOfMonth
     * @return
     * @throws Exception
     */
    public BigDecimal[] statOrderAndActiveSMPWithBrand(
    		String wayid,String brand,java.util.Date firstDayOfMonth,java.util.Date endDayOfMonth) throws Exception{
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BigDecimal[] result = new BigDecimal[2];
		String sql = "select pr.wayid,pr.brand,count(1) totalQty,max(NVL(pr1.activeQty,0)) activeqQty " +
					 "from FX_SW_PARTNERRES pr left join " +
					 "(select wayid,brand,count(1) activeQty from FX_SW_PARTNERRES " +
					 "where restype='COMRESSMP' and wayid=? and brand=? and isactive=1 and createtime >= ? and createtime <= ? " +
					 "group by wayid,brand) pr1 " +
					 "on pr.wayid = pr1.wayid and pr.brand = pr1.brand " +
					 "where pr.restype='COMRESSMP' and pr.wayid=? and pr.brand=? and pr.createtime >= ? and pr.createtime <= ? " +
					 "group by pr.wayid,pr.brand ";
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wayid);
			pstmt.setString(2, brand);
			pstmt.setTimestamp(3, new Timestamp(firstDayOfMonth.getTime()));
			pstmt.setTimestamp(4, new Timestamp(endDayOfMonth.getTime()));
			pstmt.setString(5, wayid);
			pstmt.setString(6, brand);
			pstmt.setTimestamp(7, new Timestamp(firstDayOfMonth.getTime()));
			pstmt.setTimestamp(8, new Timestamp(endDayOfMonth.getTime()));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result[0] = rs.getBigDecimal(3);
				result[1] = rs.getBigDecimal(4);
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
    	return result;
    	
    }
    /**
     * <pre>
     * 用于7.5.39 合作商套卡月订购量计算 
     * 不区分品牌
     * 根据合作商编码 对合作商资源表（FX_SW_PARTNERRES）数据分组统计上月的订购量和激活量
     * </pre>
     * @param wayid
     * @param firstDayOfMonth
     * @param endDayOfMonth
     * @return
     * @throws Exception
     */
    public BigDecimal[] statOrderAndActiveSMPNotWithBrand(String wayid,java.util.Date firstDayOfMonth,java.util.Date endDayOfMonth) throws Exception{
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BigDecimal[] result = new BigDecimal[2];
		String sql = "select pr.wayid,count(1) totalQty,max(NVL(pr1.activeQty,0)) activeqQty " +
					 "from FX_SW_PARTNERRES pr left join " +
					 "(select wayid,count(1) activeQty from FX_SW_PARTNERRES " +
					 "where restype='COMRESSMP' and wayid=? and isactive=1 and createtime >= ? and createtime <= ? " +
					 "group by wayid) pr1 " +
					 "on pr.wayid = pr1.wayid " +
					 "where pr.restype='COMRESSMP' and pr.wayid=? and pr.createtime >= ? and pr.createtime <= ? " +
					 "group by pr.wayid ";
		try {
			Session session = SessionUtils.currentSession();
			conn = session.connection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wayid);
			pstmt.setTimestamp(2, new Timestamp(firstDayOfMonth.getTime()));
			pstmt.setTimestamp(3, new Timestamp(endDayOfMonth.getTime()));
			pstmt.setString(4, wayid);
			pstmt.setTimestamp(5, new Timestamp(firstDayOfMonth.getTime()));
			pstmt.setTimestamp(6, new Timestamp(endDayOfMonth.getTime()));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result[1] = rs.getBigDecimal(2);
				result[2] = rs.getBigDecimal(3);
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
    	return result;
    	
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
		String sql = "select WAYID,count(1) inActiveQuantity " +
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
    /**
     * 合作商套卡激活数据更新
     * @param intervalDay 合作商资源表中的创建时间和号码激活记录表中的激活时间的间隔天数
     * @return
     * @throws Exception
     */
    public int updateSMPActive(int intervalDay) throws Exception {
    	int updateRow = 0;
    	StringBuffer updateSQL = new StringBuffer();
    	updateSQL.append("update FX_SW_PARTNERRES res set (res.acttime,res.isactive) = ")
    			.append("( select max(activedate),1 from FX_SN_NOACTINFO info  ")
    			.append("where res.comresid = info.mobileno ")
    			.append("and ( res.createtime <= info.activedate or res.createtime - :intervalDay < info.activedate ) ")
    			.append("and res.restype = 'COMRESSMP' and res.isactive = 0 ) ")
    			.append("where exists " )
    			.append("(select 1 from FX_SN_NOACTINFO info ")
    			.append("where res.comresid = info.mobileno ")
    			.append("and ( res.createtime <= info.activedate or res.createtime - :intervalDay < info.activedate ) ")
    			.append("and res.restype = 'COMRESSMP' and res.isactive = 0)");
    	Session session = SessionUtils.currentSession();
    	try {
    		updateRow = session.createSQLQuery(updateSQL.toString())
								.setInteger("intervalDay", intervalDay)
								.executeUpdate();
		}catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
    	return updateRow;
    }
}
