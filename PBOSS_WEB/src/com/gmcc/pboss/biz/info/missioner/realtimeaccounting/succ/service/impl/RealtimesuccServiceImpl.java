package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.dao.RealtimesuccDao;
import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.service.RealtimesuccService;
import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.support.RealtimesuccQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RealtimesuccServiceImpl extends BaseServiceImpl implements
		RealtimesuccService {
	public RealtimesuccServiceImpl(){
		super();
		this.isNeedLogin=true;
		this.serviceCode=ServiceCode.MIS_REALTIMESUCC_QUERY;
		this.serviceName="������ɹ���¼��ѯ";
		this.setProcessor(new RealtimesuccQueryParamProcessor());
	}
	
	private RealtimesuccDao realtimesuccDao;
	
	public ServiceResult query(LoginMember member, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�
		
		QueryResult queryResult = this.realtimesuccDao.getAllSQL(getProcessor(), parameter);
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List reversed = new ArrayList<RealtimesuccInfo>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			RealtimesuccInfo info = new RealtimesuccInfo();
			//s.seq,s.oprcode,s.wayid,s.mobile,o.name,s.opnid,to_char(s.oprtime,'yyyy-MM-dd')
			info.setSeq(((BigDecimal)obj[0]).longValue());
			info.setOprcode(obj[1].toString());
			info.setWayid(obj[2].toString());
			info.setMobile(obj[3].toString());
			info.setOpnname(obj[4].toString());
			info.setOpnid(obj[5].toString());
			info.setOprtime(obj[6].toString());
			reversed.add(i,info);
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);		
		result.setRetResult(queryResult);
		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}

	public void setRealtimesuccDao(RealtimesuccDao realtimesuccDao) {
		this.realtimesuccDao = realtimesuccDao;
	}

}
