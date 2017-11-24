package com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.dao.UnvrcfaildayDao;
import com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.service.UnvrcfaildayService;
import com.gmcc.pboss.biz.info.missioner.recommend.unvrcfailday.support.UnvrcfaildayParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class UnvrcfaildayServiceImpl extends BaseServiceImpl implements
		UnvrcfaildayService {
	public UnvrcfaildayServiceImpl(){
		super();
		this.isNeedLogin=true;
		this.serviceCode=ServiceCode.MIS_UNVRCFAILDAY_QUERY;
		this.serviceName="创新联盟数据业务推荐失败明细查询";
		this.setProcessor(new UnvrcfaildayParamProcessor());
	}
	
	private UnvrcfaildayDao unvrcfaildayDao;	
	public void setUnvrcfaildayDao(UnvrcfaildayDao unvrcfaildayDao) {
		this.unvrcfaildayDao = unvrcfaildayDao;
	}

	public ServiceResult query(LoginMember member, QueryParameter parameter){
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		QueryResult queryResult = this.unvrcfaildayDao.getAllSQL(getProcessor(), parameter);
		//对查询出的数据进行封装，将封装后的数据作为返回数
		List data = queryResult.getData();
		List reversed = new ArrayList<UnvrcfaildayInfo>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			UnvrcfaildayInfo info = new UnvrcfaildayInfo();
//			u.failid,u.rcno,u.mobileno,u.opnid,o.name as opnname,u.rcmonth,u.rcdate
//			u.reason,u.ossrc,u.wayid,w.wayname,e.empattr2 
			info.setFailid(((BigDecimal)obj[0]).longValue());
			info.setRcno((String)obj[1]);
			info.setMobileno((String)obj[2]);
			info.setOpnid((String)obj[3]);
			info.setOpnname((String)obj[4]);
			info.setRcmonth((String)obj[5]);
			info.setRcdate((String)obj[6]);
			info.setReason((String)obj[7]);
			if(obj[8]!=null){
				String s = Constant.getConstantName(ConstantsType.CH_UNPB_OSSRC, ((BigDecimal)obj[8]).toString());
				info.setOssrc(s);
			}
			info.setWayid((String)obj[9]);
			info.setWayname((String)obj[10]);
			if(obj[11]!=null){
				String s = Constant.getConstantName(ConstantsType.CH_EMPATTR2, ((BigDecimal)obj[11]).toString());
				info.setEmpattr2(s);
			}			
			reversed.add(i,info);
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);		
		result.setRetResult(queryResult);
		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}

}
