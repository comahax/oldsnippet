/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.business.sales.disform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PDisformDAO
 * </p>
 * <p>
 * Description: Data Access Object for CompanyVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public class PDisformDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public PDisformDAO() {
		super(PDisformVO.class);
	}
	
	/**
	 * 查询打印页面配送单信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doDisformPrint(DisformDBParam params) throws Exception {
		params.getQueryConditions().put("orderid", params.get_se_orderid());
		params.set_pagesize("0");
		params.setDataOnly(true);
		return queryByNamedSqlQuery("queryDisformPrintList", params);
	}

	/**
	 * 查询打印页面订单商品种类信息
	 * 
	 * @param params
	 * COMCATEGORY, ORDERAMT, RESTYPE, TOTALPRICE, ORDERID, ORDERCOMTYPE
	 * @return
	 * @throws Exception
	 */
	public DataPackage doDisformPrintDp(DisformDBParam params) throws Exception {
		int _pagesize = 100, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		StringBuffer sqlHeadSel = new StringBuffer(
				"select oc.comcategory as COMCATEGORY, oc.orderamt as ORDERAMT,(select restype from IM_PR_COMCATEGORYRELA where comcategory = oc.comcategory and rownum = 1) as RESTYPE, oc.totalprice as TOTALPRICE, oc.orderid as orderid, oc.ordercomtype from FX_SW_ORDERCOMCATE oc where oc.orderid = '"
						+ params.get_se_orderid() + "'");
		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("comcategory", Hibernate.STRING).addScalar(
							"orderamt", Hibernate.LONG).addScalar("restype",
							Hibernate.STRING).addScalar("totalprice",
							Hibernate.DOUBLE).addScalar("orderid",
							Hibernate.STRING).addScalar("ordercomtype",
							Hibernate.STRING);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(_pagesize);
			querySel.setFirstResult(_pagesize * (_pageno - 1));
			List list = querySel.list();

			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				PDisformVO vo = new PDisformVO();
				Object[] obj = (Object[]) itt.next();
				vo.setComcategory(obj[0].toString());
				vo.setOrderamt(obj[1] == null ? 0 : (Long) obj[1]);
				vo.setRestype(obj[2].toString());
				vo.setTotalprice(obj[3] == null ? 0.00 : (Double) obj[3]);
				vo.setOrderid(obj[4].toString());
				vo.setOrdercomtype(obj[5].toString());
				list2.add(vo);
			}

			result.setDatas(list2);
			list.clear();

		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}

		return result;
	}

	/**
	 * 查询批次号-包号相同的记录数
	 * BATCHNO, BOXNUM, NUM
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doBatchnoBoxnumDp(OrderresdetDBParam params)
			throws Exception {
		int _pagesize = 100, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		StringBuffer sqlHeadSel = new StringBuffer(
				"select od.batchno, od.boxnum, count(*) as num, (select min(insideseq) from IM_FX_COMRESSMP where batchno = od.batchno and boxnum=od.boxnum and insideseq is not null) as insideseq from FX_SW_ORDERRESDET od where od.orderid = '"
						+ params.get_se_orderid()
						+ "' and od.ordercomtype = '"
						+ params.get_se_ordercomtype()
						+ "' and comcategory = '"
						+ params.get_se_comcategory()
						+ "' group by od.batchno, od.boxnum");

		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("batchno", Hibernate.STRING).addScalar("boxnum",
							Hibernate.STRING).addScalar("num", Hibernate.LONG).addScalar("insideseq", Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(_pagesize);
			querySel.setFirstResult(_pagesize * (_pageno - 1));
			List list = querySel.list();

			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				PDisformVO vo = new PDisformVO();
				Object[] obj = (Object[]) itt.next();
				vo.setBatchno(obj[0] == null ? "": obj[0].toString());
				vo.setBoxnum(obj[1] == null ? "" : obj[1].toString());
				vo.setNum(obj[2] == null ? 0 : (Long) obj[2]);
				vo.setInsideseq(obj[3] == null ? 0 : (Long)obj[3]);
				list2.add(vo);
			}

			result.setDatas(list2);
			list.clear();

		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}

		return result;
	}

	/**
	 * 查询最小资源编号~最打资源编号(数量)
	 * MINRES, MAXRES, NUM
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doMinMaxComresidDp(OrderresdetDBParam params)
			throws Exception {
		int _pagesize = 100, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		StringBuffer sqlHeadSel = new StringBuffer(
				"select min(comresid) as minres, max(comresid) as maxres, count(*) as num from FX_SW_Orderresdet where orderid = '"
						+ params.get_se_orderid()
						+ "' and ordercomtype = '"
						+ params.get_se_ordercomtype()
						+ "' and comcategory = '"
						+ params.get_se_comcategory()
						+ "'");

		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("minres", Hibernate.STRING).addScalar("maxres",
							Hibernate.STRING).addScalar("num", Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(_pagesize);
			querySel.setFirstResult(_pagesize * (_pageno - 1));
			List list = querySel.list();

			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				PDisformVO vo = new PDisformVO();
				Object[] obj = (Object[]) itt.next();
				vo.setMinres(obj[0] == null ? "" : obj[0].toString());
				vo.setMaxres(obj[1] == null ? "" : obj[1].toString());
				vo.setNum(obj[2] == null ? 0 : (Long) obj[2]);
				list2.add(vo);
			}

			result.setDatas(list2);
			list.clear();

		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}

		return result;
	}

}
