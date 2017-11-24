/**
 * auto-generated code
 * Fri Jan 04 15:56:32 CST 2008
 */
package com.sunrise.boss.business.cms.resale.persistent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import java.text.SimpleDateFormat;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.exception.business.BusinessException;

/**
 * <p>
 * Title: ResaleDAO
 * </p>
 * <p>
 * Description: Data Access Object for ResaleVO
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
public class ResaleDAO extends BaseLogDAO {
	private static final Log log = LogFactory.getLog(ResaleDAO.class);
/*	BrandGotone	全球通 1
	BrandSzx	神州行 2
	BrandMzone	动感地带 3
	BrandDzk	神州大众卡 merge to BrandSzx
*/
	/**
	 * default constructor
	 */
	public ResaleDAO() {
		super(ResaleVO.class);
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
				throw new Exception("SQL 语句查询出错!");
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {

		}
	}

	public DataPackage getMobileSequence(String sql) throws Exception {
		DataPackage dp = new DataPackage();
		try {
			if(sql==null || "".equals(sql))
			{
				log.error("SQL 语句没有配置!");
				throw new BusinessException("","SQL 语句没有配置!");
			}
			log.info("================开始查询可供同步的记录!====startTime:"+new Date(System.currentTimeMillis())+"======");
			Session session = SessionUtil.currentSession(getDbFlag());
			Connection conn = session.connection();
			Statement stmt = conn.createStatement();
			
//			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			Collection col = new ArrayList();
			int count = 0;
			while (rs.next()) {
				ResaleVO vo = new ResaleVO();
				vo.setWayid(rs.getString(1));
				vo.setMobile(rs.getString(2));
				vo.setQuantity(rs.getString(3));
				vo.setCountyid(rs.getString(4));
				String brand = rs.getString(5);
				if (!"".equals(brand) && null != brand) {
					if("BrandGotone".equalsIgnoreCase(brand))
					{
						vo.setBrand(new Long("1"));
					}else if("BrandSzx".equalsIgnoreCase(brand) || "BrandDzk".equalsIgnoreCase(brand))
					{
						vo.setBrand(new Long("2"));
					}else if("BrandMzone".equalsIgnoreCase(brand))
					{
						vo.setBrand(new Long("3"));
					}
				}
				;
				String daytime = rs.getString(6);
				if (!"".equals(daytime) && null != daytime) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date dt = format.parse(daytime);
					vo.setDaytime(dt);
				}
				++count;
				col.add(vo);
			}
			if(count==0)
			{
				log.error("没有记录可供同步,程序自动退出!");
				throw new BusinessException("","没有记录可供同步,程序自动退出!");
			}
			log.info("===================查到记录:"+count+"条=======endTime:"+new Date(System.currentTimeMillis())+"====");
			dp.setRowCount(count);
			dp.setDatas(col);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.warn(sql);
			log.error(ex.getMessage());
		}
		return dp;
	}
	public String checkOpnID(String mobile) throws Exception {
		String sql = "Select OPNID from CH_ADT_BUSITOSMP a, im_fx_comressmp b, im_pr_com c where b.comresid ='"
			+ mobile
			+ "' and b.comid=c.comid and a.Comclassid=c.Comtype and a.Comprice=b.price";
		try {
			Session session = SessionUtil.currentSession(getDbFlag());
			Connection conn = session.connection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String reStr = rs.getString(1);
				return reStr;
			} else {
				return null;
			}
		} catch (Exception ex) {
			log.error("SQL 语句查询出错!"+sql);
			throw new Exception(ex.getMessage());
		} finally {
			
		}
	}
}
