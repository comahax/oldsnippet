package com.gmcc.pboss.biz.info.registernewcnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.registernewcnt.dao.RegisternewDao;
import com.gmcc.pboss.biz.info.registernewcnt.service.RegisternewService;
import com.gmcc.pboss.biz.info.registernewcnt.support.RegisternewQueryParamProcessor;
import com.gmcc.pboss.biz.info.registernewcnt.support.Registernewcnt;
import com.gmcc.pboss.biz.info.salesDetail.model.RegisternewDetail;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

/**
 * ��ҵ��������ϸCH_PW_REGISTERNEW
 * @author Administrator
 *
 */
public class RegisternewServiceImpl extends BaseServiceImpl
		implements RegisternewService {

	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public RegisternewServiceImpl(){
		super();
		this.serviceCode = ServiceCode.REGISTERNEW_TOTAL;
		this.serviceName = "��ҵ��������ϸ��ѯ";
		isNeedLogin = true;// ��Ҫ��¼
		//this.setProcessor(new RegisternewQueryParamProcessor());
	}
	
	private RegisternewDao registernewDao;
	public void setRegisternewDao(RegisternewDao registernewDao){
		this.registernewDao = registernewDao;
	}
	public RegisternewDao getRegisternewDao(){
		return this.registernewDao;
	}
	
	/**
	 * ��ѯ-��ҵ����Ϣ��ϸ��Ϣ��HQL������Ӳ�ѯ
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new RegisternewQueryParamProcessor());
		QueryResult queryResult = this.registernewDao.getAll(this.getProcessor(),parameter);

		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List reversed = new ArrayList<RegisternewDetail>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			RegisternewDetail temp = new RegisternewDetail(
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
					(String)obj[10]);
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
