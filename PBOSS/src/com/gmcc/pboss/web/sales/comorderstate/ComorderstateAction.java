/**
 * auto-generated code
 * Tue Oct 13 09:27:46 CST 2009
 */
 package com.gmcc.pboss.web.sales.comorderstate;

import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.gmcc.pboss.control.sales.comorderstate.Comorderstate;
import com.gmcc.pboss.control.sales.comorderstate.ComorderstateBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: ComorderstateAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComorderstateAction extends BaseAction{
	
	public ComorderstateAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComorderstateForm());
		this.setParam(new ComorderstateWebParam());

        //ָ��VO��
        setClsVO(ComorderstateVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Comorderstate.class);
		this.setClsQueryParam(ComorderstateDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		ComorderstateDBParam param = (ComorderstateDBParam)getParam();
		param.set_se_cityid(cityid);
		
		super.doList();
		return WEB_RESULT_LIST;
	}
	
	public String doNew() throws Exception{
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}
	
	public String doEdit() throws Exception{
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		ComorderstateForm form= (ComorderstateForm) getForm();
		
		//��ѯ��¼�Ƿ��Ѿ�����
		ComorderstateDBParam param = new ComorderstateDBParam();
		param.set_se_cityid(form.getCityid());
		param.set_se_comcategory(form.getComcategory());
		Comorderstate comorderstate = (Comorderstate)BOFactory.build(ComorderstateBO.class, getDBAccessUser());
		
		if (WEB_CMD_EDIT.equals(CMD)) {
			param.set_nne_recid(form.getRecid().toString());
		}
		DataPackage dp = comorderstate.doQuery(param);
		if (dp.getRowCount() > 0) {
			addActionError("��ͬ��¼�Ѿ����ڣ����顣");
			return WEB_RESULT_CONTENT;
		}
		
		//����
		super.doSave();
		setActionMessage("����ɹ�!");
		setCMD(WEB_CMD_SAVE);
		
		return WEB_RESULT_CONTENT;
	}
}