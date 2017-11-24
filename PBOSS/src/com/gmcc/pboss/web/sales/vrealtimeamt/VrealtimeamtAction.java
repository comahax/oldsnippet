/**
 * auto-generated code
 * Wed Sep 08 17:44:18 CST 2010
 */
 package com.gmcc.pboss.web.sales.vrealtimeamt;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.vrealtimeamt.Vrealtimeamt;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: VrealtimeamtAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class VrealtimeamtAction extends BaseAction{
	
	public VrealtimeamtAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new VrealtimeamtForm());
		this.setParam(new VrealtimeamtDBParam());

        //ָ��VO��
        setClsVO(VrealtimeamtVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"wayid","comcategory"};
		this.setClsControl(Vrealtimeamt.class);
		this.setClsQueryParam(VrealtimeamtDBParam.class)
		;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	/**
	 * �����̶�����ʵʱ��ѯ��������
	 * @return
	 */
	public String doExcel(){
		try{
			VrealtimeamtDBParam employeeParam = (VrealtimeamtDBParam)super.getParam();
			employeeParam.setQueryAll(true);
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			export.setFileName("�����̶�����ʵʱ��ѯ");
			// export.addOutputProperty(0,"business","Ӫҵ��",null,null);
			export.appendHeadLine(new String[] { "��������:",user.getOprcode() });
			export.appendHeadLine(new String[] { "��������:", user.getWayid() });
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("mareacode", "΢����",export.CODE2NAME, "#MICROAREA");
			export.addOutputProperty("wayid", "�����̱���");
			export.addOutputProperty("wayid", "����������",export.CODE2NAME, "#WAY");
			export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME, "$CH_STARLEVEL");
			export.addOutputProperty("brand", "Ʒ��",export.CODE2NAME, "$FX_SMPBRAND");
			export.addOutputProperty("comcategory", "��Ʒ����",export.CODE2NAME, "$IM_FXCOMCATEGORY");
			export.addOutputProperty("monordered", "���¶�����",export.NUMBER,"#");
			export.addOutputProperty("dayordered", "���충����",export.NUMBER,"#");
			export.addOutputProperty("nowstock", "�����",export.NUMBER,"#");
			export.addOutputProperty("orderdstock", "�ڶ������",export.NUMBER,"#");
			
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			return super.doExcel();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
}