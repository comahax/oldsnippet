package com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.dao.RewardBusinessDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.service.RewardBusinessService;
import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.RewardBusiness;
import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.RewardBusinessQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.RewardBusinessQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class RewardBusinessServiceImpl extends BaseServiceImpl implements  RewardBusinessService {

	private RewardBusinessDao rewardBusinessDao;
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public  RewardBusinessServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDBUSINESS;
		this.serviceName = "业务办理酬金分期表";
		this.isNeedLogin = true;
		this.setProcessor(new RewardBusinessQueryParamProcessor());//如果有不同的查询器，需要在query方法中动态set，一个的话可以在这里写死
		
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL); 
		RewardBusinessQueryParameter param = (RewardBusinessQueryParameter) parameter; 
		List<RewardBusiness> retlist = new ArrayList<RewardBusiness>(); 
		
//		List busistat = this.rewardTdFailDao.getrewardTdfail(param);
		
		//查询条件处理器
		this.setProcessor(new RewardBusinessQueryParamProcessor());
		QueryResult queryResult = this.rewardBusinessDao.getAllSQL(this.getProcessor(),parameter);
		if(queryResult.getData().size() != 0){
		
		
		//对查询出的数据进行封装，将封装后的数据作为返回数
		List busistat = queryResult.getData();
		
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			RewardBusiness info = new RewardBusiness();   
			if(obje[0] != null){
				info.setOprmon((String)obje[0].toString()); 
			}else{
				info.setOprmon(""); 
			}
			if(obje[1] != null){
				int custtype = Integer.parseInt(obje[1].toString());
				if(custtype == 0){
					info.setCusttype("入网3个月以内客户");
				}else{
					info.setCusttype("入网3个月以上客户");
				}
			}else{
				info.setCusttype("");
			}
			if(obje[2] != null){
				info.setRwtypename((String)obje[2].toString());
			}else{
				info.setRwtypename("");
			}
			if(obje[3] != null){
				info.setChkitemname((String)obje[3]);
			}else{
				info.setChkitemname("");
			}
			if(obje[4] != null){
				info.setRwhlvl((String)obje[4]);
			}else{
				info.setRwhlvl(""); 
			}
			if(obje[5] != null){
				info.setBusicnt((String)obje[5].toString()); 
			}else{
				info.setBusicnt(""); 
			}
			if(obje[6] != null){
				info.setMaxrwmoney((String)obje[5].toString()); 
			}else{
				info.setBusicnt(""); 
			}
			//=============================1
			if(obje[7] != null){
				info.setTrwstd1((String)obje[7].toString()); 
			}else{
				info.setTrwstd1(""); 
			}
			if(obje[8] != null){
				info.setTrwmoney1((String)obje[8].toString()); 
			}else{
				info.setTrwmoney1(""); 
			}
			
			//=============================2
			if(obje[9] != null){
				info.setTrwstd2((String)obje[9].toString()); 
			}else{
				info.setTrwstd2(""); 
			}
			if(obje[10] != null){
				info.setTrwmoney2((String)obje[10].toString()); 
			}else{
				info.setTrwmoney2(""); 
			}
			
			//=============================3
			if(obje[11] != null){
				info.setTrwstd3((String)obje[11].toString()); 
			}else{
				info.setTrwstd3(""); 
			}
			if(obje[12] != null){
				info.setTrwmoney3((String)obje[12].toString()); 
			}else{
				info.setTrwmoney3(""); 
			}
			//=============================4
			if(obje[13] != null){
				info.setTrwstd4((String)obje[13].toString()); 
			}else{
				info.setTrwstd4(""); 
			}
			if(obje[14] != null){
				info.setTrwmoney4((String)obje[14].toString()); 
			}else{
				info.setTrwmoney4(""); 
			}
			//=============================5
			if(obje[15] != null){
				info.setTrwstd5((String)obje[15].toString()); 
			}else{
				info.setTrwstd5(""); 
			}
			if(obje[16] != null){
				info.setTrwmoney5((String)obje[16].toString()); 
			}else{
				info.setTrwmoney5(""); 
			}
			//=============================6
			if(obje[17] != null){
				info.setTrwstd6((String)obje[17].toString()); 
			}else{
				info.setTrwstd6(""); 
			}
			if(obje[18] != null){
				info.setTrwmoney6((String)obje[18].toString()); 
			}else{
				info.setTrwmoney6(""); 
			}
			//=============================7
			if(obje[19] != null){
				info.setTrwstd7((String)obje[19].toString()); 
			}else{
				info.setTrwstd7(""); 
			}
			if(obje[20] != null){
				info.setTrwmoney7((String)obje[20].toString()); 
			}else{
				info.setTrwmoney7(""); 
			}
			
			retlist.add(info);
		} 
		
		
		//=======================================
		int oprmonCount = 0;
		int custtypeCount = 0;
		int rwtypenameCount = 0;
		int chkitemnameCount = 0;
//		RewardBusiness info = null;
		for(int i=1;i<retlist.size();i++){
			if(retlist.get(i).getOprmon().equals(retlist.get(oprmonCount).getOprmon())){
				retlist.get(i).setOprmonCount(0);
				retlist.get(oprmonCount).setOprmonCount(retlist.get(oprmonCount).getOprmonCount()+1);
				if(retlist.get(i).getCusttype().equals(retlist.get(custtypeCount).getCusttype())){
					retlist.get(i).setCusttypeCount(0);
					retlist.get(custtypeCount).setCusttypeCount(retlist.get(custtypeCount).getCusttypeCount()+1);
					if(retlist.get(i).getRwtypename().equals(retlist.get(rwtypenameCount).getRwtypename())){
						retlist.get(i).setRwtypenameCount(0);
						retlist.get(rwtypenameCount).setRwtypenameCount(retlist.get(rwtypenameCount).getRwtypenameCount()+1);
						
						if(retlist.get(i).getChkitemname().equals(retlist.get(chkitemnameCount).getChkitemname())){
							retlist.get(i).setChkitemnameCount(0);
							retlist.get(chkitemnameCount).setChkitemnameCount(retlist.get(chkitemnameCount).getChkitemnameCount()+1);
						}else{
							chkitemnameCount=i;
						}
						
					}else{
						rwtypenameCount=i;
						chkitemnameCount=i;
					}
				}else{
					custtypeCount=i;
					rwtypenameCount=i;
					chkitemnameCount=i;
				}
			}else{
				oprmonCount=i;
				custtypeCount=i;
				rwtypenameCount=i;
				chkitemnameCount=i;
			}
		}
		retlist.get(oprmonCount).setOprmonCount(retlist.get(oprmonCount).getOprmonCount()+1);
		//---------------------------------------
		
		}
		ret.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(null,retlist)); 
		return ret;
	}

	public List getBusistat(String wayid,String oprmon){
		return rewardBusinessDao.getBusistat(wayid, oprmon);
	}

	public RewardBusinessDao getRewardBusinessDao() {
		return rewardBusinessDao;
	}

	public void setRewardBusinessDao(RewardBusinessDao rewardBusinessDao) {
		this.rewardBusinessDao = rewardBusinessDao;
	}
	
	
	
}
