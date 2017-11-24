package com.gmcc.pboss.biz.info.reward.cityrecord.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.reward.cityrecord.dao.CityrecordDao;
import com.gmcc.pboss.biz.info.reward.cityrecord.service.CityrecordRetCode;
import com.gmcc.pboss.biz.info.reward.cityrecord.service.CityrecordService;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.CityrecordInfo;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.CityrecordQueryParamProcessor;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.CityrecordQueryParameter;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.OpnbusiInfo;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.biz.info.node.model.Way;

public class CityrecordServiceImpl extends BaseServiceImpl implements
		CityrecordService {
	private static Map<String,String> OPNMAP = new HashMap<String,String>();//一二级业务编码及其名称
	public static final Long SYS_ID_PAYMONTH = 95L;
	public static final String SYS_TYPE_PAYMONTH = "channel";
	
	private IbGlSysparamDao ibGlSysparamDao;
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public CityrecordServiceImpl() {
		super();
		this.serviceCode = ServiceCode.CITYRECORD_STAT;
		this.serviceName = "酬金结果汇总";
		this.isNeedLogin = true;
		this.setProcessor(new CityrecordQueryParamProcessor());
	}

	private CityrecordDao cityrecordDao;

	public void setCityrecordDao(CityrecordDao cityrecordDao) {
		this.cityrecordDao = cityrecordDao;
	}
	
	public boolean isSupportPaymonth(){
		String value = ibGlSysparamDao.getSysValue(SYS_ID_PAYMONTH, SYS_TYPE_PAYMONTH);
		if(value!=null && "1".equals(value)){
			return true;
		}
		return false;
	}

	public ServiceResult other(LoginMember member, QueryParameter parameter){
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL);

		CityrecordQueryParameter param = (CityrecordQueryParameter) parameter;
		Way way = null;
		if(member.getIsnet()==4){//登录人员为经理
			way = this.cityrecordDao.getWayInfo(param.getWayid(), member.getEmployeeid());
			if(way!=null){
				way.setStrStarlevel(Constant.getConstantName(ConstantsType.STARLEVEL, way.getStarlevel().toString()));
			}else{
				ret.setRetCode(CityrecordRetCode.NOT_VALID_WAY);
				return ret;
			}			
		}
		
		List<OpnbusiInfo> retlist = new ArrayList<OpnbusiInfo>();
		double paytotal = 0.0;
		//List busistat = this.cityrecordDao.getBusistat(param.getWayid(), param.getMonth());
		List busistat = this.cityrecordDao.getBusistat(param);
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			OpnbusiInfo info = new OpnbusiInfo();
			info.setOpnid1((String) obje[0]);
			//info.setOpn1name(OPNMAP.get((String) obje[0]));
			info.setOpn1name(this.getOpnname((String)obje[0]));
			info.setOpn1count(1);
			info.setOpnid2((String) obje[1]);
			//info.setOpn2name(OPNMAP.get((String) obje[1]));
			info.setOpn2name(this.getOpnname((String) obje[1]));
			info.setOpn2count(1);
			info.setRewardtype((String) obje[2]);
			String rewardtypename = (String) obje[3];
			if ("1".equals(rewardtypename)) {
				info.setRewardname("一期");
			} else if ("2".equals(rewardtypename)) {
				info.setRewardname("二期");
			} else {// 3
				info.setRewardname("三期");
			}
			info.setRewardcount(1);
			info.setOprmonth((String) obje[4]);
			if (obje[5] != null) {
				info.setBusitotal(((BigDecimal) obje[5]).doubleValue());// Double.parseDouble((String)obje[3])
			} else {
				info.setBusitotal(0.0);
			}
			if (obje[6] != null) {
				info.setPaytotal(((BigDecimal) obje[6]).doubleValue());// Double.parseDouble((String)obje[4])
			} else {
				info.setPaytotal(0.0);
			}
			paytotal = paytotal + info.getPaytotal();
			retlist.add(info);
		}			

		int preopn1=0;
		int preopn2=0;
		int pretype=0;
		for(int i=1;i<retlist.size();i++){
			if(retlist.get(i).getOpnid1().equals(retlist.get(preopn1).getOpnid1())){
				retlist.get(i).setOpn1count(0);
				retlist.get(preopn1).setOpn1count(retlist.get(preopn1).getOpn1count()+1);
				if(retlist.get(i).getOpnid2().equals(retlist.get(preopn2).getOpnid2())){
					retlist.get(i).setOpn2count(0);
					retlist.get(preopn2).setOpn2count(retlist.get(preopn2).getOpn2count()+1);
					if(retlist.get(i).getRewardtype().equals(retlist.get(pretype).getRewardtype())){
						retlist.get(i).setRewardcount(0);
						retlist.get(pretype).setRewardcount(retlist.get(pretype).getRewardcount()+1);
					}else{
						pretype=i;
					}
				}else{
					preopn2=i;
					pretype=i;
				}
			}else{
				preopn1=i;
				preopn2=i;
				pretype=i;
			}
		}

		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(null,retlist));
		ret.setRetObject(new Object[]{paytotal,way});

		return ret;
	}
	
	public ServiceResult query(LoginMember member, QueryParameter parameter) {	
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);//使用通用业务员编码，对于子业务，可以继承ServiceRetCode定义不用的业务编码（在getAll方法中实现）

		QueryResult queryResult = this.cityrecordDao.getAllSQL(this.getProcessor(), parameter);
		//对查询出的数据进行封装，将封装后的数据作为返回数
		List data = queryResult.getData();
		List reversed = new ArrayList<CityrecordInfo>();
		for(int i=0;i<data.size();i++){
			Object[] obj = (Object[])data.get(i);
			CityrecordInfo info = new CityrecordInfo();
			info.setWayid((String)obj[0]);
			info.setWayname((String)obj[1]);
			info.setOpnid((String)obj[2]);
			info.setOpnname((String)obj[3]);
			if(obj[4]!=null){
				info.setRewardtype(((BigDecimal)obj[4]).shortValue());
				String rewardtypename = (String)obj[5];
				if("1".equals(rewardtypename)){
					info.setRewardtypename("一期");
				}else if("2".equals(rewardtypename)){
					info.setRewardtypename("二期");
				}else{//3
					info.setRewardtypename("三期");
				}
			}
			info.setMobile((String)obj[6]);
			info.setRewardmonth((String)obj[7]);
			info.setOprtime((String)obj[8]);
			if(obj[9]!=null){
				info.setBusivalue(((BigDecimal)obj[9]).doubleValue());
			}else{
				info.setBusivalue(0.0);
			}
			if(obj[10]!=null){
				info.setPaymoney(((BigDecimal)obj[10]).doubleValue());
			}else{
				info.setPaymoney(0.0);
			}			
			reversed.add(info);
		}
		queryResult = new QueryResult(queryResult.getPage(),reversed);		
		result.setRetResult(queryResult);

		result.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}
	
	//填充一二级业务编码及其名称
	private void fillOpnmap(){
		if(this.cityrecordDao==null){
			return;
		}
		List opnlevel2 = this.cityrecordDao.getOpnlevel2();
		for (Iterator it = opnlevel2.iterator(); it.hasNext();) {
			Object[] obj = (Object[])it.next();
			OPNMAP.put((String)obj[0], (String)obj[1]);
			OPNMAP.put((String)obj[2], (String)obj[3]);
		}
	}
	//根据一二级业务编码获取名称
	private String getOpnname(String opnid){
		if(OPNMAP.size()==0){
			this.fillOpnmap();
		}
		String opnname = OPNMAP.get(opnid);
		if(opnname==null){
			return opnid;
		}
		return opnname;
	}

	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}
}

