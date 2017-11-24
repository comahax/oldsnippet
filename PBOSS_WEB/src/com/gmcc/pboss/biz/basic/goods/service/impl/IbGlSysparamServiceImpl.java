package com.gmcc.pboss.biz.basic.goods.service.impl;

import com.gmcc.pboss.biz.basic.goods.service.IbGlSysparamService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactInfoQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.model.constant.IbGlSysparam;

public class IbGlSysparamServiceImpl extends BaseServiceImpl implements
		IbGlSysparamService {

	public IbGlSysparamServiceImpl() {
		//����ҵ���������
		serviceName = "��Ʒ��������������ѯ";
		serviceCode = ServiceCode.COMMON;
		isNeedLogin = true;
	}
	
	public String getIsQuery(LoginMember member) {
		// TODO Auto-generated method stub
		String propertyNames[] = {"id.systemid","id.paramtype"};
		Object values[] = {new Long(15),"pboss_fx"};
		IbGlSysparam obj =(IbGlSysparam) this.getDao().getOne(propertyNames, values);
		if (obj == null) {
			Log.remoteLog(serviceCode, serviceName, "getIsQuery", member.getWayid(), -1, "���ڵ��У�"+ member.getCityid());
			return null;
		}
//		System.out.println(obj.getParamvalue());
		
		return obj.getParamvalue();
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
		IbGlSysparam obj = (IbGlSysparam)this.getDao().getOne(propertyNames, values);
		if(obj==null){
			return null;
		}
		return obj.getParamvalue();
	}
	
}
