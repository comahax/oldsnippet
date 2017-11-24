package com.gmcc.pboss.biz.info.missioner.recommend.success.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gmcc.pboss.biz.info.missioner.recommend.success.dao.AgencyDao;
import com.gmcc.pboss.biz.info.missioner.recommend.success.model.Missioner;
import com.gmcc.pboss.biz.info.missioner.recommend.success.service.AgencyService;
import com.gmcc.pboss.biz.info.missioner.recommend.success.support.AgencyQueryParamProcessor;
import com.gmcc.pboss.biz.info.salesDetail.model.RegistersimDetail;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class AgencyServiceImpl extends BaseServiceImpl implements AgencyService {
	
	public AgencyServiceImpl(){
		this.serviceCode=ServiceCode.MIS_SUCCESS_QUERY;
		this.serviceName="������������ҵ���Ƽ��ɹ���ϸ��ѯ";
		this.isNeedLogin=true;
		this.setProcessor(new AgencyQueryParamProcessor());//����в�ͬ�Ĳ�ѯ������Ҫ��query�����ж�̬set��һ���Ļ�����������д��
	}
	
	private AgencyDao rsAgencyDao;
	
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//ʹ��ͨ��ҵ��Ա���룬������ҵ�񣬿��Լ̳�ServiceRetCode���岻�õ�ҵ����루��getAll������ʵ�֣�
		
		//��ѯ����������
		this.setProcessor(new AgencyQueryParamProcessor());
		QueryResult queryResult = this.rsAgencyDao.getAllSQL(this.getProcessor(),parameter);
		
		//�Բ�ѯ�������ݽ��з�װ������װ���������Ϊ������
		List data = queryResult.getData();
		List reversed = new ArrayList<RegistersimDetail>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			Missioner temp = new Missioner();
			temp.setRuleid((String)obj[1]);
			temp.setOpnid((String)obj[2]);
			temp.setName((String)obj[3]);
			temp.setCalcopnid((String)obj[4]);
			temp.setCalname((String)obj[5]);
			temp.setCalcmonth((String)obj[6]);
			temp.setWayid((String)obj[7]);
			temp.setWayname((String)obj[8]);
			if(obj[9] != null && !"".equals(obj[9])){
				temp.setOprtime((Date)obj[9]);
			}
			temp.setOprcode((String)obj[10]);
			temp.setMobile((String)obj[11]);
			if(obj[12] != null && !"".equals(obj[12])){
				temp.setBusivalue(((BigDecimal)obj[12]).doubleValue());
			}
			if(obj[13] != null && !"".equals(obj[13])){
				String str = ""+((BigDecimal)obj[13]).shortValue();
				temp.setRewardtype(Constant.getConstantName(ConstantsType.SOCIETY_REWARD_TPYPE, str));
			}
			if(obj[14] != null && !"".equals(obj[14])){
				String str=""+((BigDecimal)obj[14]).shortValue();
				temp.setOssrc(Constant.getConstantName(ConstantsType.CH_UNPB_OSSRC, str));
			}
			if(obj[15] != null && !"".equals(obj[15])){
				String str = ((BigDecimal)obj[15]).toString();
				temp.setEmpattr2(Constant.getConstantName(ConstantsType.CH_EMPATTR2, str));
			}
			temp.setSrcseq((String)obj[16]);
			
			reversed.add(i,temp);
					
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);
		
		result.setRetResult(queryResult);

		result.setRetObject(null);//����getAll,ֻ����QueryResult,û�б�Ҫ����RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}

	public AgencyDao getRsAgencyDao() {
		return rsAgencyDao;
	}

	public void setRsAgencyDao(AgencyDao rsAgencyDao) {
		this.rsAgencyDao = rsAgencyDao;
	}

}
