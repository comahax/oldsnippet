/**
 * auto-generated code
 * Tue Sep 01 14:54:44 CST 2009
 */
package com.gmcc.pboss.business.resource.comrescard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComrescardDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComrescardDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ComrescardDAO(){
        super(ComrescardVO.class);
    }
    public DataPackage doQueryComcategory(ComrescardDBParam param,String comcategory,String countyid,String svccode,String mareacode)
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
				"select {t1.*} ,t2.brand as brand from IM_FX_COMRESCARD t1  ,IM_PR_COMCATEGORYRELA t2 ");
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
		
		Map drawPara = param.getDrawPara();
		if(drawPara != null && !"".equals(drawPara)){
			if(drawPara.containsKey(comcategory)){
				List numDou = (List)drawPara.get(comcategory);
				if(numDou.size() == 1){
					String[] item = (String[])numDou.get(0);
					sqlHeadSel.append(" (to_number(comresid) >= "+item[0]+" and to_number(comresid) <= "+item[1]+") and ");
				}else{
					sqlHeadSel.append(" ( ");
					for (int i = 0; i < numDou.size(); i++) {
						String[] item = (String[])numDou.get(i);
						if(i == (numDou.size() - 1)){
							sqlHeadSel.append(" (to_number(comresid) >= "+item[0]+" and to_number(comresid) <= "+item[1]+") ");
						}else{
							sqlHeadSel.append(" (to_number(comresid) >= "+item[0]+" and to_number(comresid) <= "+item[1]+") or ");
						}
					}
					sqlHeadSel.append(" ) and ");
				}
				
			}
		}
		
		sqlHeadSel.append("  t1.comid=t2.comid and t2.comcategory='"+comcategory+"' and  t1.comstate="+param.get_ne_comstate()
				+" order by t1.batchno,t1.comresid asc");
		
		
		Session session = SessionUtils.currentSession(getDbFlag());
		
		try {
		
			// 取总页数
			Query querySel = session.createSQLQuery(sqlHeadSel.toString())
									.addEntity("t1",ComrescardVO.class)
									.addScalar("brand",Hibernate.STRING);
		
			List iter = querySel.list();
			int count = iter.size();
			result.setRowCount(count);
			iter.clear();
		
			// 取指定页面
			querySel.setMaxResults(_pagesize);
			querySel.setFirstResult(_pagesize * (_pageno - 1));
			List list = querySel.list();
		
			List list2 = new ArrayList();
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
			}
		
			result.setDatas(list2);
			list.clear();
		
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
