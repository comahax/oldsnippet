package com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.salesDetail.dao.RegistersimDao;
import com.gmcc.pboss.biz.info.salesDetail.model.RegistersimDetail;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.service.MagRegistersimService;
import com.gmcc.pboss.biz.info.lowsalesCardsTotal.support.MagRegistersimQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class MagRegistersimServiceImpl extends BaseServiceImpl implements
		MagRegistersimService {
	
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public MagRegistersimServiceImpl(){
		super();
		this.serviceCode = ServiceCode.REGISTER_SIM_QUERY;
		this.serviceName = "�׿�������ϸ��ѯ-�ӻ��ܽ������";
		isNeedLogin = true;// ��Ҫ��¼
		//this.setProcessor(new MagRegistersimQueryParamProcessor());
	}
	
	/**
	 * �׿�������ϸ��ѯdao
	 */
	private RegistersimDao registersimDao;
	public void setRegistersimDao(RegistersimDao registersimDao){
		this.registersimDao = registersimDao;
	}
	public RegistersimDao getRegistersimDao(){
		return this.registersimDao;
	}
	
	/**
	 * ��ѯ-�׿���Ϣ��ϸ��Ϣ��HQL������Ӳ�ѯ
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new MagRegistersimQueryParamProcessor());
		QueryResult queryResult = this.registersimDao.getAllSQL(this.getProcessor(),parameter);

		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List reversed = new ArrayList<RegistersimDetail>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			RegistersimDetail temp = new RegistersimDetail(
					(String)obj[0],
					(String)obj[1],
					(String)obj[2],
					(String)obj[3],
					(String)obj[4],
					(String)obj[5],
					(String)obj[6],
					(String)obj[7],
					(String)obj[8],
					(String)obj[9],
					(String)obj[10],
					(String)obj[11],
					(String)obj[12],
					(String)obj[13],
					(String)obj[14]);
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
