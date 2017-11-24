package com.gmcc.pboss.biz.basic.goods.dao.hibernate;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.constant.IbGlSysparam;

public class IbGlSysparamHibernate extends BaseDaoHibernate implements IbGlSysparamDao{
	public IbGlSysparamHibernate() {
		super(IbGlSysparam.class);
	}
	
	/**
	 * ��ȡϵͳ����
	 * @param systemid   ϵͳ����id
	 * @param paramType  ϵͳ�������ͣ������ͬ��������
	 * @return   ϵͳ����ֵ���ظ�Action
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
