package com.gmcc.pboss.biz.info.registernewmagcnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.registernewmagcnt.dao.RegisternewmagcntDao;
import com.gmcc.pboss.biz.info.registernewmagcnt.service.RegisternewmagcntService;
import com.gmcc.pboss.biz.info.registernewmagcnt.support.RegisternewmagQueryParamProcessor;
import com.gmcc.pboss.biz.info.registernewmagcnt.support.Registernewmagcnt;
import com.gmcc.pboss.biz.info.salesDetail.model.RegistersimDetail;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RegisternewmagcntServiceImpl extends BaseServiceImpl implements RegisternewmagcntService {

	public RegisternewmagcntServiceImpl() {
		super();
		//����ҵ���������
		this.serviceName = "��ҵ�����ۻ��ܲ�ѯ";
		this.serviceCode = ServiceCode.REGISTERNEW_TOTAL;
		isNeedLogin = true;
	}
	
	private RegisternewmagcntDao registernewmagcntDao;

	public RegisternewmagcntDao getRegisternewmagcntDao() {
		return registernewmagcntDao;
	}

	public void setRegisternewmagcntDao(RegisternewmagcntDao registernewmagcntDao) {
		this.registernewmagcntDao = registernewmagcntDao;
	}
	
	/**
	 * ��ѯ-��ҵ�����ۻ�����Ϣ��HQL������Ӳ�ѯ
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new RegisternewmagQueryParamProcessor());
		QueryResult queryResult = this.registernewmagcntDao.getAll(this.getProcessor(),parameter);

		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List reversed = new ArrayList<Registernewmagcnt>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			Registernewmagcnt temp = new Registernewmagcnt(
					(String)obj[0],
					(String)obj[1],
					(String)obj[2],
					(String)obj[3],
					(String)obj[4],
					(String)obj[5]);
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
