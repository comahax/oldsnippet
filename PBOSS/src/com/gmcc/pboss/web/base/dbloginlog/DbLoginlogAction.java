/**
 * auto-generated code
 * Wed Sep 21 15:48:50 CST 2011
 */
 package com.gmcc.pboss.web.base.dbloginlog;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.dbloginlog.DbLoginlogVO ;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.base.dbloginlog.DbLoginlogDBParam;
import com.gmcc.pboss.business.base.role.RoleDBParam;
import com.gmcc.pboss.business.base.role.RoleVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dbloginlog.DbLoginlog ;
import com.gmcc.pboss.web.channel.employee.EmployeeWebParam;

/**
 * <p>Title: DbLoginlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class DbLoginlogAction extends BaseAction{
	
	public DbLoginlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new DbLoginlogForm());
		this.setParam(new DbLoginlogDBParam());

        //ָ��VO��
        setClsVO(DbLoginlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(DbLoginlog.class);
		this.setClsQueryParam(DbLoginlogDBParam.class) ;

	}

	@Override
	public String doView() throws Exception {
		// TODO Auto-generated method stub
		return WEB_RESULT_LIST;
	}
	
	
	
	@Override
	public String doList() throws Exception {
		 ((DbLoginlogDBParam)this.getParam()).set_se_cityid(this.getDBAccessUser().getCityid());		
		return super.doList();
	}

	public String doTxt() throws Exception {
		 ((DbLoginlogDBParam)this.getParam()).set_se_cityid(this.getDBAccessUser().getCityid());
		DbLoginlogDBParam dbloginlogparam = (DbLoginlogDBParam) super.getParam();
		dbloginlogparam.setQueryAll(true);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("ϵͳ��¼��־����");

		export.addOutputProperty("logid", "��־��ʶ");
		export.addOutputProperty("oprcode", "����Ա����");
		export.addOutputProperty("wayid", "��������",export.CODE2NAME,"#WAY");
		export.addOutputProperty("cityid", "����",export.CODE2NAME,"#CITYCOMPANY");
		export.addOutputProperty("logintime", "��¼ʱ��");
		export.addOutputProperty("ipaddress", "IP��ַ");
		export.addOutputProperty("issuccess", "�Ƿ��¼�ɹ�",export.CODE2NAME,"DBLOGINLOG");
		export.addOutputProperty("memo", "��ע");
		
		export.voClassArray = new Class[] { DbLoginlogVO.class };

		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��־��ʶ","����Ա����", "��������", "����","��¼ʱ��","IP��ַ","�Ƿ��¼�ɹ�","��ע" });	
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel(){
		try{
			 ((DbLoginlogDBParam)this.getParam()).set_se_cityid(this.getDBAccessUser().getCityid());
			DbLoginlogDBParam dbloginlogpram = (DbLoginlogDBParam)super.getParam();
			dbloginlogpram.setQueryAll(true);
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("ϵͳ��¼��־����");

			export.addOutputProperty("logid", "��־��ʶ");
			export.addOutputProperty("oprcode", "����Ա����");
			export.addOutputProperty("wayid", "��������",export.CODE2NAME,"#WAY");
			export.addOutputProperty("cityid", "����",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("logintime", "��¼ʱ��");
			export.addOutputProperty("ipaddress", "IP��ַ");
			export.addOutputProperty("issuccess", "�Ƿ��¼�ɹ�",export.CODE2NAME,"DBLOGINLOG");
			export.addOutputProperty("memo", "��ע");

			export.appendHeadLine(new String[] { "��������:",user.getOprcode() });
			export.appendHeadLine(new String[] { "��������:", user.getWayid() });
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			return super.doExcel();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
}