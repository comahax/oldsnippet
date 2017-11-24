package com.gmcc.pboss.biz.basic.goods.dao.hibernate;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.constant.IbGlSysparam;

public class IbGlSysparamHibernate extends BaseDaoHibernate implements IbGlSysparamDao{
	public IbGlSysparamHibernate() {
		super(IbGlSysparam.class);
	}
	
	/**
	 * 提取系统参数
	 * @param systemid   系统参数id
	 * @param paramType  系统参数类型，此两项共同构成主键
	 * @return   系统参数值返回给Action
	 */
	public String getSysValue(long systemid, String paramType){
		String propertyNames[] = {"id.systemid", "id.paramtype"};
		Object values[] = {systemid, paramType};
		IbGlSysparam obj = (IbGlSysparam)this.getOne(propertyNames, values);
		if(obj==null){
			return null;
		}
		return obj.getParamvalue();
	}
}
