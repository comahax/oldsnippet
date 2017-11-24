package com.gmcc.pboss.business.sales.bgbusiness.Adpaysum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.gmcc.pboss.control.sales.order.Order;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * 垫资订单汇总 后台逻辑之DAO
 * 
 * @author zsw
 * 
 */
public class AdpaysumBgDAO extends AbstractDAO {

	public AdpaysumBgDAO() {
		super(Order.class);
	}
	/**
	 * <pre>
	 * 获取配送商在指定时间段里的所有订单号
	 * 为避免订单数量过大，导致订单号拼接成字符串时，返回的字符数据溢出，进行分页处理
	 * </pre>
	 * @param begintime 起始时间
	 * @param endtime	终止时间
	 * @param paytype 缴费方式
	 * @param orderstate 订单状态
	 * @param beginRow 分页开始行数
	 * @param endRow   分页结束行数
	 * @return 	<配送商,orderid1|orderid2|.....>
	 * @throws Exception
	 */
	public Map<String, String> getOrdersOfDisCom(String begintime,
			String endtime, String paytype, int beginRow,
			int endRow) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select t.discomcode, max(sys_connect_by_path(t.orderid, '|')) orderids  " +
					 "from (select a.orderid, a.discomcode, no, lag(no) over(partition by discomcode order by no) pid " +
					 "from (select temp.orderid,temp.discomcode,temp.no " +
					 "from ( select o.orderid orderid, o.discomcode discomcode, rownum no " +
					 "from FX_SW_ORDER o where o.paytype = ? " +
					 "and o.createtime >= to_date(?,'yyyy-mm-dd hh24:mi:ss') " +
					 "and o.createtime <= to_date(?,'yyyy-mm-dd hh24:mi:ss') " +
					 "and rownum <= ? ) temp " +
					 "where temp.no > ? ) a) t  start with pid is null  connect by prior no = pid group by discomcode";
		Session session = SessionUtils.currentSession();
		conn = session.connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, paytype);
		pstmt.setString(2, begintime);
		pstmt.setString(3, endtime);
		pstmt.setInt(4, endRow);
		pstmt.setInt(5, beginRow);
		rs = pstmt.executeQuery();
		Map<String,String> result = new HashMap<String,String>();
		while(rs.next()) {
			result.put(rs.getString(1), rs.getString(2));
		}
		return result;
	}
	/**
	 * 统计某个时间段里各个配送商的订单金额和退单金额
	 * @param begintime
	 * @param endtime
	 * @param paytype
	 * @return <配送商,订单金额|退单金额>
	 * @throws Exception
	 */
	public Map<String,String> statOrderAndUnsubSum(String begintime,
			String endtime, String paytype) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.Discomcode,NVL(a.rectotal,0) alltotal,NVL(c.rectotal,0) canceltotal from " +
					 "(select o.Discomcode, sum(o.recamt) rectotal " +
					 " from FX_SW_ORDER o   where o.paytype = ? " +
					 " and o.createtime >= to_date(?,'yyyy-mm-dd hh24:mi:ss') " +
					 " and o.createtime <= to_date(?,'yyyy-mm-dd hh24:mi:ss') " +
					 " group by o.Discomcode) a left join "+
					 "(select  o.Discomcode, sum(o.recamt) rectotal from FX_SW_ORDER o " +
					 " where o.paytype = ? and o.ORDERSTATE = 'CANCEL' " +
					 " and o.createtime >= to_date(?,'yyyy-mm-dd hh24:mi:ss')" +
					 " and o.createtime <= to_date(?,'yyyy-mm-dd hh24:mi:ss') " +
					 " group by o.Discomcode) c "+
					 " on a.Discomcode = c.Discomcode";
		Session session = SessionUtils.currentSession();
		conn = session.connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, paytype);
		pstmt.setString(2, begintime);
		pstmt.setString(3,endtime);
		pstmt.setString(4, paytype);
		pstmt.setString(5, begintime);
		pstmt.setString(6,endtime);
		
		rs = pstmt.executeQuery();
		Map<String,String> result = new HashMap<String,String>();
		while(rs.next()) {
			String discomcode = rs.getString(1);
			double orderamt = rs.getBigDecimal(2).doubleValue();
			double cancelamt = rs.getBigDecimal(3).doubleValue();
			result.put(discomcode, orderamt + "|" + cancelamt);
		}
		return result;
	}
	
	
	
}
