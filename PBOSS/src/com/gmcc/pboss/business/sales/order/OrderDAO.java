/**
 * auto-generated code
 * Mon Oct 12 14:56:43 CST 2009
 */
package com.gmcc.pboss.business.sales.order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: OrderDAO
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
 * @author wefrogll
 * @version 1.0
 */
public class OrderDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public OrderDAO() {
		super(OrderVO.class);
	}

	/**
	 * ��ѯ��װ��˸�����Ϣ����
	 * 
	 * @param orderVO
	 * @throws Exception
	 */
	public List<AuxiliaryInfoVO> doGetAuxiliaryInfo(OrderVO orderVO)
			throws Exception {
		Session session = SessionUtils.currentSession(getDbFlag());
		// ��ѯ��渨����Ϣ
		SQLQuery query1 = ((SQLQuery) session
				.getNamedQuery("com.gmcc.pboss.business.sales.order.doGetAuxiliaryInfo.part1"));
		String sql1 = query1.getQueryString().replaceAll(":countyid",
				"'" + orderVO.getCountyid() + "'");
		sql1 = sql1.replaceAll(":wayid", "'" + orderVO.getWayid() + "'");
		query1 = session.createSQLQuery(sql1).addScalar("brand",
				Hibernate.STRING).addScalar("countyStock", Hibernate.LONG)
				.addScalar("wayStock", Hibernate.LONG);
		;
		List<Object[]> infolist = query1.list();
		// ��ѯ�����ʸ�����Ϣ
		Query query2 = session
				.getNamedQuery("com.gmcc.pboss.business.sales.order.doGetAuxiliaryInfo.part2");
		query2.setParameter("yearmonth", getLastYYYYMM());
		query2.setParameter("wayid", orderVO.getWayid());
		List<Object[]> actalarmList = null;
		AuxiliaryInfoVO auxiliaryInfoVO = null;
		AuxilaryActalarmVO auxilaryActalarmVO = null;
		List<AuxiliaryInfoVO> infoList = new ArrayList<AuxiliaryInfoVO>();
		for (Object[] vo : infolist) {
			// ��װ��渨����Ϣ
			auxiliaryInfoVO = new AuxiliaryInfoVO();
			auxiliaryInfoVO.setBrand((String) vo[0]);
			auxiliaryInfoVO.setCountyStock((Long) vo[1]);
			auxiliaryInfoVO.setWayStock((Long) vo[2]);
			query2.setParameter("brand", auxiliaryInfoVO.getBrand());
			actalarmList = query2.list();
			// ��װ�����ʸ�����Ϣ
			for (Object[] act : actalarmList) {
				auxilaryActalarmVO = new AuxilaryActalarmVO();
				auxilaryActalarmVO.setStattype((String) act[0]);
				auxilaryActalarmVO.setRate(((BigDecimal) act[1]).doubleValue());
				auxiliaryInfoVO.getAuxilaryActalarmList().add(
						auxilaryActalarmVO);
			}
			infoList.add(auxiliaryInfoVO);
		}
		return infoList;
	}

	/**
	 * ��ȡ����������
	 * 
	 * @param wayid
	 * @param monthParam
	 * @return
	 * @throws Exception
	 */
	public Long doGetGiveCount(String wayid, String monthParam)
			throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");// ���Է�����޸����ڸ�ʽ
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.MONTH, 1);
		if (cd.get(Calendar.MONTH) == 12) {
			cd.add(Calendar.YEAR, 1);
		}
		String nextYYYYMM = dateFormat.format(cd.getTime());
		if (cd.get(Calendar.MONTH) - (Integer.parseInt(monthParam)) < 0) {
			cd.roll(Calendar.YEAR, -1);
		}
		cd.roll(Calendar.MONTH, -(Integer.parseInt(monthParam)));
		String afterYYYYMM = dateFormat.format(cd.getTime());
		String sql = "select count(1) cou from FX_SW_ORDER o where o.orderave='AUTO' and o.orderstate='CANCEL' and o.confirmflag <>0 "
				+ "  and o.statechgtime>=to_date('"
				+ afterYYYYMM
				+ "','yyyy-MM') and o.statechgtime<=to_date('"
				+ nextYYYYMM
				+ "','yyyy-MM') and o.wayid='" + wayid + "'";
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.createSQLQuery(sql).addScalar("cou",
				Hibernate.LONG);
		return (Long) query.list().get(0);
	}

	private String getLastYYYYMM() {
		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth();
		if (month == 0) {
			year -= 1;
			month = 12;
		}
		return Integer.toString(year)
				+ (month < 10 ? '0' + Integer.toString(month) : Integer
						.toString(month));
	}

	public Long getOrderResource(String countyid, String comcategory,
			String orderstate) throws Exception {

		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session
				.getNamedQuery("com.gmcc.pboss.business.sales.order.doGetOrderResource");
		query.setString("COUNTYID", countyid);
		query.setString("COMCATEGORY", comcategory);
		String[] states = orderstate.split(",");
		query.setParameterList("ORDERSTATE", states);
		// query.setString("ORDERSTATE", orderstate);
		List<Long> list = query.list();
		if (list.size() == 0) {
			return 0l;
		}
		return list.get(0);
	}

	public DataPackage doQueryOrderDisform(OrderDBParam params)
			throws Exception {
		params.setQueryAll(true);
		return queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.order.OrderDisformList", params);
	}

	public List doExcelRes(OrderDBParam orderDBParam) throws Exception {
		Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session
				.getNamedQuery("com.gmcc.pboss.business.sales.order.doExcelRes");
		// query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		// return
		// queryByNamedSqlQuery("com.gmcc.pboss.business.sales.order.doExcelRes").getDatas();
		orderDBParam.setSelectFieldsString("orderid,orderstate,countyid,wayid,starlevel,comcategory,orderamt");
		Object obj = this.queryBySql(query.getQueryString(),
				orderDBParam);

//		this.queryBySql(queryString, params)
		if (obj != null) {
			return ((DataPackage) obj).getDatas();
		} else {

			return null;
		}
	}



}
