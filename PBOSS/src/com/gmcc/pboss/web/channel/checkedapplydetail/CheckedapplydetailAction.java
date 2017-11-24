/**
 * auto-generated code
 * Tue Jun 05 08:33:24 CST 2012
 */
 package com.gmcc.pboss.web.channel.checkedapplydetail;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.ViewCADVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapply.Checkedapply;
import com.gmcc.pboss.control.channel.checkedapply.CheckedapplyBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: CheckedapplydetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CheckedapplydetailAction extends BaseAction{
	
	// ӵ�зֹ�˾����
	private boolean CH_CHECKED_COUNTY;
	// ӵ���й�˾��������
	private boolean CH_CHECKED_MIDCITY;
	// ϵͳ��������Ȩ���㼸���������
	private boolean paramvalue;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCH_CHECKED_COUNTY() {
		return CH_CHECKED_COUNTY;
	}

	public void setCH_CHECKED_COUNTY(boolean ch_checked_county) {
		CH_CHECKED_COUNTY = ch_checked_county;
	}
	
	/**
	 * 1���ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�(systemid=83, paramtype=��channel��)����ֵΪ1
	 * 2���жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
	 * 3���жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
	 * @throws Exception
	 */
	private void getSysParme() throws Exception {
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
		String value = sysparam.doFindByID("83", "channel");
		if (value != null && value.equals("1")) {
			paramvalue = true;
		}
		
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		boolean ch_checked_county = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_COUNTY");
		setCH_CHECKED_COUNTY(ch_checked_county);
		
		boolean ch_checked_midcity = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_MIDCITY");
		this.setCH_CHECKED_MIDCITY(ch_checked_midcity);
	}

	public CheckedapplydetailAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CheckedapplydetailForm());
		this.setParam(new CheckedapplydetailDBParam());

        //ָ��VO��
        setClsVO(CheckedapplydetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seq"};
		this.setClsControl(Checkedapplydetail.class);
		this.setClsQueryParam(CheckedapplydetailDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try{
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			CheckedapplydetailDBParam checkedapplydetailDBParam = (CheckedapplydetailDBParam)getParam();
			/*
			 * �ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�����ֵΪ1
			 * �жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
			 * �жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
			 */
			getSysParme();
			
			DataPackage temPackage = checkedapplydetailBO.doQueryCheckedapplydetail(checkedapplydetailDBParam);
			
			this.setDp(temPackage);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	public String doSave() throws Exception{
		CheckedapplydetailForm fheckedapplydetailForm = (CheckedapplydetailForm)getForm();
		String chktype = fheckedapplydetailForm.getChktype();
		if(chktype == null || "".equals(chktype)){
			super.addActionError("���˷�ʽ������Ϊ��");
			return WEB_RESULT_CONTENT;
		}
		
		return super.doSave();
	}
	
	public String doEdit() throws Exception{
		BaseVO vo = findVOFromDB();
		CheckedapplydetailForm form = (CheckedapplydetailForm)getForm(); 
		BeanUtils.copyProperties(form, vo);
		
		Checkedapply checkedapply = (Checkedapply)BOFactory.build(CheckedapplyBO.class,getDBAccessUser());
		CheckedapplyVO checkedapplyVO =checkedapply.doFindByPk(form.getApplyno());
		setStatus(checkedapplyVO.getStatus());
		setForm(form);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	};
	
	//����Excel
	public String doExportExcel(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("��Ȩ������ϸ��ѯ");
			
			export.voClassArray = new Class[] {ViewCADVO.class};
			export.queryMethodName = "doQueryCheckedapplydetail";
			
			export.addOutputProperty("seq", "���к�");
			export.addOutputProperty("applyno", "���뵥��");
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("wtype", "��������",export.CODE2NAME,"$CH_WTYPE");
			export.addOutputProperty("chainhead", "����������",export.CODE2NAME,"#WAYIDINFO");
			export.addOutputProperty("wayname", "��������");
			export.addOutputProperty("wayid", "��������");
			export.addOutputProperty("address", "��ϸ��ַ");
			export.addOutputProperty("buztypecode", "��Ȧ����",export.CODE2NAME,"$CH_BUZTYPE");
			export.addOutputProperty("chktype", "���˷�ʽ",export.CODE2NAME,"$CH_ASSESSMTHD");
			export.addOutputProperty("starlevel", "�Ǽ�����",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("status", "����״̬",export.CODE2NAME,"$CH_APPSTATUS");
			export.addOutputProperty("applytype", "��������",export.CODE2NAME,"$CH_CHECKTYPE");
			export.addOutputProperty("waystatus", "��������״̬",export.CODE2NAME,"$CH_WAYSTATUS");
			export.addOutputProperty("aptime", "����ʱ��");
			export.addOutputProperty("oprtime", "���ʱ��"); 
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	public String doQueryCheckedapplydetail() throws Exception {
		try {
			CheckedapplydetailDBParam checkedapplydetailDBParam = (CheckedapplydetailDBParam)getParam();
			
			//ȫ����ѯ
			checkedapplydetailDBParam.setQueryAll(true);
			
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			DataPackage temPackage = checkedapplydetailBO.doQueryCheckedapplydetail(checkedapplydetailDBParam);
			
			setDp(temPackage);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}

	public boolean isCH_CHECKED_MIDCITY() {
		return CH_CHECKED_MIDCITY;
	}

	public void setCH_CHECKED_MIDCITY(boolean ch_checked_midcity) {
		CH_CHECKED_MIDCITY = ch_checked_midcity;
	}

	public boolean isParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(boolean paramvalue) {
		this.paramvalue = paramvalue;
	}
}