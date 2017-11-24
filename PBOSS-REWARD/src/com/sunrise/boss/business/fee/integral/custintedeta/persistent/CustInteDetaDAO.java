/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custintedeta.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * 
 * Title: CustInteDetaDAO Description: Data Access Object for CutsInteVO
 * Copyright: Copyright (c) 2006 Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public class CustInteDetaDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public CustInteDetaDAO() {
		super(CustInteDetaVO.class);
	}

	/**
	 * 取（sumProperty）字段的总数
	 * @param params
	 * @param sumProperty
	 * @return 返回总数
	 * @throws Exception
	 */	 
	public Long findSumInType(CustInteDetaListVO params, String sumProperty)
			throws Exception {
		Long sumvalue = new Long(0);
		if (null != sumProperty && !"".equals(sumProperty)) {

			Long custid = Long.valueOf(params.get_ne_custid());
			
			Long jftype = Long.valueOf(params.get_ne_jftype());
			Long lowerdate = null;
			Long uppdate = null;
			if (params.get_nnl_validbillcyc() != null && params.get_nnm_validbillcyc() != null) {
				lowerdate = Long.valueOf(params.get_nnl_validbillcyc());
				uppdate = Long.valueOf(params.get_nnm_validbillcyc());
			}

			StringBuffer sql = new StringBuffer("select sum(this.").append(
					sumProperty).append(") from ").append(
					CustInteDetaVO.class.getName()).append(" this");

			StringBuffer whereClause = new StringBuffer();

			
			if (jftype != null)
				whereClause = whereClause.append("this.jftype = :jftype and ");
			if (custid != null)
				whereClause = whereClause.append("this.custid = :custid and ");

			if (lowerdate != null && uppdate != null) {
				whereClause = whereClause
						.append("(this.validbillcyc between :lowerdate and :uppdate) and ");
			}
			if (whereClause.length() > 4) {
				whereClause = whereClause.delete(whereClause.length() - 4,
						whereClause.length() - 1);
			}
			if (whereClause.length() > 4) {
				sql = sql.append(" WHERE ").append(whereClause);
			}
			try {
				Session session = SessionUtil.currentSession(getDbFlag());
				Query query = session.createQuery(sql.toString());

				
				if (jftype != null)
					query.setLong("jftype", jftype.longValue());
				if (custid != null)
					query.setLong("custid", custid.longValue());

				if (lowerdate != null && uppdate != null) {
					query.setLong("lowerdate", lowerdate.longValue()).setLong(
							"uppdate", uppdate.longValue());
				}
				List list = query.list();
				if (list != null && list.size() > 0)
					sumvalue = (Long) list.iterator().next();
			} catch (HibernateException ex) {
				if (ex.getCause() != null) {
					throw new Exception(ex.getCause());
				} else {
					throw ex;
				}
			}
		}

		return sumvalue;
	}

	/**
	 * sum(this.value)只是为了取得记录集总数，
	 * 专用  客户积分查询---客户积分明细列表显示
	 * @param params 查询条件
	 * @return 结果集
	 * @throws Exception
	 * @deprecated
	 */
	public DataPackage getGroupCountAndDp(CustInteDetaListVO params) throws Exception {

		DataPackage dp = new DataPackage();
		Long lowerdate = null;
		Long uppdate = null;
		Long custid = null;
		Long userid = null;
		if (params.get_nnl_validbillcyc() != null && params.get_nnm_validbillcyc() != null) {
			lowerdate = Long.valueOf(params.get_nnl_validbillcyc());
			uppdate = Long.valueOf(params.get_nnm_validbillcyc());
		}
		if (params.get_ne_custid() != null ) {
			custid = Long.valueOf(params.get_ne_custid());
		}
		if (params.get_ne_userid() != null ) {
			userid = Long.valueOf(params.get_ne_userid());
		}		

		StringBuffer sql = new StringBuffer(
				"select sum(this.value),this.validbillcyc,this.userid,this.custid").append(" from ")
				.append(CustInteDetaVO.class.getName()).append(" this");

		StringBuffer whereClause = new StringBuffer();

		if (userid != null)
			whereClause = whereClause.append("this.userid = :userid and ");

		if (custid != null)
			whereClause = whereClause.append("this.custid = :custid and ");

		if (lowerdate != null && uppdate != null) {
			whereClause = whereClause
					.append("(this.validbillcyc between :lowerdate and :uppdate) and ");
		}
		if (whereClause.length() > 4) {
			whereClause = whereClause.delete(whereClause.length() - 4,
					whereClause.length() - 1);
		}
		if (whereClause.length() > 4) {
			sql = sql.append(" WHERE ").append(whereClause);
		}
		sql.append("group by this.userid,this.custid,this.validbillcyc ");
		
		sql.append(getOrderbySQl(params.get_orderby(), params.get_desc()));
		
		try {
			Session session = SessionUtil.currentSession(getDbFlag());
			Query query = session.createQuery(sql.toString());

			if (userid != null)
				query.setLong("userid", userid.longValue());

			if (custid != null)
				query.setLong("custid", custid.longValue());

			if (lowerdate != null && uppdate != null) {
				query.setLong("lowerdate", lowerdate.longValue()).setLong(
						"uppdate", uppdate.longValue());
			}
			dp.setDatas(query.list());
			if(null != dp && null != dp.getDatas()){
				dp.setRowCount(dp.getDatas().size());
			}else{
				dp.setRowCount(0);
			}

		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}

		return dp;
	}
	
	
	/**
	 * 客户积分查询---客户积分明细列表显示
	 * 特殊查询，条件必须不为null；
	 * 专用  客户积分查询---客户积分明细列表显示
	 * @deprecated
	 **/
	public List doQueryList(CustInteDetaListVO params,Long userid, Long userid1) throws Exception {

		List list = new ArrayList();
		if(null != params){
			Long lowerdate = Long.valueOf(params.get_nnl_validbillcyc());
			Long uppdate = Long.valueOf(params.get_nnm_validbillcyc());
			Long custid = Long.valueOf(params.get_ne_custid());
			
			if (null != lowerdate && null != uppdate && null != custid
						&& null != userid && null != userid1) {
					StringBuffer sql = new StringBuffer("from ").append(
							CustInteDetaVO.class.getName()).append(" this ")
							.append(" where this.custid = :custid and ");
					
					if("1".equals(params.get_desc())){
						sql.append(ConditionSQL(params.get_orderby(), lowerdate, uppdate, userid1, userid, "<", ">"));
					}else{
						sql.append(ConditionSQL(params.get_orderby(), lowerdate, uppdate, userid1, userid, ">", "<"));
					}

					sql.append(getOrderbySQl(params.get_orderby(), params.get_desc()));
				    System.out.println(sql.toString());
				try {
					Session session = SessionUtil.currentSession(getDbFlag());
					Query query = session.createQuery(sql.toString())
						.setLong("userid", userid.longValue())						
						.setLong("custid", custid.longValue())
						.setLong("lowerdate", lowerdate.longValue())
						.setLong("uppdate", uppdate.longValue())
						.setLong("userid1", userid1.longValue());
					
					list = query.list();

				} catch (HibernateException ex) {
					if (ex.getCause() != null) {
						throw new Exception(ex.getCause());
					} else {
						throw ex;
					}
				}
			}			
		}
		return list;
	}

	/**
	 * 生成的条件sql语句
	 * @return sql语句
	 * @deprecated
	 */
	private String ConditionSQL(String orderby,Long lowerdate, Long uppdate, Long userid1,
			Long userid,String comparaFlag1,String comparaFlag2){
		StringBuffer sql = new StringBuffer("");
		if (null == orderby
				|| "".equals(orderby)
				|| "userid".equals(orderby)) {

			if (userid.longValue() == userid1.longValue()) {
				sql.append("this.userid = :userid and this.userid = :userid1 and ")
					.append("(this.validbillcyc between :uppdate and :lowerdate) ");

			} else {
				sql.append("((this.userid = :userid and this.validbillcyc <= :lowerdate) or ")
					.append("(this.userid = :userid1 and this.validbillcyc >= :uppdate) or ")
					.append("(this.userid ").append(comparaFlag1)
					.append(" :userid and this.userid ")
					.append(comparaFlag2).append(" :userid1)) ");


			}
		} else {
			if (lowerdate.longValue() == uppdate.longValue()) {
				sql.append("this.validbillcyc = :lowerdate and this.validbillcyc = :uppdate and ")
					.append("(this.userid between :userid1 and :userid) ");
			} else {
				sql.append("((this.validbillcyc = :lowerdate and this.userid <= :userid) or ")
					.append("(this.validbillcyc = :uppdate and this.userid >= :userid1) or ")
					.append("(this.validbillcyc ").append(comparaFlag1)
					.append(" :lowerdate and this.validbillcyc ")
					.append(comparaFlag2).append(" :uppdate)) ");
					

			}
		}
		return sql.toString();
	}
	
	
	/****
	 * 组装ordrby语句
	 * @param orderby
	 * @param desc
	 * @return
	 * @deprecated
	 */
	private String getOrderbySQl(String orderby, String desc){
		
		StringBuffer orderBySQL = new StringBuffer("");
		
		if ("1".equals(desc)) {
			desc = "desc";
		} else {
			desc= "asc";
		}
		
		if (null == orderby
				|| "".equals(orderby.trim()) 
				|| "userid".equals(orderby.trim())) {
			orderBySQL.append(" order by this.userid ")
				.append(desc).append(",this.validbillcyc desc");
		} else {
			orderBySQL.append(" order by this.validbillcyc ")
				.append(desc).append(",this.userid desc");		
		}
		return orderBySQL.toString();
	}
	
	
	
	/**
	 * Do query by VO's primary key
	 * 
	 * @param vo
	 *            Customer integral deta VO
	 * @return Customer integral deta VO
	 * @throws Exception
	 * @author xiefufeng
	 */
	public CustInteDetaVO doQueryByPK(CustInteDetaVO vo) throws Exception {
		String hql = "from CustInteDetaVO as vo where vo.userid=? and vo.validbillcyc=? "
				+ "and vo.custid=? and vo.jftype=?";
		Session session = SessionUtil.currentSession(getDbFlag());
		Query query = session.createQuery(hql);
		Iterator ls;

		if (vo == null)
			return null;

		if (vo.getUserid() != null)
			query.setInteger(0, vo.getUserid().intValue());
		else
			query.setInteger(0, 0);
		if (vo.getValidbillcyc() != null)
			query.setInteger(1, vo.getValidbillcyc().intValue());
		else
			query.setInteger(1, 0);
		if (vo.getCustid() != null)
			query.setInteger(2, vo.getCustid().intValue());
		else
			query.setInteger(2, 0);
		if (vo.getJftype() != null)
			query.setInteger(3, vo.getJftype().intValue());
		else
			query.setInteger(3, 0);

		ls = query.iterate();
		if (ls.hasNext()) {
			vo = (CustInteDetaVO) ls.next();
		} else
			vo = null;

		return vo;
	}

	/**
	 * sum(this.value)只是为了取得记录集总数，
	 * 专用  积分修正 明细列表显示
	 * @param params 查询条件
	 * @return 结果集
	 * @throws Exception
	 * @deprecated
	 */
	public DataPackage getGroupCountAndDpForDeta(CustInteDetaListVO params) throws Exception {

		DataPackage dp = new DataPackage();
		Long lowerdate = null;
		Long uppdate = null;
		Long custid = null;
		Long userid = null;
		if (params.get_nnl_validbillcyc() != null && params.get_nnm_validbillcyc() != null) {
			lowerdate = Long.valueOf(params.get_nnl_validbillcyc());
			uppdate = Long.valueOf(params.get_nnm_validbillcyc());
		}
		if (params.get_ne_custid() != null ) {
			custid = Long.valueOf(params.get_ne_custid());
		}
		if (params.get_ne_userid() != null ) {
			userid = Long.valueOf(params.get_ne_userid());
		}		

		StringBuffer sql = new StringBuffer(
				"select sum(this.value),this.validbillcyc,this.userid,this.custid").append(" from ")
				.append(CustInteDetaVO.class.getName()).append(" this");

		StringBuffer whereClause = new StringBuffer();

		if (userid != null)
			whereClause = whereClause.append("this.userid = :userid and ");

		if (custid != null)
			whereClause = whereClause.append("this.custid = :custid and ");

		if (lowerdate != null && uppdate != null) {
			whereClause = whereClause
					.append("(this.validbillcyc between :lowerdate and :uppdate) and ");
		}
		if (whereClause.length() > 4) {
			whereClause = whereClause.delete(whereClause.length() - 4,
					whereClause.length() - 1);
		}
		if (whereClause.length() > 4) {
			sql = sql.append(" WHERE ").append(whereClause);
		}
		sql.append("group by this.userid,this.custid,this.validbillcyc ");
		sql.append("order by this.userid,this.custid,this.validbillcyc asc ");
		
		try {
			Session session = SessionUtil.currentSession(getDbFlag());
			Query query = session.createQuery(sql.toString());

			if (userid != null)
				query.setLong("userid", userid.longValue());

			if (custid != null)
				query.setLong("custid", custid.longValue());

			if (lowerdate != null && uppdate != null) {
				query.setLong("lowerdate", lowerdate.longValue()).setLong(
						"uppdate", uppdate.longValue());
			}
			dp.setDatas(query.list());
			if(null != dp && null != dp.getDatas()){
				dp.setRowCount(dp.getDatas().size());
			}else{
				dp.setRowCount(0);
			}

		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}

		return dp;
	}
	
	
	

}
