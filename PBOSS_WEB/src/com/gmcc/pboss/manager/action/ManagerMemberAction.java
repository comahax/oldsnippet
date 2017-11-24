package com.gmcc.pboss.manager.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.SessionAware;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.manager.service.ManagerMemberService;
import com.gmcc.pboss.manager.support.ManagerMemberQueryParameter;

public class ManagerMemberAction extends AbstractAction implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2440052551624646830L;
	
	//获取Service，实现主要业务逻辑
	private ManagerMemberService service;
	public void setService(ManagerMemberService service){
		this.service = service;
	}
	//根据公务机号码查询店员
	private String officeTel;
	public void setOfficeTel(String tel){
		this.officeTel = tel;
	}
	public String getOfficeTel(){
		return this.officeTel;
	}
	//查看店员信息
	private String employeeid;
	public void setEmployeeid(String id){
		this.employeeid = id;
	}
	public String getEmployeeid(){
		return this.employeeid;
	}
	//渠道channel,店员信息详情展示中使用
	private Channel empChannel;
	public Channel getEmpChannel() {
		return empChannel;
	}
	public void setEmpChannel(Channel empChannel) {
		this.empChannel = empChannel;
	}
	/**
	 * 跳转到店员列表页面
	 */
	public String doList(){
		this.setTitle(PageLoction.MAG_ASSISTANT_LIST );		
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
		this.setTitle(PageLoction.MAG_ASSISTANT_INFO);
		ServiceResult result = isLogin();
		
		if(result.isSuccess())
			result = service.transact(getMember(), getAssistantParameter(), ServiceType.QUERY);
		if(result.isSuccess()){
			Employee emp = (Employee)result.getRetResult().getData().get(0);
			Channel channel = this.service.getEmployeeChannel(emp.getWayid(), emp.getIsnet());
			this.setEmpChannel(channel);
			setResult(result.getRetResult());
			return SUCCESS;
		}
		else{
			setMessage(result.getMessage());
			return ERROR;
		}	
	}
	
	/**
	 * 获取参数-查询店员，返回店员列表
	 */
	@Override
	public QueryParameter getParameter() {
		ManagerMemberQueryParameter parameter = new ManagerMemberQueryParameter();
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
		if (this.getOfficeTel() != null)
			parameter.setOfficetel(this.getOfficeTel());//设置公务机号码
		
		parameter.setManagerid(this.getMember().getEmployeeid());
		parameter.setAction(QueryAction.SECTION);//需要分页
		//parameter.setOperation( int operation )
		
		return parameter;
	}
	/**
	 * 获取参数-查询店员信息，返回单个店员
	 * @return
	 */
	public QueryParameter getAssistantParameter(){
		ManagerMemberQueryParameter parameter = new ManagerMemberQueryParameter();
		//parameter.setManagerid(this.getMember().getEmployeeid());
		parameter.setEmployeeid(getEmployeeid());
		parameter.setAction(QueryAction.ALL);//不查询总数
		//parameter.setOperation( int operation);
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	//处理session
	Map session;
	public void setSession(Map session){
		this.session = session;
	}

	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("officetel"));
		//setCols.add(new ColumnSet("oprcode", "工号"));
		//setCols.add(new ColumnSet("employeeid"));
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

}
