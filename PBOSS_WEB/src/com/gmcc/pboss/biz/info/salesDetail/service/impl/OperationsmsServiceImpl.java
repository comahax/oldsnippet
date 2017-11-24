package com.gmcc.pboss.biz.info.salesDetail.service.impl;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import com.gmcc.pboss.biz.info.salesDetail.service.OperationsmsService;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.biz.info.salesDetail.dao.OperationsmsDao;
import com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsms;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.biz.info.salesDetail.support.OperationsmsParamProcessor;

public class OperationsmsServiceImpl extends BaseServiceImpl implements
		OperationsmsService {

	/**
	 * ҵ��������������
	 */
	public OperationsmsServiceImpl(){
		super();
		this.serviceCode = ServiceCode.OPERATION_SMS;
		this.serviceName = "ҵ������ѯ";
		this.isNeedLogin = true;
	}
	/**
	 * ��ȡ�������ݿ��operationsmsDao
	 */
	private OperationsmsDao operationsmsDao;
	public void setOperationsmsDao(OperationsmsDao operationsmsDao){
		this.operationsmsDao = operationsmsDao;
	}
	public OperationsmsDao getOperationsmsDao(){
		return this.operationsmsDao;
	}
	
	/**
	 * ��ȡ����ҵ������б�
	 * Map<opnid,opnname>
	 */
	public Map getOpnInfo(String cityid) {
		// TODO Auto-generated method stub
		short opntype = 2;
		String smsno = "10086111";
		List opnList = this.operationsmsDao.getOpnInfo(opntype, smsno, cityid);
		Iterator iter = opnList.iterator();
		
		Map map = new HashMap<String,String>();//opnid ,opnname
		while(iter.hasNext()){
			ChPwOperationsms item = (ChPwOperationsms)iter.next();
			map.put(item.getId().getOpnid(), item.getOpnname());
		}
		//Map map = this.operationsmsDao.getOpnInfo(opntype, smsno, cityid);
		return map;
	}
	
	/**
	 * ��ȡ����ҵ������б�
	 * List<ChPwOperationsms>
	 */
	public List getOperationsms(String cityid){
		short opntype = 2;
		String smsno = "10086111";
		List opnList = this.operationsmsDao.getOpnInfo(opntype, smsno, cityid);
		return opnList;
	}
	
	/**
	 * ��ȡ����ҵ������б�--����ʹ��JSON��װ�����ڽ��������ʾ
	 */
	public ServiceResult query(LoginMember loginMember, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new OperationsmsParamProcessor());
		QueryResult queryResult = this.operationsmsDao.getAll(getProcessor(), parameter);
			
		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);	
		return result;
	}

}
