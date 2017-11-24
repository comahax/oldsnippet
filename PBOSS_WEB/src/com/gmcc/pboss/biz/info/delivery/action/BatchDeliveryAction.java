package com.gmcc.pboss.biz.info.delivery.action;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.biz.info.delivery.support.BatchDeliveryParameter;
import com.gmcc.pboss.biz.info.delivery.support.BatchProcessResult;
import com.gmcc.pboss.biz.info.delivery.service.BatchDeliveryService;

public class BatchDeliveryAction extends AbstractAction {
	
	//处理结果
	private List<BatchProcessResult> processResults = new ArrayList<BatchProcessResult>();

	private BatchDeliveryParameter parameter;
	private BatchDeliveryService service;

	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new BatchDeliveryParameter() : parameter;
		return parameter;
	}
	public void setParameter(BatchDeliveryParameter parameter) {
		this.parameter = parameter;
	}


	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 批量完成配送
	 * @return
	 */
	public String toDisoverView(){
		this.setTitle(PageLoction.BatchDisover);
		
		return SUCCESS;
	}	
	public String doDisover(){
		this.setTitle(PageLoction.BatchDisover);
		ServiceResult result = null;
		LoginMember member = getMember();
		String content = this.parameter.getContent();
		if(content==null || "".equals(content.trim())){//输入为空，直接返回
			return SUCCESS;
		}
		
		QueryParameter parm = getParameter();		
		try{
			result = service.transactionProcessing(member, parm, ServiceType.MODIFY);
		}catch(Exception e){
			e.printStackTrace();
			result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			this.addActionMessage("业务处理发生系统内部错误！");//e.getMessage()
		}
		if(result.isSuccess()){
			processResults = (List<BatchProcessResult>)result.getRetObject();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 批量补发签收短信
	 * @return
	 */
	public String toSMSSignView(){
		this.setTitle(PageLoction.BatchSMSSign);
		
		return SUCCESS;
	}
	public String doSMSSign(){
		this.setTitle(PageLoction.BatchSMSSign);
		ServiceResult result = null;
		LoginMember member = getMember();
		String content = this.parameter.getContent();
		if(content==null || "".equals(content.trim())){//输入为空，直接返回
			return SUCCESS;
		}
		
		QueryParameter parm = getParameter();
		try{
			result = service.transactionProcessing(member, parm, ServiceType.MODIFY);
		}catch(Exception e){
			e.printStackTrace();
			result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			this.addActionMessage("业务处理发生系统内部错误！");//e.getMessage()
		}
		if(result.isSuccess()){
			processResults = (List<BatchProcessResult>)result.getRetObject();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 物流单号批量录入
	 * @return
	 */
	public String toBatchLogiView(){
		this.setTitle(PageLoction.BatchLogi);
		
		return SUCCESS;
	}
	public String doBatchLogiMod(){
		this.setTitle(PageLoction.BatchLogi);
		ServiceResult result = null;
		LoginMember member = getMember();
		String content = this.parameter.getContent();
		if(content==null || "".equals(content.trim())){//输入为空，直接返回
			return SUCCESS;
		}
		
		QueryParameter parm = getParameter();
		try{
			result = service.transactionProcessing(member, parm, ServiceType.MODIFY);
		}catch(Exception e){
			e.printStackTrace();
			result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			this.addActionMessage("业务处理发生系统内部错误！");//e.getMessage()
		}
		if(result.isSuccess()){
			processResults = (List<BatchProcessResult>)result.getRetObject();
		}
		
		return SUCCESS;
	}
	
	public List<BatchProcessResult> getProcessResults() {
		return processResults;
	}

	public void setService(BatchDeliveryService service) {
		this.service = service;
	}

}
