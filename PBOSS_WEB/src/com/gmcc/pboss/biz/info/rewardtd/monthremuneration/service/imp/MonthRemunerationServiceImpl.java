package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.dao.MonthRemunerationDao;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.service.MonthRemunerationService;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.MonthRemuneration;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.MonthRemunerationQueryParamProcessor;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.MonthRemunerationQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class MonthRemunerationServiceImpl extends BaseServiceImpl implements  MonthRemunerationService {

	private MonthRemunerationDao monthRemunerationDao;
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public  MonthRemunerationServiceImpl() {
		super();
		this.serviceCode = ServiceCode.MONTHREMUN;
		this.serviceName = "月度应发酬金报表";
		this.isNeedLogin = true;
		this.setProcessor(new MonthRemunerationQueryParamProcessor());//如果有不同的查询器，需要在query方法中动态set，一个的话可以在这里写死
		
	}
	
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL); 
		MonthRemunerationQueryParameter param = (MonthRemunerationQueryParameter) parameter; 
		List<MonthRemuneration> retlist = new ArrayList<MonthRemuneration>(); 
		
//		List busistat = this.rewardTdFailDao.getrewardTdfail(param);
		
		//查询条件处理器
		this.setProcessor(new MonthRemunerationQueryParamProcessor());
		QueryResult queryResult = this.monthRemunerationDao.getAllSQL(this.getProcessor(),parameter);
		if(queryResult.getData().size() != 0){
		//对查询出的数据进行封装，将封装后的数据作为返回数
		List busistat = queryResult.getData();
		
		
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			MonthRemuneration info = new MonthRemuneration();   
			if(obje[0] != null){
				info.setRwmon((String)obje[0].toString()); 
			}else{
				info.setRwmon(""); 
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
				int period = Integer.parseInt(obje[4].toString());
				if(period == 0){
					info.setPeriod("不分期");
				}else if (period == 1){
					info.setPeriod("首期");
				}else if (period == 2){
					info.setPeriod("二期");
				}else if (period == 3){
					info.setPeriod("三期");
				}
			}else{
				info.setPeriod(""); 
			}
			if(obje[5] != null){
				info.setRwstd((String)obje[5].toString()); 
			}else{
				info.setRwstd(""); 
			}
			//=============================7
			if(obje[6] != null){
				info.setTbusicnt7((String)obje[6].toString()); 
			}else{
				info.setTbusicnt7(""); 
			}
			if(obje[7] != null){
				info.setTpasscnt7((String)obje[7].toString()); 
			}else{
				info.setTpasscnt7(""); 
			}
			info.setTrwmoney7(null==obje[8] ||("").equals(obje[8])?0:(new BigDecimal(obje[8].toString())).doubleValue());
			
			//=============================6
			if(obje[9] != null){
				info.setTbusicnt6((String)obje[9].toString()); 
			}else{
				info.setTbusicnt6(""); 
			}
			if(obje[10] != null){
				info.setTpasscnt6((String)obje[10].toString()); 
			}else{
				info.setTpasscnt6(""); 
			}
			info.setTrwmoney6(null==obje[11] ||("").equals(obje[11])?0:(new BigDecimal(obje[11].toString())).doubleValue());

			//=============================5
			if(obje[12] != null){
				info.setTbusicnt5((String)obje[12].toString()); 
			}else{
				info.setTbusicnt5(""); 
			}
			if(obje[13] != null){
				info.setTpasscnt5((String)obje[13].toString()); 
			}else{
				info.setTpasscnt5(""); 
			}
			info.setTrwmoney5(null==obje[14] ||("").equals(obje[14])?0:(new BigDecimal(obje[14].toString())).doubleValue());
			//=============================4
			if(obje[15] != null){
				info.setTbusicnt4((String)obje[15].toString()); 
			}else{
				info.setTbusicnt4(""); 
			}
			if(obje[16] != null){
				info.setTpasscnt4((String)obje[16].toString()); 
			}else{
				info.setTpasscnt4(""); 
			}
			info.setTrwmoney4(null==obje[17] ||("").equals(obje[17])?0:(new BigDecimal(obje[17].toString())).doubleValue());

			//=============================3
			if(obje[18] != null){
				info.setTbusicnt3((String)obje[18].toString()); 
			}else{
				info.setTbusicnt3(""); 
			}
			if(obje[19] != null){
				info.setTpasscnt3((String)obje[19].toString()); 
			}else{
				info.setTpasscnt3(""); 
			}
			info.setTrwmoney3(null==obje[20] ||("").equals(obje[20])?0:(new BigDecimal(obje[20].toString())).doubleValue());

			//=============================2
			if(obje[21] != null){
				info.setTbusicnt2((String)obje[21].toString()); 
			}else{
				info.setTbusicnt2(""); 
			}
			if(obje[22] != null){
				info.setTpasscnt2((String)obje[22].toString()); 
			}else{
				info.setTpasscnt2(""); 
			}
			info.setTrwmoney2(null==obje[23] ||("").equals(obje[23])?0:(new BigDecimal(obje[23].toString())).doubleValue());

			//=============================1
			if(obje[24] != null){
				info.setTbusicnt1((String)obje[24].toString()); 
			}else{
				info.setTbusicnt1(""); 
			}
			if(obje[25] != null){
				info.setTpasscnt1((String)obje[25].toString()); 
			}else{
				info.setTpasscnt1(""); 
			}
			info.setTrwmoney1(null==obje[26] ||("").equals(obje[26])?0:(new BigDecimal(obje[26].toString())).doubleValue());

			if(obje[27] != null){
				info.setSumbusicnt((String)obje[27].toString()); 
			}else{
				info.setSumbusicnt("0"); 
			}
			
			if(obje[28] != null){
				info.setSumpasscnt((String)obje[28].toString()); 
			}else{
				info.setSumpasscnt("0"); 
			}
			info.setSumrwmoney(null==obje[29] ||("").equals(obje[29])?0:(new BigDecimal(obje[29].toString())).doubleValue());
			
			retlist.add(info);
		} 
		
		
		//=======================================
		int rwmonCount = 0;
		int custtypeCount = 0;
		int rwtypenameCount = 0;
		int chkitemnameCount = 0;
//		MonthRemuneration info = null;
		for(int i=1;i<retlist.size();i++){
			if(retlist.get(i).getRwmon().equals(retlist.get(rwmonCount).getRwmon())){
				retlist.get(i).setRwmonCount(0);
				retlist.get(rwmonCount).setRwmonCount(retlist.get(rwmonCount).getRwmonCount()+1);
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
				rwmonCount=i;
				custtypeCount=i;
				rwtypenameCount=i;
				chkitemnameCount=i;
			}
		}
		retlist.get(rwmonCount).setRwmonCount(retlist.get(rwmonCount).getRwmonCount()+3);
		//---------------------------------------
		}
		ret.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(null,retlist)); 
		return ret;
	}

	public List getBusistat(String wayid,String rwmon){
		return monthRemunerationDao.getBusistat(wayid, rwmon);
	}
	
	public List getOtherList(String wayid,String rwmon){
		return monthRemunerationDao.getOtherList(wayid, rwmon);
	}
	
	public List getCountList(String wayid,String rwmon){
		return monthRemunerationDao.getCountList(wayid, rwmon);
	}
	
	public MonthRemunerationDao getMonthRemunerationDao() {
		return monthRemunerationDao;
	}

	public void setMonthRemunerationDao(MonthRemunerationDao monthRemunerationDao) {
		this.monthRemunerationDao = monthRemunerationDao;
	}

	
}
