package com.gmcc.pboss.biz.info.salescnt.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.gmcc.pboss.biz.info.salescnt.dao.MemberDao;
import com.gmcc.pboss.biz.info.salescnt.support.SalescntQueryParameter;

public class MemberDaoHibernate extends HibernateDaoSupport implements MemberDao {

	/**
	 * 店员查询
	 */
	public Map<String,String> getMember(SalescntQueryParameter parameter) {
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql.append("select employeeid,employeename");	
		sql.append(" from ch_pw_employee e");
		sql.append(" where e.isnet in (0,1) and e.wayid=:wayid ");
		Query query = getSession().createSQLQuery(sql.toString());
		query.setString("wayid", parameter.getWayid2());
		
		// 店主/店员权限查询
		sql2.append("select employeeid,employeename,isnet");
		sql2.append(" from ch_pw_employee e");
		sql2.append(" where e.employeeid=:employeeid ");
		Query query2 = getSession().createSQLQuery(sql2.toString());
		query2.setString("employeeid", parameter.getOpEmployeeid());
		ArrayList<Object[]> list2 = (ArrayList) query2.list();
		int isnet = 0;
		Map<String,String> rtn2 = new LinkedHashMap<String,String>();
		for (Object[] obj:list2){
			BigDecimal dd = (BigDecimal)obj[2];
			isnet = dd.intValue();
			rtn2.put((String)obj[0],(String)obj[1]);
		}
		// 店主的时候
		if (1 == isnet) {
			parameter.setFlg("show");
			ArrayList<Object[]> list = (ArrayList) query.list();
			//封装返回值
			Map<String,String> rtn = new LinkedHashMap<String,String>();
			rtn.put("","所有员工");
			for (Object[] obj:list){
				rtn.put((String)obj[0],(String)obj[1]);
			}
			return rtn;
		} else {
			parameter.setFlg("notShow");
			return rtn2;
		}	
	}
	
}
