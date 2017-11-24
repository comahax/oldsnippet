package com.gmcc.pboss.biz.info.node.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.biz.info.node.model.Employee;
import com.gmcc.pboss.biz.info.node.model.TempApply;
import com.gmcc.pboss.biz.info.node.model.Way;
import com.gmcc.pboss.biz.info.node.service.NodeInfoService;
import com.gmcc.pboss.biz.info.node.service.NodeOperation;
import com.gmcc.pboss.biz.info.node.support.NodeInfoQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;

public class NodeAction extends AbstractAction {

	private NodeInfoService service;

	private NodeInfoQueryParameter parameter;
	/**
	 * 保存对象
	 */
	private ChPwWayapply apply;
	/**
	 * 渠道信息临时对象 用于显示，不保存
	 */
	private Way temWay;
	
	/**输入验证码*/
	private String vaildateCode;
	private String _backURL;
	/**
	 * 卡类购销划扣银行状态
	 */
	private int destate;
	/**
	 * @return the apply
	 */
	public ChPwWayapply getApply() {
		return apply;
	}

	/**
	 * @param apply the apply to set
	 */
	public void setApply(ChPwWayapply apply) {
		this.apply = apply;
	}

	/**
	 * @return the vaildateCode
	 */
	public String getVaildateCode() {
		return vaildateCode;
	}

	/**
	 * @param vaildateCode the vaildateCode to set
	 */
	public void setVaildateCode(String vaildateCode) {
		this.vaildateCode = vaildateCode;
	}

	/**
	 * @return the temWay
	 */
	public Way getTemWay() {
		return temWay;
	}

	/**
	 * @param temWay the temWay to set
	 */
	public void setTemWay(Way temWay) {
		this.temWay = temWay;
	}

	/**
	 * @return the _backURL
	 */
	public String get_backURL() {
		return _backURL;
	}

	/**
	 * @param _backurl the _backURL to set
	 */
	public void set_backURL(String _backurl) {
		_backURL = _backurl;
	}

	public NodeInfoService getService() {
		return service;
	}

	public void setService(NodeInfoService service) {
		this.service = service;
	}

	/**
	 * @return the destate
	 */
	public int getDestate() {
		return destate;
	}

	/**
	 * @param destate the destate to set
	 */
	public void setDestate(int destate) {
		this.destate = destate;
	}

	public QueryParameter getParameter() {
		parameter = new NodeInfoQueryParameter();
		LoginMember member = getMember();
		parameter.setEmployeeId(member.getEmployeeid());
		parameter.setOperation(NodeOperation.NODEINFO_QUERY);
		return parameter;
	}

	public void setParameter(NodeInfoQueryParameter parameter) {
		this.parameter = parameter;
	}

	public void prepare() throws Exception {

	}

	public String doSubmit(){
		this.setTitle(PageLoction.NodeQuery);
		//设置提交默认值
		if (this.apply == null) return ERROR;//空提交
		//设置默认值
		LoginMember member = getMember();
		this.apply.setCityid(member.getCityid());
		this.apply.setWayid(member.getWayid());
		if (this.destate == 0) apply.setDestate(false); else apply.setDestate(true);
		//判断验证码
		ServiceResult validateImage = validateImageCode(this.getVaildateCode());
		if (!validateImage.isSuccess()){
			addFieldError("vaildateCode", "验证码输入有误！");
			return INPUT;
		}
		
		NodeInfoQueryParameter saveParm = new NodeInfoQueryParameter();
		saveParm.setSaveObj(this.getApply());
		saveParm.setOperation(NodeOperation.NODEINFO_UPDATE);
		saveParm.setEmployeeId(parameter.getEmployeeId());
		
		ServiceResult serviceRslt;
		//
		try{
			serviceRslt = service.transactionProcessing(member, saveParm, ServiceType.MODIFY);
		}
		catch(TransactionProcessionException e){
			//记录异常信息
			serviceRslt = new ServiceResult();
			serviceRslt.setSuccess(false);
			serviceRslt.setRetCode(ServiceRetCode.EXCEPTION);
			serviceRslt.setMessage(ConfigUtil.getMessage(ServiceCode.NODE, ServiceRetCode.EXCEPTION));

			//记录异常信息
			this.setMessage(serviceRslt.getMessage());
			logger.error("WayApplyAction:"+e.getMessage());//输出到用户
		}
		this.setMessage(serviceRslt.getMessage());

		if (serviceRslt.isSuccess()) {
			this.setTitle(PageLoction.NodeQuery);
			set_backURL(INDEX);
			return SUCCESS;
		} else {
			//构造错误对象
			List lst = new ArrayList();
			lst.add(this.apply);
			
			QueryResult rtn = new QueryResult(null, lst);
			this.setResult(rtn);
			
			return INPUT;
		}
	}
	

	public String doList() {
		this.setTitle(PageLoction.NodeQuery);
		LoginMember member = getMember();
		
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		//赋新值
		if (!result.isSuccess()) {
			this.setMessage(result.getMessage());
			this.set_backURL(INDEX);
			return ERROR;	
		}
		List rtnList = result.getRetResult().getData();
		if (rtnList.size()>0){
			Employee emp = (Employee) rtnList.get(0);
			apply = new ChPwWayapply();
			apply.add("employeeId", getLogMember().getEmployeeid());
			temWay = new Way();
			try {
				if (emp.getContact()!= null) 
					BeanUtils.copyProperties(apply, emp.getContact());
				if (emp.getWay()!= null) {
					BeanUtils.copyProperties(temWay, emp.getWay());
					BeanUtils.copyProperties(apply, temWay);
				}
				if (emp.getWayAccount()!= null)
					BeanUtils.copyProperties(apply, emp.getWayAccount());
				if (emp.getCooperator()!=null)
					BeanUtils.copyProperties(apply, emp.getCooperator());
				//使用中间类过渡Employee的属性，当页面需要增加信息时，必须通过此中间类增加
				TempApply temp = new TempApply();
				BeanUtils.copyProperties(temp, emp);
				BeanUtils.copyProperties(apply, emp);
				
				//@modify 手机号码使用employee的officeTal
				apply.setPrincipaltel(emp.getOfficetel());

				if (apply.getDestate()==null || !apply.getDestate()) this.destate = 0; else this.destate=1;
				//翻译渠道星级
				temWay.setStrStarlevel(Constant.getConstantName(ConstantsType.STARLEVEL, temWay.getStarlevel().toString()));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("::"+e.getMessage());
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("::"+e.getMessage());
			}
		}//if
//		setMessage(result.getMessage());
		
//		setResult(result.getRetResult());
		return SUCCESS;
	}
	/**
	 * 加载退出申请页面
	 * @return
	 */
	public String doLoadQuit(){
		this.setTitle(PageLoction.NodeQuit);
		return SUCCESS;
	}
	/**
	 * 退出
	 * @return
	 */
	public String doQuit(){
		this.setTitle(PageLoction.NodeQuit);
		//设置提交默认值
		if (this.apply == null) return ERROR;//空提交
		//设置默认值
		LoginMember member = getMember();
		this.apply.setCityid(member.getCityid());
		this.apply.setWayid(member.getWayid());
		//判断验证码
		ServiceResult validateImage = validateImageCode(this.getVaildateCode());
		if (!validateImage.isSuccess()){
			addFieldError("vaildateCode", "验证码输入有误！");
			return INPUT;
		}
		
		NodeInfoQueryParameter saveParm = new NodeInfoQueryParameter();
		saveParm.setSaveObj(this.getApply());
		saveParm.setOperation(NodeOperation.NODE_QUITE);
		
		ServiceResult serviceRslt;
		
		try{
			serviceRslt = service.transactionProcessing(member, saveParm, ServiceType.CANCEL);
		}
		catch(TransactionProcessionException e){
			//记录异常信息
			serviceRslt = new ServiceResult();
			serviceRslt.setSuccess(false);
			serviceRslt.setRetCode(ServiceRetCode.EXCEPTION);
			serviceRslt.setMessage(ConfigUtil.getMessage(ServiceCode.NODE, ServiceRetCode.EXCEPTION));

			//记录异常信息
			this.setMessage(serviceRslt.getMessage());
			logger.error("WayApplyAction:"+e.getMessage());//输出到用户
		}
		this.setMessage(serviceRslt.getMessage());

		if (serviceRslt.isSuccess()) {
			this.setTitle(PageLoction.NodeQuit);
			set_backURL(INDEX);
			return SUCCESS;
		} else {
			//构造错误对象
			List lst = new ArrayList();
			lst.add(this.apply);
			
			QueryResult rtn = new QueryResult(null, lst);
			this.setResult(rtn);
			
			return INPUT;
		}
	}

	
	
}
