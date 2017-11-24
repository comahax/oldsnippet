package com.gmcc.pboss.biz.info.missioner.recommend.success.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gmcc.pboss.biz.info.missioner.recommend.success.dao.MissionerDao;
import com.gmcc.pboss.biz.info.missioner.recommend.success.model.Missioner;
import com.gmcc.pboss.biz.info.missioner.recommend.success.service.MissionerService;
import com.gmcc.pboss.biz.info.missioner.recommend.success.support.MissionerQueryParamProcessor;
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

public class MissionerServiceImpl extends BaseServiceImpl implements MissionerService {
	public MissionerServiceImpl(){
		this.serviceCode=ServiceCode.MIS_SUCCESS_QUERY;
		this.serviceName="创新联盟数据业务推荐成功明细查询";
		this.isNeedLogin=true;
		this.setProcessor(new MissionerQueryParamProcessor());//如果有不同的查询器，需要在query方法中动态set，一个的话可以在这里写死
	}
	
	private MissionerDao rsMissionerDao;
	
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）
		
		//查询条件处理器
		this.setProcessor(new MissionerQueryParamProcessor());
		QueryResult queryResult = this.rsMissionerDao.getAllSQL(this.getProcessor(),parameter);
		
		//对查询出的数据进行封装，将封装后的数据作为返回数
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

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	
	public MissionerDao getRsMissionerDao() {
		return rsMissionerDao;
	}

	public void setRsMissionerDao(MissionerDao rsMissionerDao) {
		this.rsMissionerDao = rsMissionerDao;
	}

}
