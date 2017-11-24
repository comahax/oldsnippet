package com.gmcc.pboss.biz.basic.node.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.gmcc.pboss.biz.basic.node.service.WayApplyService;
import com.gmcc.pboss.biz.basic.node.support.WayApplyQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;

public class WayApplyAction extends AbstractAction implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7534454368177530995L;

	private WayApplyService service;

	private WayApplyQueryParameter apply;

	private String vaildateCode;

	private Map session;

	/**
	 * 返回信息
	 * 
	 * @return
	 */
	private ServiceResult serviceRslt;

	public WayApplyService getService() {
		return service;
	}

	public void setService(WayApplyService service) {
		this.service = service;
	}

	public String getVaildateCode() {
		return vaildateCode;
	}

	public void setVaildateCode(String vaildateCode) {
		this.vaildateCode = vaildateCode;
	}

	public String doSave() {
		try{
			serviceRslt = service.transactionProcessing(null, getApply(), ServiceType.INITIATE);
		}
		catch(TransactionProcessionException e){
			//记录异常信息
			serviceRslt = new ServiceResult();
			serviceRslt.setSuccess(false);
			serviceRslt.setRetCode(ServiceRetCode.EXCEPTION);
			serviceRslt.setMessage(ConfigUtil.getMessage(ServiceCode.WAYAPPLY, ServiceRetCode.EXCEPTION));
			
			this.setMessage(serviceRslt.getMessage());
			logger.error("WayApplyAction:"+e.getMessage());//输出到用户
			return INPUT;
		}
		this.setMessage(serviceRslt.getMessage());

		if (serviceRslt.isSuccess()) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public void validate() {
		if (StringUtils.isBlank(vaildateCode) || !vaildateCode.equalsIgnoreCase(getVaildateCodeBySession())) {
			addFieldError("vaildateCode", "验证码输入有误！");
		}
	}

	public void setSession(Map session) {
		this.session = session;
	}

	private String getVaildateCodeBySession() {
		return (String) session.remove(HttpDictionary.ICODE_NAME);
	}

	public void prepare() throws Exception {

	}

	/**
	 * @return the serviceRslt
	 */
	public ServiceResult getServiceRslt() {
		return serviceRslt;
	}

	/**
	 * @param serviceRslt
	 *            the serviceRslt to set
	 */
	public void setServiceRslt(ServiceResult serviceRslt) {
		this.serviceRslt = serviceRslt;
	}

	/**
	 * @return the apply
	 */
	public WayApplyQueryParameter getApply() {
		return apply;
	}

	/**
	 * @param apply
	 *            the apply to set
	 */
	public void setApply(WayApplyQueryParameter apply) {
		this.apply = apply;
	}

	public String getBackURL() {
		return "/";
	}

	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

}
