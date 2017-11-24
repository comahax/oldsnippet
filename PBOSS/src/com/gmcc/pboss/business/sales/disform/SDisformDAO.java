/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.business.sales.disform;

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
 * <p>Title: DisformDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class SDisformDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public SDisformDAO(){
        super(SDisformVO.class);
    }
    
    public DataPackage doDisformState(DisformDBParam params) throws Exception {
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
		result.setPageNo(new Integer(params.get_pageno()));
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer(
				"select c.countyid,c.svccode,c.mareacode,a.disstate,count(*) as num from FX_SW_DISFORM a, FX_SW_ORDER b, CH_PW_WAY c where a.orderid = b.orderid and a.recewayid = c.wayid and b.wayid = c.wayid");
			sqlHeadSel.append(" and a.createtime <= to_date('").append(params.get_dnm_createtime())
					.append("', 'yyyy-MM-dd hh24:mi:ss') ");
			sqlHeadSel.append(" and a.createtime >= to_date('").append(params.get_dnl_createtime())
					.append("','yyyy-MM-dd hh24:mi:ss') ");
			if (StringUtils.isNotEmpty(params.get_se_countyid())){
				sqlHeadSel.append(" and c.countyid = '").append(params.get_se_countyid()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_svccode())){
				sqlHeadSel.append(" and c.svccode = '").append(params.get_se_svccode()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_mareacode())){
				sqlHeadSel.append(" and c.mareacode = '").append(params.get_se_mareacode()).append("' ");
			}
			if (StringUtils.isNotEmpty(params.get_se_disstate())){
				sqlHeadSel.append(" and a.disstate = '").append(params.get_se_disstate()).append("' ");
			}
			sqlHeadSel.append(" group by c.countyid,c.svccode,c.mareacode,a.disstate order by c.countyid,c.svccode,c.mareacode,a.disstate");

		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("countyid", Hibernate.STRING).addScalar(
							"svccode", Hibernate.STRING).addScalar("mareacode", Hibernate.STRING)
							.addScalar("disstate", Hibernate.STRING).
							addScalar("num", Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(count);
			querySel.setFirstResult(count * (_pageno - 1));
			List list = querySel.list();

			List list2 = new ArrayList();
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				SDisformVO vo = new SDisformVO();
				Object[] obj = (Object[]) itt.next();
				vo.setCountyid(obj[0] == null ? "" : obj[0].toString());
				vo.setSvccode(obj[1] == null ? "" : obj[1].toString());
				vo.setMareacode(obj[2] == null ? "" : obj[2].toString());
				vo.setDisstate(obj[3] == null ? "" : obj[3].toString());
				vo.setNum(obj[4] == null ? new Long("0") : new Long(obj[4].toString()));

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
    
    public DataPackage doQuerySignnum(DisformDBParam params) throws Exception {
    	Long signnum = new Long(0);
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
		result.setPageNo(new Integer(params.get_pageno()));
		result.setPageSize(new Integer(params.get_pagesize()));

		StringBuffer sqlHeadSel = new StringBuffer(
				"select count(*) as num from FX_SW_DISFORM a, FX_SW_ORDER b, CH_PW_WAY c where a.orderid = b.orderid and a.recewayid = c.wayid and b.wayid = c.wayid");
			sqlHeadSel.append(" and a.createtime <= to_date('").append(params.get_dnm_createtime())
					.append("', 'yyyy-MM-dd hh24:mi:ss') ");
			sqlHeadSel.append(" and a.createtime >= to_date('").append(params.get_dnl_createtime())
					.append("','yyyy-MM-dd hh24:mi:ss') ");
			if(StringUtils.isNotEmpty(params.get_se_countyid())){
				sqlHeadSel.append(" and c.countyid = '").append(params.get_se_countyid()).append("' ");
			}
			if(StringUtils.isNotEmpty(params.get_se_svccode())){
				sqlHeadSel.append(" and c.svccode = '").append(params.get_se_svccode()).append("' ");
			}
			if(StringUtils.isNotEmpty(params.get_se_mareacode())){
				sqlHeadSel.append(" and c.mareacode = '").append(params.get_se_mareacode()).append("' ");
			}
			if(StringUtils.isNotEmpty(params.get_se_disstate())){
				sqlHeadSel.append(" and a.disstate = '").append(params.get_se_disstate()).append("' ");
			}
			if(StringUtils.isNotEmpty(params.get_se_signstate())){
				sqlHeadSel.append(" and b.signstate = '").append(params.get_se_signstate()).append("' ");
			}
				sqlHeadSel.append(" group by c.countyid,c.svccode,c.mareacode,a.disstate order by c.countyid,c.svccode,c.mareacode,a.disstate");
			
			
		Session session = SessionUtils.currentSession(getDbFlag());

		try {

			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
					.addScalar("num", Hibernate.LONG);

			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();

			// 取指定页面
			querySel.setMaxResults(new Integer("1"));
			querySel.setFirstResult(new Integer("0"));
			List list = querySel.list();

			List list2 = new ArrayList();
			if(list.size()>0){
				signnum = (Long) list.get(0);
			}
			list2.add(signnum);
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
