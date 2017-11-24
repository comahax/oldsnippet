package com.gmcc.pboss.biz.info.rewardtd.salemonth.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.salemonth.dao.SaleMonthDao;
import com.gmcc.pboss.biz.info.rewardtd.salemonth.service.SaleMonthService;
import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonth;
import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonthQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonthQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class SaleMonthServiceImpl extends BaseServiceImpl implements  SaleMonthService {

	private SaleMonthDao saleMonthDao;
	
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public  SaleMonthServiceImpl() {
		super();
		this.serviceCode = ServiceCode.SALEMONTH;
		this.serviceName = "ҵ����ϸ����������ά�ȣ�";
		this.isNeedLogin = true;
		this.setProcessor(new SaleMonthQueryParamProcessor());//����в�ͬ�Ĳ�ѯ������Ҫ��query�����ж�̬set��һ���Ļ�����������д��
		
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL); 
		SaleMonthQueryParameter param = (SaleMonthQueryParameter) parameter; 
		List<SaleMonth> retlist = new ArrayList<SaleMonth>(); 
		
//		List busistat = this.rewardTdFailDao.getrewardTdfail(param);
		
		//��ѯ����������
		this.setProcessor(new SaleMonthQueryParamProcessor());
		QueryResult queryResult = this.saleMonthDao.getAllSQL(this.getProcessor(),parameter);
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List busistat = queryResult.getData();
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			SaleMonth info = new SaleMonth(); 
			if(obje[0] != null){
				info.setOprmon((String)obje[0].toString()); 
			}else{
				info.setOprmon(""); 
			}
			if(obje[1] != null){
				info.setImei((String)obje[1].toString());
			}else{
				info.setImei("");
			}
			if(obje[2] != null){
				info.setComname((String)obje[2].toString());
			}else{
				info.setComname("");
			}
			if(obje[3] != null){
				info.setMainno((String)obje[3]);
			}else{
				info.setMainno("");
			}
			if(obje[4] != null){
				info.setRwtypename((String)obje[4].toString()); 
			}else{
				info.setRwtypename(""); 
			}
			if(obje[5] != null){
				info.setTmoney1((String)obje[5].toString()); 
			}else{
				info.setTmoney1(""); 
			}
			if(obje[6] != null){
				info.setTmoney2((String)obje[6].toString()); 
			}else{
				info.setTmoney2(""); 
			}
			if(obje[7] != null){
				info.setTmoney3((String)obje[7].toString()); 
			}else{
				info.setTmoney3(""); 
			}
			if(obje[8] != null){
				info.setTmoney4((String)obje[8].toString()); 
			}else{
				info.setTmoney4(""); 
			}
			if(obje[9] != null){
				info.setTmoney5((String)obje[9].toString()); 
			}else{
				info.setTmoney5(""); 
			}
			if(obje[10] != null){
				info.setTmoney6((String)obje[10].toString()); 
			}else{
				info.setTmoney6(""); 
			}
			if(obje[11] != null){
				info.setTmoney7((String)obje[11].toString()); 
			}else{
				info.setTmoney7(""); 
			}
			
			retlist.add(info);
		} 
		
		queryResult = new QueryResult(queryResult.getPage(),retlist);
		ret.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(queryResult.getPage(),retlist)); 
		return ret;
	}

	public String getMaxcount(SaleMonthQueryParameter parameter) {
		String maxcount = saleMonthDao.getMaxcount(parameter);
		return maxcount;
	}
	
	public SaleMonthDao getSaleMonthDao() {
		return saleMonthDao;
	}

	public void setSaleMonthDao(SaleMonthDao saleMonthDao) {
		this.saleMonthDao = saleMonthDao;
	}

}
