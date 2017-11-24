package com.gmcc.pboss.biz.info.reward.adjustment.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.reward.adjustment.dao.AdjustmentDao;
import com.gmcc.pboss.biz.info.reward.adjustment.service.AdjustmentRetCode;
import com.gmcc.pboss.biz.info.reward.adjustment.service.AdjustmentService;
import com.gmcc.pboss.biz.info.reward.adjustment.support.AdjustInfo;
import com.gmcc.pboss.biz.info.reward.adjustment.support.AdjustmentQueryParamProcessor;
import com.gmcc.pboss.biz.info.reward.adjustment.support.AdjustmentQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class AdjustmentServiceImpl  extends BaseServiceImpl implements  AdjustmentService{
	
	public static final Long SYS_ID_PAYMONTH = 95L;
	public static final String SYS_TYPE_PAYMONTH = "channel";
	public static final Long SYS_ID_FEE = 91L;
	private IbGlSysparamDao ibGlSysparamDao;
	private AdjustmentDao adjustmentDao;
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public AdjustmentServiceImpl() {
		super();
		this.serviceCode = ServiceCode.ADJUMENT_STAT;
		this.serviceName = "税后酬金查询";
		this.isNeedLogin = true;
		//this.setProcessor(new AdjustmentQueryParamProcessor());
		
	}

	public boolean isSupportPaymonth(){
		String value = ibGlSysparamDao.getSysValue(SYS_ID_PAYMONTH, SYS_TYPE_PAYMONTH);
		if(value!=null && "1".equals(value)){
			return true;
		}
		return false;
	} 
	
	
	
	public boolean isSupportFee(){
		String value = ibGlSysparamDao.getSysValue(SYS_ID_FEE, SYS_TYPE_PAYMONTH);
		if(value!=null && "1".equals(value)){
			return true;
		}
		return false;
	} 
	


	public AdjustmentDao getAdjustmentDao() {
		return adjustmentDao;
	}

	public void setAdjustmentDao(AdjustmentDao adjustmentDao) {
		this.adjustmentDao = adjustmentDao;
	}

	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL);

		AdjustmentQueryParameter param = (AdjustmentQueryParameter) parameter;
		Way way = null;
		if(member.getIsnet()==4 && param.getWayid()!=null && !"".equals(param.getWayid().trim())){//登录人员为经理
			way = this.adjustmentDao.getWayInfo(param.getWayid(), member.getEmployeeid());
			if (way==null){
				ret.setRetCode(AdjustmentRetCode.NOT_VALID_WAY);
				return ret;
			} 
		} 
		List<AdjustInfo> retlist = new ArrayList<AdjustInfo>(); 
		
		//查询条件处理器
		this.setProcessor(new AdjustmentQueryParamProcessor());
		QueryResult queryResult = this.adjustmentDao.getAllSQL(this.getProcessor(),parameter);
		
		
		List busistat = queryResult.getData();
		for (Iterator ite = busistat.iterator(); ite.hasNext();) {
			Object obje[] = (Object[]) ite.next();
			AdjustInfo info = new AdjustInfo();
			info.setWayid((String) obje[0]);
			info.setWayname((String)obje[1]);
			info.setStarlevel(obje[2].toString());
			info.setRewardmonth(obje[3].toString());
			info.setPaymonth((String)obje[4]);
			info.setPaysum((new BigDecimal(obje[5].toString())).doubleValue());
			info.setRpmoney((new BigDecimal(obje[6].toString())).doubleValue());
		    info.setFees((new BigDecimal(obje[7].toString())).doubleValue());
		    info.setTaxmoney((new BigDecimal(obje[8].toString())).doubleValue());
		    info.setRealpay((new BigDecimal(obje[9].toString())).doubleValue()); 
			retlist.add(info);
		} 
		queryResult = new QueryResult(queryResult.getPage(),retlist);
		ret.setRetObject(null);//对于getAll,只返回QueryResult,没有必要加上RetObject
		ret.setSuccess(true);
		ret.setRetCode(ServiceRetCode.SUCCESS);
		ret.setRetResult(new QueryResult(queryResult.getPage(),retlist)); 
		return ret;
		
	}
	
	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}
}
