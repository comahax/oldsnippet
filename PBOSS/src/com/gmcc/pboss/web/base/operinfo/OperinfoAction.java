package com.gmcc.pboss.web.base.operinfo;


import com.gmcc.pboss.business.base.operinfo.OperinfoDBParam;
import com.gmcc.pboss.business.base.operinfo.OperinfoVO;
import com.gmcc.pboss.control.base.operinfo.Operinfo;
import com.sunrise.jop.ui.struts2.BaseAction;
/**
 * <p>Title: CmpsmsconAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class OperinfoAction extends BaseAction{

	public OperinfoAction(){
		super();
		
		this.setForm(new OperinfoForm());
		this.setParam(new OperinfoDBParam());
		
		setClsVO(OperinfoVO.class);
		
		this.pkNameArray = new String[2];
		pkNameArray[0]="operid";
		pkNameArray[1]="region";
		
		
		this.setClsControl(Operinfo.class);
		this.setClsQueryParam(OperinfoDBParam.class);
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

