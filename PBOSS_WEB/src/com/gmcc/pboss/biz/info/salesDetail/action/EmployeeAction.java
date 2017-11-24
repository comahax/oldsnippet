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

	//��ȡ��ѯ��Ա��Ϣ��Service
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
	 * ������Ա�б�����
	 */
	public String doListPopupTab(){
		return SUCCESS;
	}
	/**
	 * ��ѯ��Ա��Ϣ��д��JSON
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
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		
		LoginMember logMem = this.getMember();
		if(logMem.getIsnet()==1)
			parameter.setWayid(logMem.getWayid());
		else if(logMem.getIsnet()==4 && StringUtils.isNotEmpty(this.getWayid())){//��ѯ�ض�����ĵ�Ա
			parameter.setWayid(this.getWayid());
		}
		else{//��ѯ�������������е�Ա
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
	 * ��ñ�ͷ--ҵ������б�
	 * @return
	 */
	public List<ColumnSet> getsetColsPopupTab() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("employeeid", "��Ա����"));
		setCols.add(new ColumnSet("employeename", "��Ա����"));
		setCols.add(new ColumnSet("oprcode", "��Ա����"));
		//setCols.add(new ColumnSet("oper", "����",true));
		return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��--ҵ������б�
	 * @return the colSet
	 */
	public String getShowColsPopupTab() {
		return JSONArray.fromObject(getsetColsPopupTab()).toString();
	}

}
