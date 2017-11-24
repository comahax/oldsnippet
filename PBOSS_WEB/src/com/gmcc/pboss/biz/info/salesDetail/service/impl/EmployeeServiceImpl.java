package com.gmcc.pboss.biz.info.salesDetail.service.impl;

import com.gmcc.pboss.biz.info.salesDetail.service.EmployeeService;
import com.gmcc.pboss.biz.info.salesDetail.support.EmployeeQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.member.dao.IMemberDao;
/**
 * ������ϸ��ѯ��ʹ�ã���ѯ�����������ɵ������б����û�ѡ��
 */
public class EmployeeServiceImpl extends BaseServiceImpl implements
		EmployeeService {
	/**
	 * ҵ��������������
	 */
	public EmployeeServiceImpl(){
		super();
		this.serviceCode = ServiceCode.EMPLOYEE_FOE_SELECT;
		this.serviceName = "��Ա��Ϣչʾ-������չʾ��ѡ��";
		this.isNeedLogin = true;
	}
	
	/**
	 * ��ȡ�������ݿ��employeeDao
	 */
	private IMemberDao employeeDao;
	public void setEmployeeDao(IMemberDao employeeDao){
		this.employeeDao = employeeDao;
	}
	public IMemberDao getEmployeeDao(){
		return this.employeeDao;
	}
	
	/**
	 * ��Ա�����б�--����ʹ��JSON��װ�����ڽ��������ʾ
	 */
	public ServiceResult query(LoginMember loginMember, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new EmployeeQueryParamProcessor());
		QueryResult queryResult = this.employeeDao.getAll(getProcessor(), parameter);
			
		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);	
		return result;
	}
}
