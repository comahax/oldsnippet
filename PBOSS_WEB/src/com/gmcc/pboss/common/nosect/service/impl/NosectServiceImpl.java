package com.gmcc.pboss.common.nosect.service.impl;

//import org.apache.log4j.Logger;


import org.apache.log4j.Logger;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.nosect.dao.NosectDao;
import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.member.support.MemberQueryParameter;

/**
 * 从兴公司营账研发部
 * @author yuwenjun
 * @date 2010-3-1
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：手机号码归属地查询
 */
public class NosectServiceImpl extends BaseServiceImpl implements NosectService{
	private static Logger logger = Logger.getLogger(NosectServiceImpl.class);
	
	public NosectServiceImpl() {
		this.isNeedLogin = false; //不需登录
		this.serviceCode = ServiceCode.COMMON;
		this.serviceName = "手机号码归属地查询";
	}
	
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult();
		result.setRetCode(ServiceRetCode.FAIL);
		result.setSuccess(false);
		
		MemberQueryParameter param= (MemberQueryParameter)parameter;
		NosectDao nosectDao = (NosectDao)this.getDao();
		//刷新SessionFactory
		nosectDao.reloadSessionFactory();
		//启动查询
		String cityId = nosectDao.getCityByNo(param.getOfficeTel());
		if (cityId != null){
			result.setRetCode(ServiceRetCode.SUCCESS);
			result.setSuccess(true);
			result.setRetObject(cityId);
		}else{
			result.setRetCode(ServiceRetCode.UN_GD_MOBILE);
		}
		return result;
	}
	/**************************Getter and Setter*******************************/

}
