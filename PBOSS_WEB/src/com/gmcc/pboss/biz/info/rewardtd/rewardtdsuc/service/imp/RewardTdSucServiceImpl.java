package com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.service.imp;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.dao.RewardTdSucDao;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.service.RewardTdSucService;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support.RewardTdSucInfo;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support.RewardTdSucQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support.RewardTdSucQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

public class RewardTdSucServiceImpl extends BaseServiceImpl implements RewardTdSucService{

private RewardTdSucDao rewardTdSucDao;
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public  RewardTdSucServiceImpl() {
		super();
		this.serviceCode = ServiceCode.REWARDTD_SUC;
		this.serviceName = "终端计酬成功明细";
		this.isNeedLogin = true;
		this.setProcessor(new RewardTdSucQueryParamProcessor());//如果有不同的查询器，需要在query方法中动态set，一个的话可以在这里写死
		
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL);

		RewardTdSucQueryParameter param = (RewardTdSucQueryParameter) parameter; 
		List<RewardTdSucInfo> retlist = new ArrayList<RewardTdSucInfo>(); 
		
		//查询条件处理器
		this.setProcessor(new RewardTdSucQueryParamProcessor());
		QueryResult queryResult = this.rewardTdSucDao.getAllSQL(this.getProcessor(),parameter);
		
		//List busistat = this.rewardTdSucDao.getrewartTdSuc(param);//gai
		//对查询出的数据进行封装，将封装后的数据作为返回数
		List busistat = queryResult.getData();
		
		//切换公共库》》comame无法访问CRM的库表翻译
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) { 
			Object obje[] = (Object[]) ite.next();
			RewardTdSucInfo info = new RewardTdSucInfo();   
			info.setName((String)obje[0]);
			if ( null !=obje[1] ){
				if("h".equals(obje[1].toString())){
					info.setRewardtype("合约终端酬金"); 
				}else{
					info.setRewardtype("裸机终端酬金"); 
				}
			}else{
				info.setRewardtype("");
			} 
			String comame = "";
			if((String)obje[2] !=null && !"".equals((String)obje[2])){
				 comame = this.rewardTdSucDao.getComnameSuc((String)obje[2]);
			if(comame == null){
				info.setComname((String)obje[2]);
			}else{
				info.setComname(comame);
			}
			}
			info.setBakinfo((String)obje[3]);
			info.setMobile((String)obje[4]);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(null!= obje[5] && !("").equals(obje[5])){
			   info.setOprtime(df.format(obje[5]));
			}
			info.setRewardmonth((String)obje[6]); 
			info.setAcctype((String)obje[7]); 
			info.setRewardstd(null==obje[8] ||("").equals(obje[8])?0:(new BigDecimal(obje[8].toString())).doubleValue());
			info.setPaysum(null==obje[9] || ("").equals(obje[9])?0:(new BigDecimal(obje[9].toString())).doubleValue()); 
			info.setAssegrade(null==obje[10] || ("").equals(obje[10]) ? 0 : (new BigDecimal(obje[10].toString())).doubleValue()); 
			info.setWrapfee(null==obje[11] || ("").equals(obje[11]) ? 0 : (new BigDecimal(obje[11].toString())).doubleValue());
			info.setAssegrade2(null==obje[12] || ("").equals(obje[12]) ? 0 :(new BigDecimal(obje[12].toString())).doubleValue()); 
			info.setRepairmonth((String)obje[13]);
			info.setNoncyc(null==obje[14] || ("").equals(obje[14]) ? 0 : Short.parseShort(obje[14].toString()));
			info.setBakinfo7((String)obje[15]);
			info.setBakinfo8((String)obje[16]);
			info.setFailreason("成功");  
			
			retlist.add(info);
		} 
		//切换回地市库
		SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
		queryResult = new QueryResult(queryResult.getPage(),retlist);

		ret.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(queryResult.getPage(),retlist)); 
		return ret;
	}

	public RewardTdSucDao getRewardTdSucDao() {
		return rewardTdSucDao;
	}

	public void setRewardTdSucDao(RewardTdSucDao rewardTdSucDao) {
		this.rewardTdSucDao = rewardTdSucDao;
	}

}
