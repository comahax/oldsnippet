package com.gmcc.pboss.member.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.SessionAware;

import com.common.util.string.CharacterStrUtil;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.member.service.EmployeeApplyService;
import com.gmcc.pboss.member.service.IMemberService;
import com.gmcc.pboss.member.service.MemberOperation;
import com.gmcc.pboss.member.support.EmployeeApplyParameter;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;

/**
 * 从兴公司电子渠道业务部
 * 
 * @author tangzhu
 * @date 2009-7-29 所属项目： 所属模块： 描述：
 */
public class MemberAction extends AbstractAction implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6644795173501650692L;
	/**
	 * 公务机号码
	 */
	private String officeTel;
	/**
	 * 输入验证码
	 */
	private String inputCode;
	private String _backURL;
	
	private IMemberService service;
	/**输入验证码*/
	private String vaildateCode;
	
	/**人员编码*/
	private String employeeid;
	
	/**
	 * 店员增删对象 
	 */
	private ChPwEmployeeapply apply;
	/**
	 * 提交ACTION
	 */
	private String doAction;
	/**
	 * 提交申请业务的Service
	 */
	private EmployeeApplyService employeeApplyService;
	
	/**
	 * 跳转到店员列表页面
	 */
	public String doList(){
		this.setTitle(PageLoction.ShopAssistantList );
		return SUCCESS;
	}
	
	/**
	 * 经理界面-跳转到网点列表
	 */
	public String doNodeList(){
		this.setTitle(PageLoction.MAG_NODE_LIST);
		return SUCCESS;
	}
	/**
	 * 
	 */
	public String doAssistantList(){
		this.setTitle(PageLoction.MAG_ASSISTANT_LIST);
		return SUCCESS;
	}
	
	
	/**
	 * 查询店员
	 * @return
	 */
	public String doAjaxList(){
		
		ServiceResult result = null;
		
		result = isLogin();
		
		if(result.isSuccess())
			result = service.transact(getMember(), getParameter(), ServiceType.QUERY);
		
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * 查询某个店员
	 */
	public String doLoad() {
		String actionname = this.getActionMapping().getName();
		if ("quit".equals(actionname.toLowerCase())){
			this.setTitle(PageLoction.ShopAssistantQuit);
		}else{
			this.setTitle(PageLoction.ShopAssistantLoad);
		}
		ServiceResult result = isLogin();
		
		if(result.isSuccess())
			result = service.transact(getMember(), getAssistantParameter(), ServiceType.QUERY);
		
		if(result.isSuccess()){
			setResult(result.getRetResult());
			this.setDoAction(ConstantsType.ACTION_UPDATE);
			return SUCCESS;
		}
		else{
			setMessage(result.getMessage());
			set_backURL("/assistant/List.do");
			return ERROR;
		}
		
	}
	
	public String doJoin(){
		//构造对象
		setTitle(PageLoction.ShopAssistantJoin);
		this.setApply(new ChPwEmployeeapply());
		this.setDoAction(ConstantsType.ACTION_ADD);
		List<ChPwEmployeeapply> lst = new ArrayList<ChPwEmployeeapply>();
		lst.add(this.apply);
		
		QueryResult rtn = new QueryResult(null, lst);
		this.setResult(rtn);
		
		return this.execute();
	}
	/**
	 * 提交申请
	 * @return
	 */
	public String doSubmit(){
		if (apply == null) return ERROR;//没有对象提交
		//判断验证码
		ServiceResult validateImage = validateImageCode(this.getVaildateCode());
		if (!validateImage.isSuccess()){
			addFieldError("vaildateCode", "验证码输入有误！");
			//构造错误对象
			List<ChPwEmployeeapply> lst = new ArrayList<ChPwEmployeeapply>();
			lst.add(this.apply);
			
			QueryResult rtn = new QueryResult(null, lst);
			this.setResult(rtn);

			//构造对象
			if (ConstantsType.ACTION_ADD.equals(this.getDoAction())){
				setTitle(PageLoction.ShopAssistantJoin);
			}else {
				setTitle(PageLoction.ShopAssistantLoad);
			}
			return INPUT;
		}
		EmployeeApplyParameter saveParam = new EmployeeApplyParameter();
		LoginMember member = getMember();
		this.apply.setWayid(member.getWayid());//设置入库信息：渠道号
		
		ServiceResult result;
		
		//初始化参数
		saveParam.setApply(this.getApply());
		saveParam.setDoAction(this.getDoAction());
		
		if(!CharacterStrUtil.isBlank(saveParam.getDoAction())){
			if (ConstantsType.ACTION_ADD.equals(saveParam.getDoAction())){
				saveParam.setOperation(MemberOperation.ASSISTANCES_SAVE);
			}else{
				saveParam.setOperation(MemberOperation.ASSISTANCES_UPDATE);
			}
		}
		
		try{
			result = this.employeeApplyService.transactionProcessing(member, saveParam, ServiceType.MODIFY);
		}
		catch(Exception e){
			//记录异常信息
			result = new ServiceResult();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
			result.setMessage(ConfigUtil.getMessage(ServiceCode.EMPLOYEE, ServiceRetCode.EXCEPTION));
			
			this.setMessage(result.getMessage());
			logger.error("WayApplyAction:"+e.getMessage());//输出到用户
		}
		
		if (result.isSuccess()){
			this.setTitle(PageLoction.ShopAssistantLoad);
			setMessage(result.getMessage());
			set_backURL("/assistant/List.do");
			return SUCCESS;
		}else{
			//构造错误对象
			List<ChPwEmployeeapply> lst = new ArrayList<ChPwEmployeeapply>();
			lst.add(this.apply);
			
			QueryResult rtn = new QueryResult(null, lst);
			this.setResult(rtn);

			//构造对象
			if (ConstantsType.ACTION_ADD.equals(this.getDoAction())){
				setTitle(PageLoction.ShopAssistantJoin);
			}else {
				setTitle(PageLoction.ShopAssistantLoad);
			}
			addFieldError("runError", result.getMessage());
			return INPUT;
//			setMessage(result.getMessage());
		}
	}
	/**
	 * 店员退出申请
	 * @return
	 */
	public String doQuit(){
		if (apply == null) return ERROR;//没有对象提交
		//判断验证码
		ServiceResult validateImage = validateImageCode(this.getVaildateCode());
		if (!validateImage.isSuccess()){
			addFieldError("vaildateCode", "验证码输入有误！");
			//构造错误对象
			List<ChPwEmployeeapply> lst = new ArrayList<ChPwEmployeeapply>();
			lst.add(this.apply);
			
			QueryResult rtn = new QueryResult(null, lst);
			this.setResult(rtn);
			this.setTitle(PageLoction.ShopAssistantQuit);
			return INPUT;
		}
		EmployeeApplyParameter saveParam = new EmployeeApplyParameter();
		LoginMember member = getMember();
		this.apply.setWayid(member.getWayid());//设置入库信息：渠道号
		
		saveParam.setApply(this.getApply());
		saveParam.setOperation(MemberOperation.ASSISTANCES_QUITE);
		
		ServiceResult result;
		
		try{
			result = this.employeeApplyService.transactionProcessing(member, saveParam, ServiceType.CANCEL);
		}catch(Exception e){
			//记录异常信息
			result = new ServiceResult();
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
			result.setMessage(ConfigUtil.getMessage(ServiceCode.EMPLOYEE, ServiceRetCode.EXCEPTION));
			
			this.setMessage(result.getMessage());
			logger.error("WayApplyAction:"+e.getMessage());//输出到用户
		}
		
		if (result.isSuccess()){
			this.setTitle(PageLoction.ShopAssistantQuit);
			setMessage(result.getMessage());
			set_backURL("/assistant/List.do");
			return SUCCESS;
		}else{
			//构造错误对象
			List<ChPwEmployeeapply> lst = new ArrayList<ChPwEmployeeapply>();
			lst.add(this.apply);
			
			QueryResult rtn = new QueryResult(null, lst);
			setTitle(PageLoction.ShopAssistantQuit);
			this.setResult(rtn);
			addFieldError("runError", result.getMessage());
			return INPUT;
//			setMessage(result.getMessage());
		}
	}
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("officetel"));
//		setCols.add(new ColumnSet("oprcode", "工号"));
		setCols.add(new ColumnSet("employeeid"));
		setCols.add(new ColumnSet("employeeid", "人员编号"));
		setCols.add(new ColumnSet("employeename", "姓名"));
		setCols.add(new ColumnSet("intime", "入职时间"));
		setCols.add(new ColumnSet("officetel", "公务机号码"));
		setCols.add(new ColumnSet("empstatusName", "用工状态"));
		setCols.add(new ColumnSet("oper", "操作",true));
		
		return setCols;
	}

	 /**
	 * 返回页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}
	
	
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(">>>>prepare");

	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	/**
	 * 返回分页查询店员的查询参数对象
	 */
	public QueryParameter getParameter() {
		MemberQueryParameter parameter = new MemberQueryParameter();
		
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		if(this.getOfficeTel() != null)
			parameter.setOfficeTel(getOfficeTel());
		
		parameter.setWayId(getMember().getWayid());
		parameter.setOperation(MemberOperation.ASSISTANCES_QUERY);
		
		return parameter;
	}
	/***
	 * 得到单个店员查询条件
	 * @return
	 */
	public QueryParameter getAssistantParameter(){
		MemberQueryParameter parameter = new MemberQueryParameter();
		parameter.setWayId(getMember().getWayid());
		//parameter.setOfficeTel(getOfficeTel());
		parameter.setEmployeeid(getEmployeeid());
		parameter.setAction(QueryAction.ALL);//不查询总数
		parameter.setOperation(MemberOperation.ASSISTANCEINFO_QUERY);
		//System.out.println("WayId["+getMember().getWayid()+"]OfficeTel["+getOfficeTel()+"]");
		return parameter;
	}
	public IMemberService getService() {
		return service;
	}

	public void setService(IMemberService service) {
		this.service = service;
	}

	public String get_backURL() {
		return _backURL;
	}

	public void set_backURL(String _backurl) {
		_backURL = _backurl;
	}

	/**
	 * @return the apply
	 */
	public ChPwEmployeeapply getApply() {
		return apply;
	}

	/**
	 * @param apply the apply to set
	 */
	public void setApply(ChPwEmployeeapply apply) {
		this.apply = apply;
	}

	/**
	 * @return the employeeApplyService
	 */
	public EmployeeApplyService getEmployeeApplyService() {
		return employeeApplyService;
	}

	/**
	 * @param employeeApplyService the employeeApplyService to set
	 */
	public void setEmployeeApplyService(EmployeeApplyService employeeApplyService) {
		this.employeeApplyService = employeeApplyService;
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
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
	 * @return the doAction
	 */
	public String getDoAction() {
		return doAction;
	}
	/**
	 * @param doAction the doAction to set
	 */
	public void setDoAction(String doAction) {
		this.doAction = doAction;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	
//	public int getLoginType() {
//		return loginType;
//	}
//
//	public void setLoginType(int loginType) {
//		this.loginType = loginType;
//	}

}
