package com.gmcc.pboss.biz.info.salesDetail.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class EmployeeQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		EmployeeQueryParameter p = (EmployeeQueryParameter)parameter;
		StringBuffer hql = new StringBuffer();
		
		//网店编码--根据网点编码查询店员店主
		if(StringUtils.isNotEmpty(p.getWayid())){
			hql.append("select e from com.gmcc.pboss.member.model.Employee e");
			hql.append(" where e.wayid=:wayid and e.isnet in (0,1)");//and isnet=:isnet
		}
		//渠道经理编码--根据经理id查询渠道表，并连接人员表，获取所有经理下属店员店主
		if(StringUtils.isNotEmpty(p.getWaymagcode())){
			hql.append("select e ");
			hql.append(" from com.gmcc.pboss.member.model.Employee e ,com.gmcc.pboss.biz.info.node.model.Way w");//
			hql.append(" where e.wayid = w.wayid and w.waymagcode = :managerid ");// 
		}
		//弹出框使用
		if(StringUtils.isNotEmpty(p.getEmployeeid())){
			hql.append(" and e.employeeid like :employeeid");
		}
		//弹出框使用
		if(StringUtils.isNotEmpty(p.getEmployeename())){
			hql.append(" and e.employeename like :employeename");
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
		EmployeeQueryParameter p = (EmployeeQueryParameter)parameter;
		//网店编码--根据网点编码查询店员店主
		if(StringUtils.isNotEmpty(p.getWayid())){
			query.setString("wayid", p.getWayid());
		}
		if(StringUtils.isNotEmpty(p.getWaymagcode())){
			query.setString("managerid", p.getWaymagcode());
		}
		if(StringUtils.isNotEmpty(p.getEmployeeid())){
			query.setString("employeeid", "%"+p.getEmployeeid().trim()+"%");
		}
		if(StringUtils.isNotEmpty(p.getEmployeename())){
			query.setString("employeename", "%"+p.getEmployeename().trim()+"%");
		}
		
	}

}
