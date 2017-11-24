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
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2010-3-1
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ֻ���������ز�ѯ
 */
public class NosectServiceImpl extends BaseServiceImpl implements NosectService{
	private static Logger logger = Logger.getLogger(NosectServiceImpl.class);
	
	public NosectServiceImpl() {
		this.isNeedLogin = false; //�����¼
		this.serviceCode = ServiceCode.COMMON;
		this.serviceName = "�ֻ���������ز�ѯ";
	}
	
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		ServiceResult result = new ServiceResult();
		result.setRetCode(ServiceRetCode.FAIL);
		result.setSuccess(false);
		
		MemberQueryParameter param= (MemberQueryParameter)parameter;
		NosectDao nosectDao = (NosectDao)this.getDao();
		//ˢ��SessionFactory
		nosectDao.reloadSessionFactory();
		//������ѯ
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
