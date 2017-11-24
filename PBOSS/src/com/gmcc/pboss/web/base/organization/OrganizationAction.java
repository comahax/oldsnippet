package com.gmcc.pboss.web.base.organization;


import com.gmcc.pboss.business.base.organization.OrganizationDBParam;
import com.gmcc.pboss.business.base.organization.OrganizationVO;
import com.gmcc.pboss.control.base.organization.Organization;
import com.sunrise.jop.ui.struts2.BaseAction;
/**
 * <p>Title: CmpsmsconAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class OrganizationAction extends BaseAction{

	public OrganizationAction(){
		super();
		
		this.setForm(new OrganizationForm());
		this.setParam(new OrganizationDBParam());
		
		setClsVO(OrganizationVO.class);
		
		this.pkNameArray = new String[1];
		pkNameArray[0]="orgid";
		
		this.setClsControl(Organization.class);
		this.setClsQueryParam(OrganizationDBParam.class);
	}
	
	//public String doList() throws Exception{
	//	DictitemDBParam param = (DictitemDBParam) super.getParam();
	//	Dictitem control = (Dictitem) BOFactory.build(DictitemBO.class, super.getDBAccessUser());
	//	DataPackage dp = control.doQuery(param);
	//	setDp(dp);
	//	return "list";
	//}
	//
	public String doSave() throws Exception{
		//DictitemDBParam param = (DictitemDBParam) getParam();
	//	DictitemForm form = (DictitemForm) getForm();
		
		//form.setCompanyid(param.get_ne_companyid());		
		return super.doSave();
		
		//return "content";
	}
	
}

