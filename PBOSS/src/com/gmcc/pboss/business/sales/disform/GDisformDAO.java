/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.business.sales.disform;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
public class GDisformDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public GDisformDAO() {
		super(GDisformVO.class);
	}
	
	/**
	 * 查询打印页面配送单信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doGatherPrintDp(DisformDBParam params) throws Exception {
		params.getQueryConditions().put("dnmcreatetime", params.get_dnm_createtime());
		params.getQueryConditions().put("dnlcreatetime", params.get_dnl_createtime());
		params.getQueryConditions().put("COUNTYID", params.get_se_countyid());
		params.getQueryConditions().put("DISCOMCODE", params.get_se_discomcode());
		params.set_dnl_createtime(null);
		params.set_dnm_createtime(null);
		params.set_se_discomcode(null);
		params.set_se_countyid(null);
		params.set_pagesize("0");
		params.setDataOnly(true);
		return queryByNamedSqlQuery("doqueryGatherPrint", params);
	}
	
	public String doQuerySellingprice(GDisformVO vo) throws Exception{
		String dvalue = "";
		// 查询结果
		DataPackage result = new DataPackage();

		StringBuffer sqlHeadSel = new StringBuffer(
				"select b.price1 from IM_PR_COMCATEGORYRELA a, FX_RU_COMPRICE b where a.COMCATEGORY = b.COMCATEGORY and b.pricediftype='NODIF' and a.comid = '" + vo.getComid() + "'");

		Session session = SessionUtils.currentSession(getDbFlag());
		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("dvalue", Hibernate.STRING);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			List list = querySel.list();
			dvalue=(String) list.get(0);
			list.clear();
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return dvalue;
	}
}
