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
		//设置业务相关属性
		serviceName = "商品订购公共参数查询";
		serviceCode = ServiceCode.COMMON;
		isNeedLogin = true;
	}
	
	public String getIsQuery(LoginMember member) {
		// TODO Auto-generated method stub
		String propertyNames[] = {"id.systemid","id.paramtype"};
		Object values[] = {new Long(15),"pboss_fx"};
		IbGlSysparam obj =(IbGlSysparam) this.getDao().getOne(propertyNames, values);
		if (obj == null) {
			Log.remoteLog(serviceCode, serviceName, "getIsQuery", member.getWayid(), -1, "所在地市："+ member.getCityid());
			return null;
		}
//		System.out.println(obj.getParamvalue());
		
		return obj.getParamvalue();
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
		IbGlSysparam obj = (IbGlSysparam)this.getDao().getOne(propertyNames, values);
		if(obj==null){
			return null;
		}
		return obj.getParamvalue();
	}
	
}
