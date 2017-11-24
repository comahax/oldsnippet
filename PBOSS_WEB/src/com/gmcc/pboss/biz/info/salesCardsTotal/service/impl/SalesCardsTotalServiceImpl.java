package com.gmcc.pboss.biz.info.salesCardsTotal.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.salesCardsTotal.support.SalesCardsTotal;
import com.gmcc.pboss.biz.info.salesCardsTotal.support.SalescardsTotalQueryParamProcessor;
import com.gmcc.pboss.biz.info.salesCardsTotal.dao.SalesCardsTotalDao;
import com.gmcc.pboss.biz.info.salesCardsTotal.service.SalesCardsTotalService;
import com.gmcc.pboss.biz.info.salesCardsTotal.support.SalesCardsTotalQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

public class SalesCardsTotalServiceImpl extends QueryBaseServiceImpl implements
		SalesCardsTotalService {

	public SalesCardsTotalServiceImpl() {
		//����ҵ���������
		serviceName = "�׿����ܲ�ѯ";
		serviceCode = ServiceCode.SALES_CARDSTOTAL;
		isNeedLogin = true;
	}
	
	private SalesCardsTotalDao salesCardsTotalDao;

	
	
	public SalesCardsTotalDao getSalesCardsTotalDao() {
		return salesCardsTotalDao;
	}



	public void setSalesCardsTotalDao(SalesCardsTotalDao salesCardsTotalDao) {
		this.salesCardsTotalDao = salesCardsTotalDao;
	}



	/**
	 * ��ѯ-�׿����ܲ�ѯ��Ϣ��HQL������Ӳ�ѯ(�����ѯ)
	 * select new Object(*)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {		
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�

		//��ѯ����������
		this.setProcessor(new SalescardsTotalQueryParamProcessor());
		QueryResult queryResult = this.salesCardsTotalDao.getAll(this.getProcessor(),parameter);

		
		List<Object[]> data=queryResult.getData();
		List<SalesCardsTotal> ret=new ArrayList<SalesCardsTotal>();
		for (Object[] obj:data){
			SalesCardsTotal salesCardsTotal = new SalesCardsTotal();
			salesCardsTotal.setWayid((String) obj[0]);
			salesCardsTotal.setWayname((String) obj[1]);
			salesCardsTotal.setCountyid((String) obj[2]);
			if(obj[3]!=null)
				salesCardsTotal.setStarlevel((String) obj[3]);
			salesCardsTotal.setTotal((String) obj[4]);
			SalesCardsTotal salesCardsTotal22 = new SalesCardsTotal(salesCardsTotal);
			ret.add(salesCardsTotal22);
		}
		
		queryResult = new QueryResult(queryResult.getPage(),ret);
		result.setRetResult(queryResult);
		
		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	
	
	
}
