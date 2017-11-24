/**
 * auto-generated code
 * Wed Sep 08 16:30:03 CST 2010
 */
package com.gmcc.pboss.business.sales.waystocksnpt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: WaystocksnptDAO
 * </p>
 * <p>
 * Description: Data Access Object for SWaystocksnptVO
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
public class SWaystocksnptDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public SWaystocksnptDAO() {
		super(SWaystocksnptVO.class);
	}

	public DataPackage queryActrate(WaystocksnptDBParam params, SWaystocksnptVO vo, Session session)
		throws Exception {

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer("1"));
		result.setPageSize(new Integer(params.get_pagesize()));

		/*StringBuffer sqlHeadSel = new StringBuffer(
				"select s1.cnt2 as STOCKNUM from (select t1.wayid, t2.brand, t2.comcategory, count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and t2.restype = 'COMRESSMP'");*/
		StringBuffer sqlHeadSel = new StringBuffer(
		"select count(*) as STOCKNUM from  FX_SW_PARTNERRES t2 where  1=1");
		if (StringUtils.isNotEmpty(params.get_dnl_acttime())
				&& StringUtils.isNotEmpty(params.get_dnm_acttime())) {
			sqlHeadSel
					.append(
							" and t2.createtime >= to_date('")
					.append(params.get_dnl_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
			sqlHeadSel
					.append(
							" and t2.createtime <= to_date('")
					.append(params.get_dnm_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_acttime())
				&& StringUtils.isEmpty(params.get_dnl_acttime())) {
			sqlHeadSel
					.append(
							" and t2.createtime <= to_date('")
					.append(params.get_dnm_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
		} else if (StringUtils.isEmpty(params.get_dnm_acttime())
				&& StringUtils.isNotEmpty(params.get_dnl_acttime())) {
			sqlHeadSel
					.append(
							" and t2.createtime >= to_date('")
					.append(params.get_dnl_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
		}
		/*if (StringUtils.isNotEmpty(vo.getCountyid())) {
			sqlHeadSel.append(" and t1.countyid='").append(
					vo.getCountyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(vo.getWayname())) {
			sqlHeadSel.append(" and t1.wayname like '%").append(
					vo.getWayname()).append("%' ");
		}
		if (StringUtils.isNotEmpty(vo.getSvccode())) {
			sqlHeadSel.append(" and t1.svccode='").append(
					vo.getSvccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(vo.getMareacode())) {
			sqlHeadSel.append(" and t1.mareacode='").append(
					vo.getMareacode()).append("' ");
		}
		if (vo.getStarlevel()!=null) {
			sqlHeadSel.append(" and t1.starlevel='").append(
					vo.getStarlevel()).append("' ");
		}*/
		if(StringUtils.isNotEmpty(vo.getWayid())){
			sqlHeadSel.append(" and t2.wayid='").append(vo.getWayid()).append("' ");
		}
		if(StringUtils.isNotEmpty(vo.getBrand())){
			sqlHeadSel.append(" and t2.brand='").append(vo.getBrand()).append("' ");
		}
		if(StringUtils.isNotEmpty(vo.getComcategory())){
			sqlHeadSel.append(" and t2.comcategory='").append(vo.getComcategory()).append("' ");
		}
		/*sqlHeadSel
				.append(" group by t1.wayid, t2.brand, t2.comcategory)s1");*/
		
		//Session session = SessionUtils.currentSession(getDbFlag());

		try {
			
			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("STOCKNUM", Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			
			querySel.setMaxResults(new Integer("1"));
			querySel.setFirstResult(new Integer("0"));
			List list = querySel.list();
			if(list.size()>0){
				List list2 = new ArrayList();
				Long rate = (Long) list.get(0);
				list2.add(rate);
			
				result.setDatas(list2);
				list.clear();
			}

		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}

		return result;

	}

	public DataPackage querySaleslistcard(WaystocksnptDBParam params)
			throws Exception {
		int _pageno = 1;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer(params.get_pageno()));
		if("0".equals(params.get_pagesize())){
			params.setQueryAll(true);
		}
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer(
				"select w.countyid,w.svccode,w.mareacode,s1.wayid,w.wayname,w.starlevel,'' as orderid, '' as brand,s1.comcategory,s1.cnt2 as STOCKNUM from (select t1.wayid,t2.comcategory, count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and t2.restype = 'COMRESCARD'");
		if (StringUtils.isNotEmpty(params.get_dnl_createtime())
				&& StringUtils.isNotEmpty(params.get_dnm_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_createtime())
				&& StringUtils.isEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_createtime())
				&& StringUtils.isNotEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
		}
		sqlHeadSel
				.append(" group by t1.wayid, t2.brand, t2.comcategory)s1, ch_pw_way w where s1.wayid = w.wayid");
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(
					params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(
					params.get_sk_wayname()).append("%' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(
					params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(
					params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(
					params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(
					params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid())
					.append("' ");
		}
		sqlHeadSel.append(" union ");
		sqlHeadSel.append(" select w.countyid,w.svccode,w.mareacode,s1.wayid,w.wayname,w.starlevel,'' as orderid, s1.brand,s1.comcategory,s1.cnt2 as STOCKNUM from (select t1.wayid, t2.brand, t2.comcategory, count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and t2.restype = 'COMRESCARD' and t2.batchno is null");
		if (StringUtils.isNotEmpty(params.get_dnl_createtime())
				&& StringUtils.isNotEmpty(params.get_dnm_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_createtime())
				&& StringUtils.isEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_createtime())
				&& StringUtils.isNotEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
		}
		sqlHeadSel
				.append(" group by t1.wayid, t2.brand, t2.comcategory)s1, ch_pw_way w where s1.wayid = w.wayid");
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(
					params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(
					params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(
					params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(
					params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(
					params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_brand())) {
			sqlHeadSel.append(" and s1.brand='").append(params.get_se_brand())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(
					params.get_sk_wayname()).append("%' ");
		}
		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode",
							Hibernate.STRING).addScalar("wayid",
							Hibernate.STRING).addScalar("wayname",
							Hibernate.STRING).addScalar("starlevel",
							Hibernate.SHORT).addScalar("orderid",
							Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("stocknum",
							Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(new Integer(params.get_pagesize()));
			querySel.setFirstResult(new Integer(params.get_pagesize()) * (_pageno - 1));
			List list = querySel.list();

			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SWaystocksnptVO vo = new SWaystocksnptVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setWayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWayname(obj[4] == null ? "" : obj[4].toString());
				vo.setStarlevel(obj[5] == null ? 0 : (Short) obj[5]);
				vo.setOrderid("");
				vo.setBrand("");
				vo.setComcategory(obj[8] == null ? "" : obj[8].toString());
				vo.setStocknum(obj[9] == null ? 0 : (Long) obj[9]);

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

	public DataPackage queryActivelistsmp(WaystocksnptDBParam params)
			throws Exception {
		int _pageno = 1;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer(params.get_pageno()));
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer(
				"select w.countyid,w.svccode,w.mareacode,w.upperwayid,s1.wayid,w.wayname,w.starlevel,'' as orderid, s1.brand,s1.comcategory,s1.cnt2 as STOCKNUM from (select t2.wayid, t2.brand, t2.comcategory, count(*) as cnt2 from  FX_SW_PARTNERRES t2 where  t2.restype = 'COMRESSMP' and t2.isactive='1'");
		if (StringUtils.isNotEmpty(params.get_dnl_acttime())
				&& StringUtils.isNotEmpty(params.get_dnm_acttime())) {
			sqlHeadSel
					.append(
							" and t2.acttime >= to_date('")
					.append(params.get_dnl_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
			sqlHeadSel
					.append(
							" and t2.acttime <= to_date('")
					.append(params.get_dnm_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_acttime())
				&& StringUtils.isEmpty(params.get_dnl_acttime())) {
			sqlHeadSel
					.append(
							" and t2.acttime <= to_date('")
					.append(params.get_dnm_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
		} else if (StringUtils.isEmpty(params.get_dnm_acttime())
				&& StringUtils.isNotEmpty(params.get_dnl_acttime())) {
			sqlHeadSel
					.append(
							" and t2.acttime >= to_date('")
					.append(params.get_dnl_acttime()).append(
							"' ,'yyyy-MM-dd hh24:mi:ss')");
		}
		sqlHeadSel
				.append(" group by t2.wayid, t2.brand, t2.comcategory)s1, ch_pw_way w where s1.wayid = w.wayid");
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(
					params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(
					params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(
					params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(
					params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(
					params.get_sk_wayname()).append("%' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(
					params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(
					params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_brand())) {
			sqlHeadSel.append(" and s1.brand='").append(
					params.get_se_brand()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(
					params.get_se_wayid()).append("' ");
		}

		Session session = SessionUtils.currentSession(getDbFlag());

		try {
			

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode",
							Hibernate.STRING).addScalar("upperwayid",
							Hibernate.STRING).addScalar("wayid",
							Hibernate.STRING).addScalar("wayname",
							Hibernate.STRING).addScalar("starlevel",
							Hibernate.SHORT).addScalar("orderid",
							Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("stocknum",
							Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();
			//取指定页面
			querySel.setMaxResults(new Integer(params.get_pagesize()));
			querySel.setFirstResult(new Integer(params.get_pagesize()) * (_pageno - 1));
			
			List list = querySel.list();

			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SWaystocksnptVO vo = new SWaystocksnptVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setUpperwayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWayid(obj[4] == null ? "" : obj[4].toString());
				vo.setWayname(obj[5] == null ? "" : obj[5].toString());
				vo.setStarlevel(obj[6] == null ? 0 : (Short) obj[6]);
				vo.setOrderid("");
				vo.setBrand(obj[8] == null ? "" : obj[8].toString());
				vo.setComcategory(obj[9] == null ? "" : obj[9].toString());
				vo.setStocknum(obj[10] == null ? 0 : (Long) obj[10]);

				//暂时把查询激活率的步骤整合进此方法
				Double rate = 0D;
				DataPackage dp3 = this.queryActrate(params, vo, session);
				if (dp3.getRowCount() > 0) {
					//salenum=平均销售量
					Long salenum = (Long) dp3.getDatas().get(0);
					if (null == salenum || salenum.intValue() <= 0) {
						rate = 1.0;
					} else {//激活率=平均激活量/平均销售量
						rate = Double.valueOf(new Double(vo.getStocknum())
						/ (new Double(salenum)));
					}
					
				} else {
					rate = 1.0;
				}
				vo.setActrate(rate);
				
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
	
	public DataPackage queryActivelistsmp2(WaystocksnptDBParam params)
			throws Exception {
		int _pageno = 1;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer(params.get_pageno()));
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer(
				"select w.countyid,w.svccode,w.mareacode,w.upperwayid,s1.wayid,w.wayname,w.starlevel,'' as orderid, s1.brand,s1.comcategory,s1.cnt2 as STOCKNUM from (select t2.wayid, t2.brand, t2.comcategory, count(*) as cnt2 from  FX_SW_PARTNERRES t2 where  t2.restype = 'COMRESSMP' and t2.isactive='1'");
		if (StringUtils.isNotEmpty(params.get_dnl_acttime())
				&& StringUtils.isNotEmpty(params.get_dnm_acttime())) {
			sqlHeadSel.append(" and t2.acttime >= to_date('").append(
			params.get_dnl_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
			sqlHeadSel.append(" and t2.acttime <= to_date('").append(
					params.get_dnm_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_acttime())
				&& StringUtils.isEmpty(params.get_dnl_acttime())) {
			sqlHeadSel.append(" and t2.acttime <= to_date('").append(
					params.get_dnm_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
		} else if (StringUtils.isEmpty(params.get_dnm_acttime())
				&& StringUtils.isNotEmpty(params.get_dnl_acttime())) {
			sqlHeadSel.append(" and t2.acttime >= to_date('").append(
					params.get_dnl_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
		}
		sqlHeadSel
				.append(" group by t2.wayid, t2.brand, t2.comcategory)s1, ch_pw_way w where s1.wayid = w.wayid");
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(
					params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(
					params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(
					params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(
					params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(
					params.get_sk_wayname()).append("%' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(
					params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(
					params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_brand())) {
			sqlHeadSel.append(" and s1.brand='").append(params.get_se_brand())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid())
					.append("' ");
		}

		Session session = SessionUtils.currentSession(getDbFlag());

		try {
			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode",
							Hibernate.STRING).addScalar("upperwayid",
							Hibernate.STRING).addScalar("wayid",
							Hibernate.STRING).addScalar("wayname",
							Hibernate.STRING).addScalar("starlevel",
							Hibernate.SHORT).addScalar("orderid",
							Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("stocknum",
							Hibernate.LONG);
			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();
			// 取指定页面
			querySel.setMaxResults(new Integer(params.get_pagesize()));
			querySel.setFirstResult(new Integer(params.get_pagesize())
					* (_pageno - 1));
			//临时加上下面一行，为测试
			//System.out.println("测试：开始执行激活数据查询：当前时间："+new Date().toLocaleString());
			List list = querySel.list();

			StringBuffer sqlHeadSel2 = new StringBuffer(
					"select s1.wayid, s1.brand, s1.comcategory, s1.cnt2 as ORDUNM from (select t2.wayid, t2.brand, t2.comcategory, count(*) as cnt2 from  FX_SW_PARTNERRES t2 where  t2.restype = 'COMRESSMP' ");
			if (StringUtils.isNotEmpty(params.get_dnl_acttime())
					&& StringUtils.isNotEmpty(params.get_dnm_acttime())) {
				sqlHeadSel2.append(" and t2.createtime >= to_date('").append(
						params.get_dnl_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
				sqlHeadSel2.append(" and t2.createtime <= to_date('").append(
						params.get_dnm_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
			} else if (StringUtils.isNotEmpty(params.get_dnm_acttime())
					&& StringUtils.isEmpty(params.get_dnl_acttime())) {
				sqlHeadSel2.append(" and t2.createtime <= to_date('").append(
						params.get_dnm_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
			} else if (StringUtils.isEmpty(params.get_dnm_acttime())
					&& StringUtils.isNotEmpty(params.get_dnl_acttime())) {
				sqlHeadSel2.append(" and t2.createtime >= to_date('").append(
						params.get_dnl_acttime()).append("' ,'yyyy-MM-dd hh24:mi:ss')");
			}
			sqlHeadSel2
					.append(" group by t2.wayid, t2.brand, t2.comcategory)s1, ch_pw_way w where s1.wayid = w.wayid");
			if (StringUtils.isNotEmpty(params.get_se_countyid())) {
				sqlHeadSel2.append(" and w.countyid='").append(
						params.get_se_countyid()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_svccode())) {
				sqlHeadSel2.append(" and w.svccode='").append(
						params.get_se_svccode()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
				sqlHeadSel2.append(" and w.mareacode='").append(
						params.get_se_mareacode()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
				sqlHeadSel2.append(" and w.wayname like '%").append(
						params.get_sk_wayname()).append("%' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
				sqlHeadSel2.append(" and s1.comcategory='").append(
						params.get_se_comcategory()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
				sqlHeadSel2.append(" and w.starlevel='").append(
						params.get_ne_starlevel()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_brand())) {
				sqlHeadSel2.append(" and s1.brand='").append(
						params.get_se_brand()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_wayid())) {
				sqlHeadSel2.append(" and s1.wayid='").append(
						params.get_se_wayid()).append("' ");
			}
			// 取总页数
			Query querySel2 = session.createSQLQuery(sqlHeadSel2.toString())
					.addScalar("wayid", Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("ordunm",
							Hibernate.LONG);
			//临时加上下面一行，为测试
			//System.out.println("测试：开始执行订购数据查询：当前时间："+new Date().toLocaleString());
			List iter2 = querySel2.list();
			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {// 对库存集合进行遍历
				//临时加上下面一行，为测试
				//System.out.println("测试：开始执行激活数据遍历：当前时间："+new Date().toLocaleString());
				Long salenum = 0L;// salenum=平均销售量
				Object[] obj = (Object[]) itt.next();
				String wayid = (obj[4] == null ? "" : obj[4].toString());
				String brand = (obj[8] == null ? "" : obj[8].toString());
				String comcategory = (obj[9] == null ? "" : obj[9].toString());
				for (Iterator itt2 = iter2.iterator(); itt2.hasNext();) {// 对订购量集合进行遍历
					//临时加上下面一行，为测试
					//System.out.println("测试：开始执行订购数据遍历：当前时间："+new Date().toLocaleString());
					Object[] obj2 = (Object[]) itt2.next();
					if (wayid.equals(obj2[0]) && brand.equals(obj2[1])
							&& comcategory.equals(obj2[2])) {
						salenum = (Long) obj2[3];
						break;
					}
				}
				//临时加上下面一行，为测试
				//System.out.println("测试：结束执行订购数据遍历：当前时间："+new Date().toLocaleString());
				SWaystocksnptVO vo = new SWaystocksnptVO();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString()); 
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setUpperwayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWayid(obj[4] == null ? "" : obj[4].toString());
				vo.setWayname(obj[5] == null ? "" : obj[5].toString());
				vo.setStarlevel(obj[6] == null ? 0 : (Short) obj[6]);
				vo.setOrderid("");
				vo.setBrand(obj[8] == null ? "" : obj[8].toString());
				vo.setComcategory(obj[9] == null ? "" : obj[9].toString());
				vo.setStocknum(obj[10] == null ? 0 : (Long) obj[10]);

				Double rate = 0D;
				if (salenum > 0) {
					// 激活率=平均激活量/平均销售量
					rate = Double.valueOf(new Double(vo.getStocknum())
							/ (new Double(salenum)));
				} else {
					rate = 1.0;
				}
				vo.setActrate(rate);
				list2.add(vo);
			}
			//临时加上下面一行，为测试
			//System.out.println("测试：结束执行激活数据遍历：当前时间："+new Date().toLocaleString());
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

	public DataPackage querySaleslistsmp(WaystocksnptDBParam params)
			throws Exception {
		int _pageno = 1;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer(params.get_pageno()));
		if("0".equals(params.get_pagesize())){
			params.setQueryAll(true);
		}
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer(
				"select w.countyid,w.svccode,w.mareacode,w.upperwayid,w.waymagcode,s1.wayid,w.wayname,w.starlevel,'' as orderid, s1.brand,s1.comcategory,s1.cnt2 as STOCKNUM from (select t1.wayid, t2.brand, t2.comcategory, count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and t2.restype = 'COMRESSMP'");
		if (StringUtils.isNotEmpty(params.get_dnl_createtime())
				&& StringUtils.isNotEmpty(params.get_dnm_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_createtime())
				&& StringUtils.isEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_createtime())
				&& StringUtils.isNotEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
		}
		sqlHeadSel
				.append(" group by t1.wayid, t2.brand, t2.comcategory)s1, ch_pw_way w where s1.wayid = w.wayid");
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(
					params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(
					params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(
					params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(
					params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_waymagcode())) {
			sqlHeadSel.append(" and w.waymagcode='").append(
					params.get_se_waymagcode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(
					params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(
					params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_brand())) {
			sqlHeadSel.append(" and s1.brand='").append(params.get_se_brand())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(
					params.get_sk_wayname()).append("%' ");
		}
		sqlHeadSel.append(" union  ");
		sqlHeadSel.append(" select w.countyid,w.svccode,w.mareacode,w.upperwayid,w.waymagcode,s1.wayid,w.wayname,w.starlevel,'' as orderid, s1.brand,s1.comcategory,s1.cnt2 as STOCKNUM from (select t1.wayid, t2.brand, t2.comcategory, count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and t2.restype = 'COMRESSMP' and t2.batchno is null");
		if (StringUtils.isNotEmpty(params.get_dnl_createtime())
				&& StringUtils.isNotEmpty(params.get_dnm_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_createtime())
				&& StringUtils.isEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append(
							"' ,'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_createtime())
				&& StringUtils.isNotEmpty(params.get_dnl_createtime())) {
			sqlHeadSel
					.append(
							" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append(
							"' ,'yyyy-MM-dd')");
		}
		sqlHeadSel
				.append(" group by t1.wayid, t2.brand, t2.comcategory)s1, ch_pw_way w where s1.wayid = w.wayid");
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(
					params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(
					params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(
					params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_waymagcode())) {
			sqlHeadSel.append(" and w.waymagcode='").append(
					params.get_se_waymagcode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(
					params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(
					params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(
					params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_brand())) {
			sqlHeadSel.append(" and s1.brand='").append(params.get_se_brand())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid())
					.append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(
					params.get_sk_wayname()).append("%' ");
		}
		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode",
							Hibernate.STRING).addScalar("upperwayid",
							Hibernate.STRING).addScalar("waymagcode",
							Hibernate.STRING).addScalar("wayid",
							Hibernate.STRING).addScalar("wayname",
							Hibernate.STRING).addScalar("starlevel",
							Hibernate.SHORT).addScalar("orderid",
							Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("stocknum",
							Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(new Integer(params.get_pagesize()));
			querySel.setFirstResult(new Integer(params.get_pagesize()) * (_pageno - 1));
			List list = querySel.list(); 
			List list2 = new ArrayList();
			System.out.println("开始时间："+System.currentTimeMillis());
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SWaystocksnptVO vo = new SWaystocksnptVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setUpperwayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWaymagcode(obj[4] == null ? "" : obj[4].toString()); 
				vo.setWayid(obj[5] == null ? "" : obj[5].toString());
				vo.setWayname(obj[6] == null ? "" : obj[6].toString());
				vo.setStarlevel(obj[7] == null ? 0 : (Short) obj[7]);
				vo.setOrderid("");
				vo.setBrand(obj[9] == null ? "" : obj[9].toString());
				vo.setComcategory(obj[10] == null ? "" : obj[10].toString());
				vo.setStocknum(obj[11] == null ? 0 : (Long) obj[11]);

				list2.add(vo);
			}
			System.out.println("结束时间："+System.currentTimeMillis());
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
     * 网点空白SIM卡销售量统计
     * @param params
     * @return
     * @throws Exception
     */
	public DataPackage querySaleStatistic(WaystocksnptDBParam params) throws Exception{
    	int _pageno = 1;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer(params.get_pageno()));
		if("0".equals(params.get_pagesize())){
			params.setQueryAll(true);
		}
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer("select w.countyid, w.svccode, w.mareacode, ")
			.append("w.upperwayid, w.waymagcode, s1.wayid, w.wayname, w.starlevel, '' as orderid, ")
			.append("s1.comcategory, s1.cnt2 as STOCKNUM from (select t1.wayid, t2.comcategory, ")
			.append("count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 ")
			.append("where t1.wayid = t2.wayid and t2.restype = 'EMPTYSIM' ");
		
		if (StringUtils.isNotEmpty(params.get_dnl_createtime())
				&& StringUtils.isNotEmpty(params.get_dnm_createtime())) {
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append("', 'yyyy-MM-dd')");
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_createtime())
				&& StringUtils.isEmpty(params.get_dnl_createtime())) {
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'), 'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_createtime())
				&& StringUtils.isNotEmpty(params.get_dnl_createtime())) {
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append("', 'yyyy-MM-dd')");
		}
		
		sqlHeadSel.append(" group by t1.wayid, t2.comcategory) s1, ch_pw_way w where s1.wayid = w.wayid ");
		
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_waymagcode())) {
			sqlHeadSel.append(" and w.waymagcode='").append(params.get_se_waymagcode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(params.get_sk_wayname()).append("%' ");
		}
		
		sqlHeadSel.append(" union all ");
		sqlHeadSel.append("select w.countyid, w.svccode, w.mareacode, w.upperwayid, ")
			.append("w.waymagcode, s1.wayid, w.wayname, w.starlevel, '' as orderid, ")
			.append("s1.comcategory, s1.cnt2 as STOCKNUM from (select t1.wayid, ")
			.append("t2.comcategory, count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 ")
			.append("where t1.wayid = t2.wayid and t2.restype = 'EMPTYSIM' and t2.batchno is null ");
		
		if (StringUtils.isNotEmpty(params.get_dnl_createtime())
				&& StringUtils.isNotEmpty(params.get_dnm_createtime())) {
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append("', 'yyyy-MM-dd')");
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_createtime())
				&& StringUtils.isEmpty(params.get_dnl_createtime())) {
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'), 'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_createtime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_createtime())
				&& StringUtils.isNotEmpty(params.get_dnl_createtime())) {
			sqlHeadSel.append(" and to_date(to_char(t2.createtime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_createtime()).append("', 'yyyy-MM-dd')");
		}
		
		sqlHeadSel.append(" group by t1.wayid, t2.comcategory) s1, ch_pw_way w where s1.wayid = w.wayid ");
		
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_waymagcode())) {
			sqlHeadSel.append(" and w.waymagcode='").append(params.get_se_waymagcode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(params.get_sk_wayname()).append("%' ");
		}
		
		Session session = SessionUtils.currentSession(getDbFlag());

		try {
			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("countyid", Hibernate.STRING)
					.addScalar("svccode", Hibernate.STRING)
					.addScalar("mareacode", Hibernate.STRING)
					.addScalar("upperwayid", Hibernate.STRING)
					.addScalar("waymagcode", Hibernate.STRING)
					.addScalar("wayid", Hibernate.STRING)
					.addScalar("wayname", Hibernate.STRING)
					.addScalar("starlevel", Hibernate.SHORT)
					.addScalar("orderid", Hibernate.STRING)
					.addScalar("comcategory", Hibernate.STRING)
					.addScalar("stocknum", Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(new Integer(params.get_pagesize()));
			querySel.setFirstResult(new Integer(params.get_pagesize()) * (_pageno - 1));
			List list = querySel.list(); 
			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SWaystocksnptVO vo = new SWaystocksnptVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setUpperwayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWaymagcode(obj[4] == null ? "" : obj[4].toString()); 
				vo.setWayid(obj[5] == null ? "" : obj[5].toString());
				vo.setWayname(obj[6] == null ? "" : obj[6].toString());
				vo.setStarlevel(obj[7] == null ? 0 : (Short) obj[7]);
				vo.setOrderid("");
				vo.setComcategory(obj[9] == null ? "" : obj[9].toString());
				vo.setStocknum(obj[10] == null ? 0 : (Long) obj[10]);

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
     * 网点空白SIM卡使用量统计
     * @param params
     * @return
     * @throws Exception
     */
    public DataPackage queryUsedStatistic(WaystocksnptDBParam params) throws Exception{
    	int _pageno = 1;
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(new Integer(params.get_pageno()));
		if("0".equals(params.get_pagesize())){
			params.setQueryAll(true);
		}
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer("select w.countyid, w.svccode, w.mareacode, ")
				.append("w.upperwayid, w.waymagcode, s1.wayid, w.wayname, w.starlevel, ")
				.append("'' as orderid, s1.comcategory, s1.cnt2 as STOCKNUM from (")
				.append("select t1.wayid, t2.comcategory, count(*) as cnt2 from ch_pw_way t1, ")
				.append("FX_SW_PARTNERRES t2, FX_SN_SIMNOACTINFO t5 where t1.wayid = t2.wayid ")
				.append("and t2.restype = 'EMPTYSIM' and t2.isactive = 1 and t2.emptyno = t5.emptyno ");
		
		if (StringUtils.isNotEmpty(params.get_dnl_changetime())
				&& StringUtils.isNotEmpty(params.get_dnm_changetime())) {
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_changetime()).append("', 'yyyy-MM-dd')");
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_changetime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_changetime())
				&& StringUtils.isEmpty(params.get_dnl_changetime())) {
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'), 'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_changetime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_changetime())
				&& StringUtils.isNotEmpty(params.get_dnl_changetime())) {
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_changetime()).append("', 'yyyy-MM-dd')");
		}
		
		sqlHeadSel.append(" group by t1.wayid, t2.comcategory) s1, ch_pw_way w where s1.wayid = w.wayid ");
		
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(params.get_sk_wayname()).append("%' ");
		}
		
		sqlHeadSel.append(" union all ");
		sqlHeadSel.append("select w.countyid, w.svccode, w.mareacode, w.upperwayid, w.waymagcode, ")
				.append("s1.wayid, w.wayname, w.starlevel, '' as orderid, s1.comcategory, ")
				.append("s1.cnt2 as STOCKNUM from (select t1.wayid, t2.comcategory, count(*) as cnt2")
				.append(" from ch_pw_way t1, FX_SW_PARTNERRES t2, FX_SN_SIMNOACTINFO t5 where ")
				.append("t1.wayid = t2.wayid and t2.emptyno = t5.emptyno and t2.restype = 'EMPTYSIM' ")
				.append("and t2.isactive = 1 and t2.batchno is null ");
		
		if (StringUtils.isNotEmpty(params.get_dnl_changetime())
				&& StringUtils.isNotEmpty(params.get_dnm_changetime())) {
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_changetime()).append("', 'yyyy-MM-dd')");
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_changetime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isNotEmpty(params.get_dnm_changetime())
				&& StringUtils.isEmpty(params.get_dnl_changetime())) {
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'), 'yyyy-MM-dd') <= to_date('")
					.append(params.get_dnm_changetime()).append("', 'yyyy-MM-dd')");
		} else if (StringUtils.isEmpty(params.get_dnm_changetime())
				&& StringUtils.isNotEmpty(params.get_dnl_changetime())) {
			sqlHeadSel.append(" and to_date(to_char(t5.changetime, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_date('")
					.append(params.get_dnl_changetime()).append("', 'yyyy-MM-dd')");
		}
		
		sqlHeadSel.append(" group by t1.wayid, t2.comcategory) s1, ch_pw_way w where s1.wayid = w.wayid ");
		
		if (StringUtils.isNotEmpty(params.get_se_countyid())) {
			sqlHeadSel.append(" and w.countyid='").append(params.get_se_countyid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_svccode())) {
			sqlHeadSel.append(" and w.svccode='").append(params.get_se_svccode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_mareacode())) {
			sqlHeadSel.append(" and w.mareacode='").append(params.get_se_mareacode()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_upperwayid())) {
			sqlHeadSel.append(" and w.upperwayid='").append(params.get_se_upperwayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_comcategory())) {
			sqlHeadSel.append(" and s1.comcategory='").append(params.get_se_comcategory()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_ne_starlevel())) {
			sqlHeadSel.append(" and w.starlevel='").append(params.get_ne_starlevel()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_se_wayid())) {
			sqlHeadSel.append(" and s1.wayid='").append(params.get_se_wayid()).append("' ");
		}
		if (StringUtils.isNotEmpty(params.get_sk_wayname())) {
			sqlHeadSel.append(" and w.wayname like '%").append(params.get_sk_wayname()).append("%' ");
		}
		
		Session session = SessionUtils.currentSession(getDbFlag());

		try {
			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("countyid", Hibernate.STRING)
					.addScalar("svccode", Hibernate.STRING)
					.addScalar("mareacode", Hibernate.STRING)
					.addScalar("upperwayid", Hibernate.STRING)
					.addScalar("waymagcode", Hibernate.STRING)
					.addScalar("wayid", Hibernate.STRING)
					.addScalar("wayname", Hibernate.STRING)
					.addScalar("starlevel", Hibernate.SHORT)
					.addScalar("orderid", Hibernate.STRING)
					.addScalar("comcategory", Hibernate.STRING)
					.addScalar("stocknum", Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(new Integer(params.get_pagesize()));
			querySel.setFirstResult(new Integer(params.get_pagesize()) * (_pageno - 1));
			List list = querySel.list(); 
			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SWaystocksnptVO vo = new SWaystocksnptVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setUpperwayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWaymagcode(obj[4] == null ? "" : obj[4].toString()); 
				vo.setWayid(obj[5] == null ? "" : obj[5].toString());
				vo.setWayname(obj[6] == null ? "" : obj[6].toString());
				vo.setStarlevel(obj[7] == null ? 0 : (Short) obj[7]);
				vo.setOrderid("");
				vo.setComcategory(obj[9] == null ? "" : obj[9].toString());
				vo.setStocknum(obj[10] == null ? 0 : (Long) obj[10]);

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

	// 网点套卡激活统计批量导出
    public DataPackage queryActiveSmpListBatchExp(WaystocksnptDBParam params) throws Exception {
    	StringBuffer strBuffer = new StringBuffer();
		List<String> wayids = params.get_sin_wayid();
		if (wayids != null && wayids.size() > 0) {
			for (String wayid : wayids) {
				strBuffer.append("'").append(wayid).append("'").append(",");
			}
			int length = strBuffer.length();
			if (length > 0) {
				strBuffer.delete(length-1, length);
			}
		}
		
		String querySql = "select * from (select w.countyid, w.svccode, w.mareacode, " +
			"w.upperwayid, s1.wayid, w.wayname, w.starlevel, '' as orderid, s1.brand, " +
			"s1.comcategory, s1.cnt2 as STOCKNUM from (select t2.wayid, t2.brand, " +
			"t2.comcategory, count(*) as cnt2 from FX_SW_PARTNERRES t2 where t2.restype " +
			"= 'COMRESSMP' and t2.isactive = '1' group by t2.wayid, t2.brand, " +
			"t2.comcategory) s1, ch_pw_way w where s1.wayid = w.wayid) t";
		
		if (strBuffer.length() > 0) {
			querySql += " where t.wayid in (" + strBuffer.toString() + ")";
		}

		Session session = SessionUtils.currentSession(getDbFlag());
		DataPackage result = new DataPackage();
		try {
			// 取总页数
			Query querySel = session.createSQLQuery(querySql.toString())
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode",
							Hibernate.STRING).addScalar("upperwayid",
							Hibernate.STRING).addScalar("wayid",
							Hibernate.STRING).addScalar("wayname",
							Hibernate.STRING).addScalar("starlevel",
							Hibernate.SHORT).addScalar("orderid",
							Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("stocknum",
							Hibernate.LONG);
			List list = querySel.list();

			String sql = "select * from (select s1.wayid, s1.brand, s1.comcategory, " +
				"s1.cnt2 as ORDUNM from (select t2.wayid, t2.brand, t2.comcategory, " +
				"count(*) as cnt2 from FX_SW_PARTNERRES t2 where t2.restype = 'COMRESSMP' " +
				"group by t2.wayid, t2.brand, t2.comcategory) s1, ch_pw_way w where " +
				"s1.wayid = w.wayid) t";
			if (strBuffer.length() > 0) {
				sql += " where t.wayid in (" + strBuffer.toString() + ")";
			}
			Query querySel2 = session.createSQLQuery(sql)
					.addScalar("wayid", Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("ordunm",
							Hibernate.LONG);
			List iter2 = querySel2.list();
			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {// 对库存集合进行遍历
				Long salenum = 0L;// salenum=平均销售量
				Object[] obj = (Object[]) itt.next();
				String wayid = (obj[4] == null ? "" : obj[4].toString());
				String brand = (obj[8] == null ? "" : obj[8].toString());
				String comcategory = (obj[9] == null ? "" : obj[9].toString());
				for (Iterator itt2 = iter2.iterator(); itt2.hasNext();) {// 对订购量集合进行遍历
					Object[] obj2 = (Object[]) itt2.next();
					if (wayid.equals(obj2[0]) && brand.equals(obj2[1])
							&& comcategory.equals(obj2[2])) {
						salenum = (Long) obj2[3];
						break;
					}
				}
				SWaystocksnptVO vo = new SWaystocksnptVO();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString()); 
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setUpperwayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWayid(obj[4] == null ? "" : obj[4].toString());
				vo.setWayname(obj[5] == null ? "" : obj[5].toString());
				vo.setStarlevel(obj[6] == null ? 0 : (Short) obj[6]);
				vo.setOrderid("");
				vo.setBrand(obj[8] == null ? "" : obj[8].toString());
				vo.setComcategory(obj[9] == null ? "" : obj[9].toString());
				vo.setStocknum(obj[10] == null ? 0 : (Long) obj[10]);

				Double rate = 0D;
				if (salenum > 0) {
					// 激活率=平均激活量/平均销售量
					rate = Double.valueOf(new Double(vo.getStocknum()) / (new Double(salenum)));
				} else {
					rate = 1.0;
				}
				vo.setActrate(rate);
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

	// 网点充值卡销售量统计批量导出
	public DataPackage querySalesCardlistBatchExp(WaystocksnptDBParam params) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		List<String> wayids = params.get_sin_wayid();
		if (wayids != null && wayids.size() > 0) {
			for (String wayid : wayids) {
				strBuffer.append("'").append(wayid).append("'").append(",");
			}
			int length = strBuffer.length();
			if (length > 0) {
				strBuffer.delete(length-1, length);
			}
		}
		
		String querySql = "select * from (select w.countyid, w.svccode, w.mareacode, " +
			"s1.wayid, w.wayname, w.starlevel, '' as orderid, '' as brand, s1.comcategory, " +
			"s1.cnt2 as STOCKNUM from (select t1.wayid, t2.comcategory, count(*) as cnt2 " +
			"from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and t2.restype " +
			"= 'COMRESCARD' group by t1.wayid, t2.brand, t2.comcategory) s1, ch_pw_way w " +
			"where s1.wayid = w.wayid union select w.countyid, w.svccode, w.mareacode, " +
			"s1.wayid, w.wayname, w.starlevel, '' as orderid, s1.brand, s1.comcategory, " +
			"s1.cnt2 as STOCKNUM from (select t1.wayid, t2.brand, t2.comcategory, count(*) " +
			"as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and " +
			"t2.restype = 'COMRESCARD' and t2.batchno is null group by t1.wayid, t2.brand, " +
			"t2.comcategory) s1, ch_pw_way w where s1.wayid = w.wayid) t";
		
		if (strBuffer.length() > 0) {
			querySql += " where t.wayid in (" + strBuffer.toString() + ")";
		}
		
		Session session = SessionUtils.currentSession(getDbFlag());
		DataPackage result = new DataPackage();
		try {
			// 取总页数
			Query querySel = session.createSQLQuery(querySql)
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode",
							Hibernate.STRING).addScalar("wayid",
							Hibernate.STRING).addScalar("wayname",
							Hibernate.STRING).addScalar("starlevel",
							Hibernate.SHORT).addScalar("orderid",
							Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("stocknum",
							Hibernate.LONG);
			List list = querySel.list();
			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SWaystocksnptVO vo = new SWaystocksnptVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setWayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWayname(obj[4] == null ? "" : obj[4].toString());
				vo.setStarlevel(obj[5] == null ? 0 : (Short) obj[5]);
				vo.setOrderid("");
				vo.setBrand("");
				vo.setComcategory(obj[8] == null ? "" : obj[8].toString());
				vo.setStocknum(obj[9] == null ? 0 : (Long) obj[9]);
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

	// 网点套卡销售量统计批量导出
	public DataPackage querySalesSmplistBatchExp(WaystocksnptDBParam params) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		List<String> wayids = params.get_sin_wayid();
		if (wayids != null && wayids.size() > 0) {
			for (String wayid : wayids) {
				strBuffer.append("'").append(wayid).append("'").append(",");
			}
			int length = strBuffer.length();
			if (length > 0) {
				strBuffer.delete(length-1, length);
			}
		}
		String querySql = "select * from (select w.countyid, w.svccode, w.mareacode, " +
			"w.upperwayid, w.waymagcode, s1.wayid, w.wayname, w.starlevel, '' as orderid, " +
			"s1.brand, s1.comcategory, s1.cnt2 as STOCKNUM from (select t1.wayid, " +
			"t2.brand, t2.comcategory, count(*) as cnt2 from ch_pw_way t1, FX_SW_PARTNERRES t2 " +
			"where t1.wayid = t2.wayid and t2.restype = 'COMRESSMP' group by t1.wayid, " +
			"t2.brand, t2.comcategory) s1, ch_pw_way w where s1.wayid = w.wayid union select " +
			"w.countyid, w.svccode, w.mareacode, w.upperwayid, w.waymagcode, s1.wayid, " +
			"w.wayname, w.starlevel, '' as orderid, s1.brand, s1.comcategory, s1.cnt2 as " +
			"STOCKNUM from (select t1.wayid, t2.brand, t2.comcategory, count(*) as cnt2 " +
			"from ch_pw_way t1, FX_SW_PARTNERRES t2 where t1.wayid = t2.wayid and t2.restype " +
			"= 'COMRESSMP' and t2.batchno is null group by t1.wayid, t2.brand, t2.comcategory) " +
			"s1, ch_pw_way w where s1.wayid = w.wayid) t";
		if (strBuffer.length() > 0) {
			querySql += " where t.wayid in (" + strBuffer.toString() + ")";
		}
		
		Session session = SessionUtils.currentSession(getDbFlag());
		DataPackage result = new DataPackage();
		try {
			// 取总页数
			Query querySel = session.createSQLQuery(querySql)
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode",
							Hibernate.STRING).addScalar("upperwayid",
							Hibernate.STRING).addScalar("waymagcode",
							Hibernate.STRING).addScalar("wayid",
							Hibernate.STRING).addScalar("wayname",
							Hibernate.STRING).addScalar("starlevel",
							Hibernate.SHORT).addScalar("orderid",
							Hibernate.STRING).addScalar("brand",
							Hibernate.STRING).addScalar("comcategory",
							Hibernate.STRING).addScalar("stocknum",
							Hibernate.LONG);
			List list = querySel.list();
			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SWaystocksnptVO vo = new SWaystocksnptVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setUpperwayid(obj[3] == null ? "" : obj[3].toString());
				vo.setWaymagcode(obj[4] == null ? "" : obj[4].toString()); 
				vo.setWayid(obj[5] == null ? "" : obj[5].toString());
				vo.setWayname(obj[6] == null ? "" : obj[6].toString());
				vo.setStarlevel(obj[7] == null ? 0 : (Short) obj[7]);
				vo.setOrderid("");
				vo.setBrand(obj[9] == null ? "" : obj[9].toString());
				vo.setComcategory(obj[10] == null ? "" : obj[10].toString());
				vo.setStocknum(obj[11] == null ? 0 : (Long) obj[11]);
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
