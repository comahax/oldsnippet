/**
 * auto-generated code
 * Thu Sep 17 15:17:36 CST 2009
 */
package com.gmcc.pboss.business.promotion.ppzlnres;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.apache.commons.lang.StringUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PpzlnresDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnresDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public PpzlnresDAO() {
		super(PpzlnresVO.class);
	}

	public DataPackage doQueryComcategory(PpzlnresDBParam params)
			throws Exception {
		int _pagesize = 20, _pageno = 1;
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
				"select a.resid as resid, c.comcategory as comcategory from ch_cx_ppzlnres a, IM_FX_COMRESSMP b, Im_Pr_Comcategoryrela c where a.resid = b.comresid and b.comid=c.comid and a.pid="
						+ params.get_ne_pid());
		if (StringUtils.isNotEmpty(params.get_se_resid())) {
			sqlHeadSel.append(" and a.resid = '").append(params.get_se_resid())
					.append("' ");
		}

		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("resid", Hibernate.STRING).addScalar(
							"comcategory", Hibernate.STRING);

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
				PpzlnresCatergoryVO vo = new PpzlnresCatergoryVO();
				Object[] obj = (Object[]) itt.next();
				vo.setResid(obj[0].toString());
				vo.setComcategory(obj[1].toString());

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
