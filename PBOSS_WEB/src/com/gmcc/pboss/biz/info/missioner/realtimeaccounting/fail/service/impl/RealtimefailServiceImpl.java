package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.dao.RealtimefailDao;
import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.service.RealtimefailService;
import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.fail.support.RealtimefailQueryParamProcessor;
import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.service.impl.RealtimesuccInfo;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RealtimefailServiceImpl extends BaseServiceImpl implements
		RealtimefailService {
	public RealtimefailServiceImpl(){
		super();
		this.isNeedLogin=true;
		this.serviceCode=ServiceCode.MIS_REALTIMEFAIL_QUERY;
		this.serviceName="酬金核算失败记录查询";
		this.setProcessor(new RealtimefailQueryParamProcessor());
	}
	
	private RealtimefailDao realtimefailDao;
	
	public ServiceResult query(LoginMember member, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）
		
		QueryResult queryResult = this.realtimefailDao.getAllSQL(getProcessor(), parameter);
		//对查询出的数据进行封装，将封装后的数据作为返回数
		List data = queryResult.getData();
		List reversed = new ArrayList<RealtimefailInfo>();
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
		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}

	public void setRealtimefailDao(RealtimefailDao realtimefailDao) {
		this.realtimefailDao = realtimefailDao;
	}

}
