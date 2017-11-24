package com.gmcc.pboss.member.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-1
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class MemberQueryParameterProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor  {
	
//	public void process(Criteria criteria, QueryParameter parameter) {
//		// TODO Auto-generated method stub
//		MemberQueryParameter p = (MemberQueryParameter)parameter;
//		criteria.add(Restrictions.eq("wayid", p.getWayId()));
//		//criteria.add(Restrictions.eq("isnet", new Long(Role.SHOP_ASSISTANT)));
//		//criteria.add(Restrictions.eq("empstatus", new Long(Role.INCUMBENCY)));
//		
//		if(StringUtils.isNotEmpty(p.getOfficeTel()))
//			criteria.add(Restrictions.eq("officetel", p.getOfficeTel()));
//	}
	
	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		MemberQueryParameter p = (MemberQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		hql.append("select e from com.gmcc.pboss.member.model.Employee e where e.wayid = :wayid ");
		
		
		if(StringUtils.isNotEmpty(p.getOfficeTel())){
			hql.append(" and e.officetel = :officetel" );
		}
		
		if(!StringUtils.isNotEmpty(p.getEmployeeid())){
			hql.append(" and e.isnet in(")
			   .append(Role.SHOP_ASSISTANT).append(',')
			   .append(Role.SHOP_MASTER)
			   .append(')');
		}
		
		if(StringUtils.isNotEmpty(p.getEmployeeid())){
			hql.append(" and e.employeeid = :employeeid" );
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
		MemberQueryParameter p = (MemberQueryParameter)parameter;
		query.setString("wayid", p.getWayId());
		
		if(StringUtils.isNotEmpty(p.getOfficeTel())){
			query.setString("officetel", p.getOfficeTel());
		}
		
		if(StringUtils.isNotEmpty(p.getEmployeeid())){
			query.setString("employeeid", p.getEmployeeid());
		}
	}
	
	

}
