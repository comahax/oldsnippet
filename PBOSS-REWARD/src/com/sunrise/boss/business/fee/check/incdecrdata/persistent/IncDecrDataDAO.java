/**
 * auto-generated code
 * Sat Aug 19 17:06:54 CST 2006
 */
package com.sunrise.boss.business.fee.check.incdecrdata.persistent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.sunrise.boss.business.fee.persistent.cbincdecrdata.CBIncDecrDataVO;
import com.sunrise.boss.business.fee.persistent.wlincdecrdata.WLIncDecrDataVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.pub.tools.Arith;

/**
 * Title: IncDecrDataDAO
 * Description: Data Access Object for IncDecrDataVO
 * Copyright: Copyright (c) 2006
 * Company: Maywide Tech Ltd.
 * @author liwenjing mys
 * @version 1.0
 */
public class IncDecrDataDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public IncDecrDataDAO() {
		super(CBIncDecrDataVO.class);
	}

	public double getIncDecSumByBillcyc(CBIncDecrDataVO vo) {
		Session session = SessionUtil.currentSession(getDbFlag());
		StringBuffer hql = new StringBuffer();
		hql.append("select sum(vo.incrdecramt) from CBIncDecrDataVO vo where ")
				.append("vo.acctid = " + vo.getAcctid()).append(" and ")
				.append("vo.subsid = " + vo.getSubsid()).append(" and ")
				.append("vo.type = 1 and ")
				.append("vo.genbillcyc = " + vo.getGenbillcyc());
				
		List sumList = session.createQuery(hql.toString()).list();

		if (sumList != null && sumList.size() != 0) {
			Double sum = (Double) sumList.iterator().next();
			if (sum != null){
				return sum.doubleValue();
			} 	
		}	
		return 0;
	}

	public double getWoffCustVOSum(CBIncDecrDataVO vo) {
		Session session = SessionUtil.currentSession(getDbFlag());
		StringBuffer hql = new StringBuffer();
		hql.append("select sum(vo.recamt) from WoffCustVO vo where ")
			.append("vo.acctid = '" + vo.getAcctid().toString()).append("' and ")
			.append("vo.subsid = '" + vo.getSubsid().toString()).append("' and ")
			.append("vo.validbillcyc = '" + vo.getGenbillcyc().toString()).append("'");

		List sumList = session.createQuery(hql.toString()).list();
		if (sumList != null && sumList.size() != 0) {
			Double sum = (Double) sumList.iterator().next();
			if (sum != null){
				return sum.doubleValue();
			} 	
		}	
		return 0;
	}

	public double getUnWoffCustSum(CBIncDecrDataVO vo) {
		Session session = SessionUtil.currentSession(getDbFlag());
		StringBuffer hql = new StringBuffer();
		hql.append("select sum(vo.recamt) from UnWoffCustVO vo where ")
			.append("vo.acctid = '" + vo.getAcctid().toString()).append("' and ")
			.append("vo.subsid = '" + vo.getSubsid().toString()).append("' and ")
			.append("vo.validbillcyc = '" + vo.getGenbillcyc().toString()).append("'");
		
		List sumList = session.createQuery(hql.toString()).list();
		if (sumList != null && sumList.size() != 0) {
			Double sum = (Double) sumList.iterator().next();
			if (sum != null){
				return sum.doubleValue();
			} 	
		}	
		return 0;
	}

	public CBIncDecrDataVO saveOrUpdate(CBIncDecrDataVO vo) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		try {
			session.saveOrUpdate(vo);
			session.flush();
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return vo;
	}

	/**
	 * @deprecated
	 **/
	public WLIncDecrDataVO getCreatLogVo(CBIncDecrDataVO vo) throws Exception {

		Session session = SessionUtil.currentSession(getDbFlag());
		StringBuffer hql = new StringBuffer();
		hql.append("from WLIncDecrDataVO vo where ")
			.append("vo.incdecrid='" + vo.getIncdecrid().toString())
			.append("' and ").append("vo.oprtype = '0'");
		
		List ls = session.createQuery(hql.toString()).list();
		if (ls != null && ls.size() != 0) {
			WLIncDecrDataVO vo2 = (WLIncDecrDataVO) ls.iterator().next();
			return vo2;
		}
		return null;
	}
	
	public double getIncrdecramtById(CBIncDecrDataVO vo) throws Exception{
		
		double incrdecramt = 0;
		StringBuffer sql = new StringBuffer(128)
			.append("select incrdecramt from IB_CB_INCDECRDATA where incdecrid=")
			.append(vo.getIncdecrid());
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Session session = SessionUtil.currentSession(getDbFlag());
			pstmt = ((SessionImpl)session).getBatcher().prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if( rs != null && rs.next() ){
				incrdecramt = (null != new Double(rs.getDouble(1))) ? (new Double(rs.getDouble(1))).doubleValue() : 0;
			}			
		}catch(Exception ex){
			throw new Exception("≤È—Ø≤π ’≥ÂºıΩ∂Ó ß∞‹:" + ex.getMessage(),ex);			
		}finally{
			if( pstmt != null ){
				pstmt.close();
			}
			if( rs != null ){
				rs.close();
			}
		}	
		return incrdecramt;
	}

}
