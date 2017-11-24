package com.gmcc.pboss.biz.info.registernewcnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.registernewcnt.dao.RegisternewcntDao;
import com.gmcc.pboss.biz.info.registernewcnt.service.RegisternewcntService;
import com.gmcc.pboss.biz.info.registernewcnt.support.Registernewcnt;
import com.gmcc.pboss.biz.info.registernewcnt.support.RegisternewcntQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RegisternewcntServiceImpl extends QueryBaseServiceImpl implements RegisternewcntService {

	public RegisternewcntServiceImpl() {
		//����ҵ���������
		serviceName = "��ҵ�����ۻ��ܲ�ѯ";
		serviceCode = ServiceCode.REGISTERNEW_TOTAL;
		isNeedLogin = true;
	}
	
	private RegisternewcntDao registernewcntDao;

	public RegisternewcntDao getRegisternewcntDao() {
		return registernewcntDao;
	}

	public void setRegisternewcntDao(RegisternewcntDao registernewcntDao) {
		this.registernewcntDao = registernewcntDao;
	}
	
	/**
	 * ��ѯ-��ҵ�����ۻ�����Ϣ��HQL������Ӳ�ѯ(�����ѯ)
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new RegisternewcntQueryParamProcessor());
		QueryResult queryResult = this.registernewcntDao.getAll(this.getProcessor(),parameter);

		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List reversed = new ArrayList<Registernewcnt>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			Registernewcnt temp = new Registernewcnt(
					(String)obj[0],
					(String)obj[1],
					(String)obj[2],
					(String)obj[3],
					(String)obj[4]);
			reversed.add(i,temp);
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);
		
		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
}
