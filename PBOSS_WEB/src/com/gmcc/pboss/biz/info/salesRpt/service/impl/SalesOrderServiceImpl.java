package com.gmcc.pboss.biz.info.salesRpt.service.impl;

import org.apache.log4j.Logger;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.biz.info.salesRpt.dao.OrderProceDao;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesrServiceRetCode;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.support.processor.SalesOrderParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.model.sales.FxRuOrderproce;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.service.WebSiteService;
import com.gmcc.pboss.service.result.RetResult;

public class SalesOrderServiceImpl extends QueryBaseServiceImpl implements SalesRptService {

	private OrderProceDao orderProceDao;
	private CommunicatePlateauService communicatePlateauService;

	private static Logger logger = Logger.getLogger(SalesOrderServiceImpl.class);
	/**
	 * 远程接口
	 */
	private WebSiteService httpWebRemote;
	
	public SalesOrderServiceImpl() {
		serviceName = "订单信息";
		serviceCode = ServiceCode.SALESORDER;
		isNeedLogin = true;

		setProcessor(new SalesOrderParameterProcessor());
	}

	/**
	 * 提取单条
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		
		//ID验证
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");
		
		try{
			FxSwOrder obj = (FxSwOrder) get(param.getOrderid());
			//验证用户权限
			Assert.isTrue(member.getWayid().equals(obj.getWayid()), SalesrServiceRetCode.WAY_FAIL, "ID不明确！");
			
//
//			//判断此订单是否待确认状态
//			if (!ConstantsType.ORDERSTATE_WAITCON.equals(obj.getOrderstate())){
//				//打开待办时，判断若订单判断不是"WAITCON"[待确认]的话， 待办关闭
//				if (param.getAdvId()!=null) this.closePandingTask(param.getAdvId(), member.getEmployeeid());
//			}
			
			//查询
			result.setRetObject(obj);
			
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
		}catch(ObjectRetrievalFailureException e){
			//对象不存在异常
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5，错误代表：SALESORDER_5
		}
		
		return result;
	}

	/**
	 * 确认订购业务处理方法
	 * 
	 */
	@Override
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		
		//ID验证
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");
		//提取订单
		FxSwOrder obj = (FxSwOrder) get(param.getOrderid());
		//验证用户权限
		Assert.isTrue(member.getWayid().equals(obj.getWayid()), SalesrServiceRetCode.WAY_FAIL, "订单归属渠道错误");
		
		//检查订单状态（FX_SW_ORDER.ORDERSTAT）是否等于“WAITCON”（待确认）
		if (!ConstantsType.ORDERSTATE_WAITCON.equals(obj.getOrderstate())){
			return this.rtnCheckError(result, SalesrServiceRetCode.ORDERSTAT_ERROR);
		}
		
		//按[流程编号]、[入口状态] 提取查询订单流程步骤表
		FxRuOrderproce proce = this.orderProceDao.getByFlowidInstate(obj.getFlowid(), ConstantsType.ORDERSTATE_WAITCON);
		
		//如果无数据则返回提示“订单流程错误，请联系管理员”并终止操作
		if ((proce == null)){
			return this.rtnCheckError(result, SalesrServiceRetCode.ORDERSTAT_ERROR);
		}
		
		obj.setOrderstate(proce.getOutstate());
		//将是否确认修改为1（是）
		obj.setConfirmflag(ConstantsType.Confirmflag_YES);
		
		this.getDao().update(obj);//更新到数据库
		
//		//调用【订单下一步处理】接口，不判断处理结果
//		RetResult rmtRslt = httpWebRemote.doOrderNextProc(member.getWayid(), obj.getOrderid());
//		//记录接口调用情况
//		logger.info("[商品订购-订单下一步处理]:"+ rmtRslt.getRetCode()+'('+ rmtRslt.getMessage() +')');
//		Log.remoteLog(serviceCode, serviceCode, "doOrderNextProc订单下一步处理", 
//				member.getWayid()+"["+ obj.getOrderid() +"]", rmtRslt.getRetCode(),rmtRslt.getMessage());
		
		//把对应的待办信息修改为关闭状态
		this.closePandingTask(param.getAdvId(),member.getEmployeeid());
		
		result.setRetObject(obj);
		result.setSuccess(true);
		result.setRetCode(SalesrServiceRetCode.ORDERCNFRM_SUCCESS);
		
		return result;
	}
	
	/**
	 * 远程订单下一步处理
	 */
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		//调用【订单下一步处理】接口，不判断处理结果
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		RetResult rmtRslt = httpWebRemote.doOrderNextProc(member.getWayid(), param.getOrderid());
		//记录接口调用情况
		logger.info("[商品订购-订单下一步处理]:"+ rmtRslt.getRetCode()+'('+ rmtRslt.getMessage() +')');
		Log.remoteLog(serviceCode, serviceCode, "doOrderNextProc订单下一步处理", 
				member.getWayid()+"["+ param.getOrderid() +"]", rmtRslt.getRetCode(),rmtRslt.getMessage());
		ServiceResult result = new ServiceResult();
		result.setSuccess(true);
		result.setRetCode(SalesrServiceRetCode.ORDERCNFRM_SUCCESS);
		return result;
	}

	/**
	 * 放弃订购业务处理方法
	 * */
	@Override
	public ServiceResult cancel(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub		// TODO Auto-generated method stub
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		
		//ID验证
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");
		//提取订单
		FxSwOrder obj = (FxSwOrder) get(param.getOrderid());
		//验证用户权限
		Assert.isTrue(member.getWayid().equals(obj.getWayid()), SalesrServiceRetCode.WAY_FAIL, "订单归属渠道错误");
		
		//检查订单状态（FX_SW_ORDER.ORDERSTAT）是否等于“WAITCON”（待确认）
		if (!ConstantsType.ORDERSTATE_WAITCON.equals(obj.getOrderstate())){
			return this.rtnCheckError(result, SalesrServiceRetCode.ORDERSTAT_ERROR);
		}
		
		//修改订单表中的是否确认为0（否）、订单状态为“CANCEL”（作废）、备注为“放弃订购”，同时登记订单日志表
		obj.setOrderstate(ConstantsType.ORDERSTATE_CANCEL);
		obj.setConfirmflag(ConstantsType.Confirmflag_NO);
		obj.setMemo("放弃订购");
		this.getDao().update(obj);//更新到数据库

		
		//把对应的待办信息修改为关闭状态
		this.closePandingTask(param.getAdvId(),member.getEmployeeid());
		
		result.setSuccess(true);
		result.setRetCode(SalesrServiceRetCode.ORDERCANCEL_SUCCESS);
		
		return result;
	}
	
	private void closePandingTask(Long advinfoid,String employeeid){
		if (advinfoid == null) return;
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setAdvinfoid(advinfoid);
		param.setEmployeeid(employeeid);
		communicatePlateauService.finishPendingTask(param);
	}
	/**
	 * 统一判断返回码
	 */
	private ServiceResult rtnCheckError(ServiceResult rtn,int rtnCode){
//		rtn.setMessage(message);
		rtn.setRetCode(rtnCode);
		return rtn;
	}
	/**
	 * @return the orderProceDao
	 */
	public OrderProceDao getOrderProceDao() {
		return orderProceDao;
	}

	/**
	 * @param orderProceDao the orderProceDao to set
	 */
	public void setOrderProceDao(OrderProceDao orderProceDao) {
		this.orderProceDao = orderProceDao;
	}

	/**
	 * @return the communicatePlateauService
	 */
	public CommunicatePlateauService getCommunicatePlateauService() {
		return communicatePlateauService;
	}

	/**
	 * @param communicatePlateauService the communicatePlateauService to set
	 */
	public void setCommunicatePlateauService(
			CommunicatePlateauService communicatePlateauService) {
		this.communicatePlateauService = communicatePlateauService;
	}

	/**
	 * @return the httpWebRemote
	 */
	public WebSiteService getHttpWebRemote() {
		return httpWebRemote;
	}

	/**
	 * @param httpWebRemote the httpWebRemote to set
	 */
	public void setHttpWebRemote(WebSiteService httpWebRemote) {
		this.httpWebRemote = httpWebRemote;
	}

	
	
}
