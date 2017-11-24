/**
 * auto-generated code
 * Sat Sep 05 15:14:44 CST 2009
 */
package com.gmcc.pboss.business.resource.comcategoryrela;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComcategoryrelaDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComcategoryrelaDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ComcategoryrelaDAO(){
        super(ComcategoryrelaVO.class);
    }
    
    public List<String> queryComcategoryByBrand(String brand) throws Exception {
    	Session session = SessionUtils.currentSession(getDbFlag());
		Query query = session.getNamedQuery("com.gmcc.pboss.business.resource.comcategoryrela.queryComcategoryByBrand");
		query.setString("BRAND", brand);
		List<String> list = query.list();
		return list;
    }
    
    public DataPackage loadComCateAndResType(ComcategoryrelaDBParam param)
			throws Exception {
		return queryByNamedSqlQuery(
				"com.gmcc.pboss.business.resource.comcategoryrela.loadComCateAndResType",
				param);
	}
    
    public DataPackage loadComCateAndBrand(ComcategoryrelaDBParam param)
			throws Exception {
		return queryByNamedSqlQuery(
				"com.gmcc.pboss.business.resource.comcategoryrela.loadComCateAndBrand",
				param);
	}
   
    public DataPackage queryDistinctComcategory(ComcategoryrelaDBParam param)
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
				"select distinct (COMCATEGORY), BRAND, RESTYPE from IM_PR_COMCATEGORYRELA where 1=1 ");
	
		if(param.get_se_comcategory()!=null){
			sqlHeadSel.append(" and COMCATEGORY='"+param.get_se_comcategory()+"' ");
		}
		if(param.get_se_brand()!=null){
			sqlHeadSel.append(" and BRAND='"+param.get_se_brand()+"' ");
		}
		
		
		
		Session session = SessionUtils.currentSession(getDbFlag());
		
		try {
		
			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
									.addScalar("COMCATEGORY",Hibernate.STRING)
									.addScalar("BRAND",Hibernate.STRING)
									.addScalar("RESTYPE",Hibernate.STRING);
		
			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			
			List list=null;
			if(_pagesize==0 || count<=_pagesize){
				list=iter;
			}else{
				iter.clear();
				querySel.setMaxResults(_pagesize);
				querySel.setFirstResult(_pagesize * (_pageno - 1));
				list = querySel.list();
			}
			// 取指定页面
			
			
		
			/*List list2 = new ArrayList();
			Object[] obj=null;
			Object[] nextobj=null;
			for (Iterator itt = list.iterator(); itt.hasNext();) {
				nextobj=(Object[]) itt.next();
				obj=new Object[2];
				if(nextobj[1] instanceof ComrescardVO){
					obj[0]=nextobj[0];
					obj[1]=(ComrescardVO)nextobj[1];
				}else{
					obj[1]=(ComrescardVO)nextobj[0];
					obj[0]=nextobj[1];
				}
				//vo.setResid(obj[0].toString());
				//vo.setComcategory(obj[1].toString());
		
				list2.add(obj);
			}*/
		
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
