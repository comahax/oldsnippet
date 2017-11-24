package com.gmcc.pboss.biz.info.salesDetail.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.biz.info.salesDetail.service.EmployeeService;
import com.gmcc.pboss.biz.info.salesDetail.support.EmployeeQueryParameter;

public class EmployeeAction extends AbstractAction {

	//获取查询人员信息的Service
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public EmployeeService getEmployeeService(){
		return this.employeeService;
	}
	
	private String wayid;
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	private String employeeid;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	private String employeename;
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	/**
	 * 进入人员列表弹出框
	 */
	public String doListPopupTab(){
		return SUCCESS;
	}
	/**
	 * 查询人员信息并写入JSON
	 */
	public String doAjaxPopupTab(){
		ServiceResult result = this.employeeService.transact(this.getMember(), this.getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetColsPopupTab());	
		return null;
	}
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		EmployeeQueryParameter parameter = new EmployeeQueryParameter();
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		
		LoginMember logMem = this.getMember();
		if(logMem.getIsnet()==1)
			parameter.setWayid(logMem.getWayid());
		else if(logMem.getIsnet()==4 && StringUtils.isNotEmpty(this.getWayid())){//查询特定网点的店员
			parameter.setWayid(this.getWayid());
		}
		else{//查询经理下属的所有店员
			parameter.setWaymagcode(logMem.getEmployeeid());
		}
		if(StringUtils.isNotEmpty(this.getEmployeeid())){
			parameter.setEmployeeid(this.getEmployeeid());
		}
		if(StringUtils.isNotEmpty(this.getEmployeename())){
			parameter.setEmployeename(this.getEmployeename());
		}
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 获得表头--业务编码列表
	 * @return
	 */
	public List<ColumnSet> getsetColsPopupTab() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("employeeid", "人员编码"));
		setCols.add(new ColumnSet("employeename", "人员姓名"));
		setCols.add(new ColumnSet("oprcode", "人员工号"));
		//setCols.add(new ColumnSet("oper", "操作",true));
		return setCols;
	}
	 /**
	 * 返回页面显示的效果--业务编码列表
	 * @return the colSet
	 */
	public String getShowColsPopupTab() {
		return JSONArray.fromObject(getsetColsPopupTab()).toString();
	}

}
