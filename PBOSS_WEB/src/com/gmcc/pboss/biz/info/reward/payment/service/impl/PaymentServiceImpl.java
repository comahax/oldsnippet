package com.gmcc.pboss.biz.info.reward.payment.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.reward.adjustment.support.AdjustInfo;
import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentDao;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentQueryParameter;
import com.gmcc.pboss.biz.info.reward.payment.support.processor.PaymentQueryParamProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public class PaymentServiceImpl  extends BaseServiceImpl implements  PaymentService{
	
	private PaymentDao paymentDao;
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public PaymentServiceImpl() {
		super();
		this.serviceCode = ServiceCode.ADJUMENT_STAT;
		this.serviceName = "税后酬金查询";
		this.isNeedLogin = true;
		//this.setProcessor(new PaymentQueryParamProcessor());
		
	}

	public boolean isSupportPaymonth(){
		return false;
	} 
	
	
	
	public boolean isSupportFee(){
		
		return false;
	} 
	


	

	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		ServiceResult ret = new ServiceResult();
		ret.setSuccess(false);
		ret.setRetCode(ServiceRetCode.FAIL);

		PaymentQueryParameter param = (PaymentQueryParameter) parameter;
		Way way = null;
		
		List<AdjustInfo> retlist = new ArrayList<AdjustInfo>(); 
		
		//查询条件处理器
		this.setProcessor(new PaymentQueryParamProcessor());
		QueryResult queryResult = null;//this.adjustmentDao.getAllSQL(this.getProcessor(),parameter);
		
		
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

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

}
