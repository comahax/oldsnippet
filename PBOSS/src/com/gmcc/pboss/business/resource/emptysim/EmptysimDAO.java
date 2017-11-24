/**
 * auto-generated code
 * Wed Sep 02 13:59:58 CST 2009
 */
package com.gmcc.pboss.business.resource.emptysim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: EmptysimDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class EmptysimDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public EmptysimDAO(){
        super(EmptysimVO.class);
    }
    public DataPackage doQueryComcategory(EmptysimDBParam param,String countyid,String svccode,String mareacode)
	throws Exception {
		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}
		if (_pagesize > MAX_QUERY_COUNT) {
			_pagesize = MAX_QUERY_COUNT;
		}
		
		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(param,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}
		
		// 查询结果
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);
		StringBuffer sqlHeadSel = new StringBuffer(
				"select {t1.*}  from IM_FX_EMPTYSIM t1  ");
		if(countyid!=null){
			sqlHeadSel.append(" ,CH_PW_WAY t3 where t1.wayid=t3.wayid and t3.countyid='"+countyid+"' and " );
		}else if(svccode!=null){
			sqlHeadSel.append(" ,CH_PW_WAY t3 where t1.wayid=t3.wayid and t3.svccode='"+svccode+"' and ");
		}else if(mareacode!=null){
			sqlHeadSel.append(" ,CH_PW_WAY t3 where t1.wayid=t3.wayid and t3.mareacode='"+mareacode+"' and ");			
		}else{
			sqlHeadSel.append(" where ");
		}
		if(param.get_se_wayid()!=null){
			sqlHeadSel.append("  t1.wayid='"+param.get_se_wayid()+"' and ");
		}
		sqlHeadSel.append("  t1.comid = " + param.get_ne_comid()
				+ " and t1.usestate=" + param.get_ne_usestate()
				+ " order by t1.batchno, t1.EMPTYNO asc");
		
		Session session = SessionUtils.currentSession(getDbFlag());
		try {
			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
									.addEntity("t1",EmptysimVO.class);
									
			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();
		
			// 取指定页面
			querySel.setMaxResults(_pagesize);
			querySel.setFirstResult(_pagesize * (_pageno - 1));
			List list = querySel.list();
			result.setDatas(list);
		
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				ex.printStackTrace();
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}
}

