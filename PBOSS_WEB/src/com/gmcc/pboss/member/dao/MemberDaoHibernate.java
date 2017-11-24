package com.gmcc.pboss.member.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.member.model.Employee;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-29
 * 所属项目：
 * 所属模块：
 * 描述：
 */
public class MemberDaoHibernate extends BaseHqlQueryDao implements IMemberDao{

	public MemberDaoHibernate() {
		super(Employee.class);
	}
	
	public Employee getUserByOfficTel(String officeTel) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Property.forName("officetel").eq(officeTel));
		criteria.add(Property.forName("empstatus").eq(new Long(Role.INCUMBENCY)));
		return (Employee)criteria.uniqueResult();
	}
	
	public Employee getUserByOfftelIsnet(String officeTel,Long isnet) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		if(isnet != 2){//非专员
			criteria.add(Property.forName("officetel").eq(officeTel));
		}else{//专员
			criteria.add(Property.forName("telephone").eq(officeTel));
		}
		criteria.add(Property.forName("empstatus").eq(new Long(Role.INCUMBENCY)));
		criteria.add(Property.forName("isnet").eq(isnet));
		return (Employee)criteria.uniqueResult();
	}

	public List<Employee> getAllUserByOfficTel(String officeTel) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Property.forName("officetel").eq(officeTel));
		criteria.add(Property.forName("empstatus").eq(new Long(Role.INCUMBENCY)));
		//return (Employee)criteria.uniqueResult();
		return (List<Employee>)criteria.list();
	}
	
	public List<Employee> getAllUserByMobile(String mobile){
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Property.forName("empstatus").eq(new Long(Role.INCUMBENCY)));
		criteria.add(Restrictions.or(Property.forName("officetel").eq(mobile), Property.forName("telephone").eq(mobile)));		
		return (List<Employee>)criteria.list();
	}
	
	/**
	 * 根据用户Id查询用户
	 * @param id 人员Id
	 * @return
	 */
	public Employee getById(String id){
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Property.forName("employeeid").eq(id));
		return (Employee)criteria.uniqueResult();
	}

}
