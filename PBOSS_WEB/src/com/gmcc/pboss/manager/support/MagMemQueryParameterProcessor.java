package com.gmcc.pboss.manager.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class MagMemQueryParameterProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {
	
	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		ManagerMemberQueryParameter p = (ManagerMemberQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		
		if(!StringUtils.isNotEmpty(p.getEmployeeid())){
			hql.append("select e ");
			hql.append(" from com.gmcc.pboss.member.model.Employee e ,com.gmcc.pboss.biz.info.node.model.Way w");//
			hql.append(" where e.wayid = w.wayid and w.waymagcode = :managerid ");// 
			hql.append(" and e.isnet in(")
			   .append(Role.SHOP_ASSISTANT).append(',')
			   .append(Role.SHOP_MASTER)
			   .append(')');
			if(StringUtils.isNotEmpty(p.getOfficetel())){
				hql.append(" and e.officetel = :officetel " );
			}
		}
		
		if(StringUtils.isNotEmpty(p.getEmployeeid())){
			hql.append(" select e from com.gmcc.pboss.member.model.Employee e where e.employeeid = :employeeid" );
		}
		
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		ManagerMemberQueryParameter p = (ManagerMemberQueryParameter)parameter;
		
		if(!StringUtils.isNotEmpty(p.getEmployeeid())){
			query.setString("managerid", p.getManagerid());
			
			if(StringUtils.isNotEmpty(p.getOfficetel())){
				query.setString("officetel", p.getOfficetel());
			}
		}
		
		if(StringUtils.isNotEmpty(p.getEmployeeid())){
			query.setString("employeeid", p.getEmployeeid());
		}
	}
}
