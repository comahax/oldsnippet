package com.gmcc.pboss.member.extend.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.member.extend.dao.ProvincecityadminDao;
import com.gmcc.pboss.member.extend.model.Provincecityadmin;

public class ProvincecityadminDaoHibernate extends BaseDaoHibernate implements
ProvincecityadminDao {
	
	public ProvincecityadminDaoHibernate(){
		super(Provincecityadmin.class);
	}
	/**
	 * 省市公司登陆密码验证
	 * @param mobile
	 * @return
	 */
	public Provincecityadmin getCityadminLogin(Long mobile) {
		// TODO Auto-generated method stub
		String[] propertyNames = {"mobile"};
		Object[] obj = {mobile};
		return (Provincecityadmin)this.getOne(propertyNames, obj);
	}
	
}
